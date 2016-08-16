package org.spring.batch.infrastructure.retry.application;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.retry.LoggingThreadWaitSleeper;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * Created by iurii.dziuban on 16.08.2016.
 */
@Service
public class RetryableService {

    private static final Log LOGGER = LogFactory.getLog(RetryableService.class);

    private int retryTimes = 2; // try to invoke with 3 and 2

    @Retryable(IllegalStateException.class)
    public void service() {
        if(retryTimes-- > 0) {
            LOGGER.info("Will retry. Number of times = " + retryTimes);
          throw new IllegalStateException();
        } else {
            LOGGER.info("RetryableService finished SUCCESSFULLY");
        }
    }
    @Recover
    public void recover(IllegalStateException e) {
        LOGGER.info("RetryableService recovering after errors");
    }
}
