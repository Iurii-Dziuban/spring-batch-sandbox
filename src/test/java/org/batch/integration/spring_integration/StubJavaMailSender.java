package org.batch.integration.spring_integration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;

import javax.mail.internet.MimeMessage;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by iurii.dziuban on 17.08.2016.
 *
 * Stub of email sender with logging
 */
public class StubJavaMailSender implements JavaMailSender {

    private static final Log LOGGER = LogFactory.getLog(StubJavaMailSender.class);

    private MimeMessage uniqueMessage;

    private final List<MimeMessage> sentMimeMessages = new ArrayList<MimeMessage>();

    private final List<SimpleMailMessage> sentSimpleMailMessages = new ArrayList<SimpleMailMessage>();

    public StubJavaMailSender(MimeMessage uniqueMessage) {
        this.uniqueMessage = uniqueMessage;
    }

    public List<MimeMessage> getSentMimeMessages() {
        return this.sentMimeMessages;
    }

    public List<SimpleMailMessage> getSentSimpleMailMessages() {
        return this.sentSimpleMailMessages;
    }

    public MimeMessage createMimeMessage() {
        return this.uniqueMessage;
    }

    public MimeMessage createMimeMessage(InputStream contentStream) throws MailException {
        return this.uniqueMessage;
    }

    public void send(MimeMessage mimeMessage) throws MailException {
        this.sentMimeMessages.add(mimeMessage);
    }

    public void send(MimeMessage[] mimeMessages) throws MailException {
        this.sentMimeMessages.addAll(Arrays.asList(mimeMessages));
    }

    public void send(MimeMessagePreparator mimeMessagePreparator) throws MailException {
        throw new UnsupportedOperationException("MimeMessagePreparator not supported");
    }

    public void send(MimeMessagePreparator[] mimeMessagePreparators) throws MailException {
        throw new UnsupportedOperationException("MimeMessagePreparator not supported");
    }

    public void send(SimpleMailMessage simpleMessage) throws MailException {
        LOGGER.info("Message " + simpleMessage);
        this.sentSimpleMailMessages.add(simpleMessage);
    }

    public void send(SimpleMailMessage[] simpleMessages) throws MailException {
        this.sentSimpleMailMessages.addAll(Arrays.asList(simpleMessages));
    }

    public void reset() {
        this.sentMimeMessages.clear();
        this.sentSimpleMailMessages.clear();
    }
}
