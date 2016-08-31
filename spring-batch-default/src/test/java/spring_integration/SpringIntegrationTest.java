package spring_integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.messaging.Message;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by iurii.dziuban on 17.08.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring_integration/application-context.xml"})
public class SpringIntegrationTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    @Qualifier("statuses")
    private QueueChannel statusesChannel;

    @Autowired
    private JobRepository jobRepository;

    @Test
    @SuppressWarnings("unchecked")
    public void runBatch() throws Exception {
        //120 s should provide enough time for the poller to detect the file and process it
        JobExecution jobExecution = ((Message<JobExecution>) statusesChannel.receive(120000)).getPayload();
        ExitStatus exitStatus = jobExecution.getExitStatus();
        assertEquals(ExitStatus.COMPLETED, exitStatus);
        int count = jdbcTemplate.queryForObject("select count(*) from transactions", Integer.class);
        // nothing was written to db. Result is as it was initially.
    }
}