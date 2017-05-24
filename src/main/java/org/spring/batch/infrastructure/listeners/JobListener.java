package org.spring.batch.infrastructure.listeners;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

/**
 * Created by iurii.dziuban on 13.07.2016.
 *
 * Job listener simple example with before job and after job Logging
 */
public class JobListener extends JobExecutionListenerSupport {

    private static final Log LOGGER = LogFactory.getLog(JobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        LOGGER.info("BeforeJob");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        LOGGER.info("AfterJob");
    }
}
