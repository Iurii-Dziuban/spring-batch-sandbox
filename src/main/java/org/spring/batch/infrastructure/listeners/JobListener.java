package org.spring.batch.infrastructure.listeners;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

/**
 * Created by iurii.dziuban on 13.07.2016.
 *
 * Job listener simple example
 */
public class JobListener extends JobExecutionListenerSupport {

    @Override
    public void beforeJob(JobExecution jobExecution) {
        System.out.println("BeforeJob");
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        System.out.println("AfterJob");
    }
}
