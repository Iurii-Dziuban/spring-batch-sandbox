package main.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by iurii.dziuban on 20.07.2016.
 */

/**
 * NOTE: Hibernate 5 is not supported by Spring Batch Hibernate readers/writers for current version.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:hibernate/application-context-paging.xml"})
public class SpringBatchHibernatePagingTest {

    private static final Log LOGGER = LogFactory.getLog(SpringBatchHibernatePagingTest.class);

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    @Ignore
    public void test() throws Exception {
        JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);
        Job transactionJob = applicationContext.getBean("transactionJob", Job.class);

        JobExecution jobExecution = jobLauncher.run(transactionJob, new JobParameters());
        LOGGER.info("Exit status = " + jobExecution.getExitStatus());
    }

}
