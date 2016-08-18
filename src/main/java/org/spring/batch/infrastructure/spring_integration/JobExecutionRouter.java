package org.spring.batch.infrastructure.spring_integration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.integration.annotation.Router;

import javax.batch.runtime.BatchStatus;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iurii.dziuban on 17.08.2016.
 */
public class JobExecutionRouter {

    private static final Log LOGGER = LogFactory.getLog(JobExecutionRouter.class);

    @Router
    public List<String> routeJobExecution(JobExecution jobExecution) {

        LOGGER.info("JobExecutionRouter invoked");

        final List<String> routeToChannels = new ArrayList<String>();

        if (jobExecution.getStatus().equals(BatchStatus.FAILED)) {
            routeToChannels.add("jobRestarts");
        }
        else {

            if (jobExecution.getStatus().equals(BatchStatus.COMPLETED)) {
                routeToChannels.add("completeApplication");
            }

            routeToChannels.add("notifiableExecutions");
        }

        return routeToChannels;
    }
}
