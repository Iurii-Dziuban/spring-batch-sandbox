package main.general;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by dziubani on 4/11/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:general/application-context.xml"})
public class SpringBatchSimpleJdbcTest {

    private static final Log LOGGER = LogFactory.getLog(SpringBatchSimpleJdbcTest.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void test() throws Exception {
        JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);
        Job transactionJob = applicationContext.getBean("transactionJob", Job.class);

        JobExecution jobExecution = jobLauncher.run(transactionJob, new JobParameters());
        LOGGER.info("Exit status = " + jobExecution.getExitStatus());
        Assert.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
    }
}
