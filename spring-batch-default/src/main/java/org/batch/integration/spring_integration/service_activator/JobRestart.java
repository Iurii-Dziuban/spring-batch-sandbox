package org.batch.integration.spring_integration.service_activator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;

/**
 * Created by iurii.dziuban on 17.08.2016.
 *
 * Service activator class for job restart implementation
 */
public class JobRestart {

    private static final Log LOGGER = LogFactory.getLog(JobRestart.class);

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @ServiceActivator
    public void restartIfPossible(JobExecution execution) throws Exception {
        LOGGER.info("Restarting job...");
        jobLauncher.run(job, execution.getJobParameters());
    }
}
