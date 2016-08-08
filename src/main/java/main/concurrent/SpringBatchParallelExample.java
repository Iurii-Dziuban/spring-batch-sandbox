package main.concurrent;

import main.exceptional.SpringBatchComplexRetryExample;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by iurii.dziuban on 08.08.2016.
 */
public class SpringBatchParallelExample {

    private static final Log LOGGER = LogFactory.getLog(SpringBatchParallelExample.class);

    public static void main( String[] args ) throws Exception {

        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:concurrent/parallel-application-context.xml"});

        JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);

        Job transactionJob = applicationContext.getBean("transactionJob", Job.class);

        JobExecution jobExecution = jobLauncher.run(transactionJob, new JobParameters());
        LOGGER.info("Exit status = " + jobExecution.getExitStatus());
    }

}
