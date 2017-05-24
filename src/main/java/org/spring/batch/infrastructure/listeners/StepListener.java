package org.spring.batch.infrastructure.listeners;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;

/**
 * Created by iurii.dziuban on 13.07.2016.
 *
 * Simple Step Listener for before/after step events logging
 */
public class StepListener extends StepExecutionListenerSupport {

    private static final Log LOGGER = LogFactory.getLog(StepListener.class);

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        LOGGER.info("AfterStep");
        return stepExecution.getExitStatus();
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {
        LOGGER.info("BeforeStep");
    }

}
