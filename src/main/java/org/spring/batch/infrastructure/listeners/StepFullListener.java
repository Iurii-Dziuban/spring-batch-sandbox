package org.spring.batch.infrastructure.listeners;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepListenerSupport;
import org.springframework.batch.core.scope.context.ChunkContext;

import java.util.List;

/**
 * Created by iurii.dziuban on 19.07.2016.
 *
 * Full step listener with all possible event handling and logging
 */
public class StepFullListener extends StepListenerSupport<Transaction, Transaction> {

    private static final Log LOGGER = LogFactory.getLog(StepFullListener.class);

    public ExitStatus afterStep(StepExecution stepExecution) {
        LOGGER.info("AfterStep event of StepFullListener");
        return null;
    }

    public void beforeStep(StepExecution stepExecution) {
        LOGGER.info("BeforeStep event of StepFullListener");
    }

    public void afterChunk(ChunkContext context) {
        LOGGER.info("AfterChunk event of StepFullListener");
    }

    public void beforeChunk(ChunkContext context) {
        LOGGER.info("BeforeChunk event of StepFullListener");
    }

    public void afterRead(Transaction item) {
        LOGGER.info("AfterRead event of StepFullListener");
    }

    public void beforeRead() {
        LOGGER.info("BeforeRead event of StepFullListener");
    }

    public void onReadError(Exception ex) {
        LOGGER.info("OnReadError event of StepFullListener");
    }

    public void afterWrite(List<? extends Transaction> items) {
        LOGGER.info("AfterWrite event of StepFullListener");
    }

    public void beforeWrite(List<? extends Transaction> items) {
        LOGGER.info("BeforeWrite event of StepFullListener");
    }

    public void onWriteError(Exception exception, List<? extends Transaction> items) {
        LOGGER.info("OnWriteError event of StepFullListener");
    }

    public void afterProcess(Transaction item, Transaction result) {
        LOGGER.info("AfterProcess event of StepFullListener");
    }

    public void beforeProcess(Transaction item) {
        LOGGER.info("BeforeProcess event of StepFullListener");
    }

    public void onProcessError(Transaction item, Exception e) {
        LOGGER.info("OnProcessError event of StepFullListener");
    }

    public void onSkipInProcess(Transaction item, Throwable t) {
        LOGGER.info("OnSkipInProcess event of StepFullListener");
    }

    public void onSkipInRead(Throwable t) {
        LOGGER.info("OnSkipInRead event of StepFullListener");
    }

    public void onSkipInWrite(Transaction item, Throwable t) {
        LOGGER.info("OnSkipInWrite event of StepFullListener");
    }

    public void afterChunkError(ChunkContext context) {
        LOGGER.info("AfterChunkError event of StepFullListener");
    }
}
