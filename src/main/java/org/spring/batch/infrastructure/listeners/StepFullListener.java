package org.spring.batch.infrastructure.listeners;

import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepListenerSupport;
import org.springframework.batch.core.scope.context.ChunkContext;

import java.util.List;

/**
 * Created by iurii.dziuban on 19.07.2016.
 *
 * Full step listener with all possible event handling
 */
public class StepFullListener extends StepListenerSupport<Transaction, Transaction> {

    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("AfterStep event of StepFullListener");
        return null;
    }

    public void beforeStep(StepExecution stepExecution) {
        System.out.println("BeforeStep event of StepFullListener");
    }

    public void afterChunk(ChunkContext context) {
        System.out.println("AfterChunk event of StepFullListener");
    }

    public void beforeChunk(ChunkContext context) {
        System.out.println("BeforeChunk event of StepFullListener");
    }

    public void afterRead(Transaction item) {
        System.out.println("AfterRead event of StepFullListener");
    }

    public void beforeRead() {
        System.out.println("BeforeRead event of StepFullListener");
    }

    public void onReadError(Exception ex) {
        System.out.println("OnReadError event of StepFullListener");
    }

    public void afterWrite(List<? extends Transaction> items) {
        System.out.println("AfterWrite event of StepFullListener");
    }

    public void beforeWrite(List<? extends Transaction> items) {
        System.out.println("BeforeWrite event of StepFullListener");
    }

    public void onWriteError(Exception exception, List<? extends Transaction> items) {
        System.out.println("OnWriteError event of StepFullListener");
    }

    public void afterProcess(Transaction item, Transaction result) {
        System.out.println("AfterProcess event of StepFullListener");
    }

    public void beforeProcess(Transaction item) {
        System.out.println("BeforeProcess event of StepFullListener");
    }

    public void onProcessError(Transaction item, Exception e) {
        System.out.println("OnProcessError event of StepFullListener");
    }

    public void onSkipInProcess(Transaction item, Throwable t) {
        System.out.println("OnSkipInProcess event of StepFullListener");
    }

    public void onSkipInRead(Throwable t) {
        System.out.println("OnSkipInRead event of StepFullListener");
    }

    public void onSkipInWrite(Transaction item, Throwable t) {
        System.out.println("OnSkipInWrite event of StepFullListener");
    }

    public void afterChunkError(ChunkContext context) {
        System.out.println("AfterChunkError event of StepFullListener");
    }
}
