package mongo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by iurii.dziuban on 08.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:mongo/application-context.xml",
        "classpath:mongo/test-context.xml",
        "classpath:mongo/application-context.xml"})

/**
 * NOTE: Mongo Db should be running
 */
public class SpringBatchMongoTest {

    @Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;

    @Test
    public void launchJob() throws Exception {

        //JobExecution jobExecution = jobLauncherTestUtils.launchJob();

        JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1");

        Assert.assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());

    }
}
