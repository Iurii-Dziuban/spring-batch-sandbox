package org.batch.integration.retry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.retry.backoff.Sleeper;

/**
 * Created by iurii.dziuban on 12.08.2016.
 *
 * waiter implementation
 */
public class LoggingThreadWaitSleeper implements Sleeper {

    private static final Log LOGGER = LogFactory.getLog(LoggingThreadWaitSleeper.class);

    @Override
    public void sleep(long backOffPeriod) throws InterruptedException {
        LOGGER.info("LoggingThreadWaitSleeper invoked");
        Thread.sleep(backOffPeriod);
    }
}
