package org.spring.batch.infrastructure.listeners;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

/**
 * Created by iurii.dziuban on 22.07.2016.
 */
public class RetryEventListener extends RetryListenerSupport {

    private static final Log LOGGER = LogFactory.getLog(RetryEventListener.class);

    public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        LOGGER.info("RetryEventListener close");
    }

    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        LOGGER.info("RetryEventListener onError");
    }

    public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
        LOGGER.info("RetryEventListener open");
        return true;
    }
}
