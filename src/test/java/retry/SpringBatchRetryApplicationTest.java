package retry;

import org.batch.integration.retry.application.RetryApplication;
import org.batch.integration.retry.application.RetryableService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by iurii.dziuban on 16.08.2016.
 *
 * inspired by https://github.com/spring-projects/spring-retry
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RetryApplication.class})
public class SpringBatchRetryApplicationTest {
    @Autowired
    private RetryableService retryableService;

    @Test
    public void retryService() throws Exception {
        retryableService.service();
    }
}
