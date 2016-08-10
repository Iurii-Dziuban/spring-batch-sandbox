package java_config;

import main.general.java_config.StandaloneInfrastructureConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;

/**
 * Created by iurii.dziuban on 10.08.2016.
 */
@ContextConfiguration(classes={StandaloneInfrastructureConfiguration.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SpringBatchJavaConfigTest {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    private Job job;

    @Autowired
    private DataSource dataSource;

    @Test
    public void test() throws Exception {
        jobLauncher.run(job, new JobParameters());
    }

}
