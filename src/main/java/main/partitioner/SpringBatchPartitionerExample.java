package main.partitioner;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dziubani on 4/11/2016.
 */

public class SpringBatchPartitionerExample {

    private static final Log LOGGER = LogFactory.getLog(SpringBatchPartitionerExample.class);

    public static void main( String[] args ) throws Exception {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:partitioner/job-partitioner.xml"});

        JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);

        Job transactionJob = applicationContext.getBean("partitionJob", Job.class);

        JobExecution jobExecution = jobLauncher.run(transactionJob, new JobParameters());
        LOGGER.info("Exit status = " + jobExecution.getExitStatus());
    }
}
