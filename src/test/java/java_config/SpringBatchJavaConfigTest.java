package java_config;

import org.batch.integration.java_config.StandaloneInfrastructureConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @Test
    public void test() throws Exception {
        jobLauncher.run(job, new JobParameters());
    }
}
