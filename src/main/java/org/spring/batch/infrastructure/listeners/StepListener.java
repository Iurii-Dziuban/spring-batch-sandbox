package org.spring.batch.infrastructure.listeners;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

/**
 * Created by iurii.dziuban on 13.07.2016.
 *
 * Simple Step Listener for before/after step events
 */
public class StepListener extends StepExecutionListenerSupport {
    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        System.out.println("AfterStep");
        return stepExecution.getExitStatus();
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        System.out.println("BeforeStep");
    }

}
