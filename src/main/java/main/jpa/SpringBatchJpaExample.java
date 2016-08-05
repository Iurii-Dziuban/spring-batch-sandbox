package main.jpa;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by iurii.dziuban on 20.07.2016.
 */
public class SpringBatchJpaExample {

    public static void main( String[] args )
    {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(new String[]{"classpath:jpa/application-context.xml"});

        JobLauncher jobLauncher = applicationContext.getBean(JobLauncher.class);

        Job transactionJob = applicationContext.getBean("transactionJob", Job.class);

        try {
            JobExecution jobExecution = jobLauncher.run(transactionJob, new JobParameters());
            System.out.println("Exit status = " + jobExecution.getExitStatus());
        } catch (JobExecutionAlreadyRunningException e) {
            e.printStackTrace();
        } catch (JobRestartException e) {
            e.printStackTrace();
        } catch (JobInstanceAlreadyCompleteException e) {
            e.printStackTrace();
        } catch (JobParametersInvalidException e) {
            e.printStackTrace();
        }
    }

}
