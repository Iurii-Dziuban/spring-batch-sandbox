package org.batch.integration.spring_integration.router;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.integration.annotation.Router;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by iurii.dziuban on 17.08.2016.
 *
 * Spring batch router implementation
 */
public class JobExecutionRouter {

    private static final Log LOGGER = LogFactory.getLog(JobExecutionRouter.class);

    @Router
    public List<String> routeJobExecution(JobExecution jobExecution) {

        LOGGER.info("JobExecutionRouter invoked");
        LOGGER.info(jobExecution);

        final List<String> routeToChannels = new ArrayList<String>();

        if (BatchStatus.FAILED.equals(jobExecution.getStatus())) {
            routeToChannels.add("jobRestarts");
        }
        else {

            if (BatchStatus.COMPLETED.equals(jobExecution.getStatus())) {
                routeToChannels.add("completeApplication");
            }

            routeToChannels.add("notifiableExecutions");
        }

        return routeToChannels;
    }
}
