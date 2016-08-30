package org.spring.batch.infrastructure.scheduler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

import java.util.Date;

/**
 * Created by iurii.dziuban on 09.08.2016.
 *
 * Class for scheduling and running a job
 */
public class CronScheduler {

    private static final Log LOGGER = LogFactory.getLog(CronScheduler.class);

    private JobLauncher jobLauncher;
    private Job job;

    public void run() {
        try {
            String dateParam = new Date().toString();
            JobParameters param = new JobParametersBuilder().addString("date", dateParam).toJobParameters();
            JobExecution execution = jobLauncher.run(job, param);
            LOGGER.info("Exit Status : " + execution.getStatus());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public void setJobLauncher(JobLauncher jobLauncher) {
        this.jobLauncher = jobLauncher;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
