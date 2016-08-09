package org.spring.batch.infrastructure.scheduler;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Map;

/**
 * Created by iurii.dziuban on 09.08.2016.
 */
public class QuartzLauncherDetails extends QuartzJobBean {
    private static final String JOB_NAME = "jobName";
    private static final String JOB_LAUNCHER = "jobLauncher";
    private static final String JOB_REGISTRY = "jobRegistry";

    private static final Log LOGGER = LogFactory.getLog(QuartzLauncherDetails.class);

    @SuppressWarnings("unchecked")
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Map<String, Object> jobDataMap = context.getMergedJobDataMap();
        String jobName = (String) jobDataMap.get(JOB_NAME);
        JobLauncher jobLauncher = (JobLauncher) jobDataMap.get(JOB_LAUNCHER);
        JobRegistry jobRegistry = (JobRegistry) jobDataMap.get(JOB_REGISTRY);

        try {
            jobLauncher.run(jobRegistry.getJob(jobName), new JobParameters());
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
