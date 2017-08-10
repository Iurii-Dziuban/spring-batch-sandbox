package org.batch.integration.spring_integration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.core.listener.ItemListenerSupport;
import org.springframework.batch.item.file.FlatFileParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import org.batch.integration.spring_integration.model.Notification;
import java.util.List;

/**
 * Created by iurii.dziuban on 17.08.2016.
 *
 * Chunk listener to send error messages to spring integration endpoint
 */
public class TransactionChunkListener extends ItemListenerSupport<Transaction, Transaction> {

    private static final Log LOGGER = LogFactory.getLog(TransactionChunkListener.class);

    @Autowired
    @Qualifier("chunkExecutions")
    private MessageChannel chunkNotificationsChannel;

    @Override
    public void onReadError(Exception ex) {
        LOGGER.error("TransactionChunkListener onReadError");
        if (ex instanceof FlatFileParseException) {
            FlatFileParseException ffpe = (FlatFileParseException) ex;
            LOGGER.error(String.format("Error reading data on line '%s' - data: '%s'", ffpe.getLineNumber(), ffpe.getInput()));
        }
        chunkNotificationsChannel.send(MessageBuilder.withPayload(new Notification(ex.getMessage(),true)).build());
    }

    @Override
    public void onWriteError(Exception ex, List<? extends Transaction> item) {
    }
}

