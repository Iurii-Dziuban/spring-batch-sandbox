package org.spring.batch.infrastructure.listeners;

import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.listener.RetryListenerSupport;

/**
 * Created by iurii.dziuban on 22.07.2016.
 */
public class RetryEventListener extends RetryListenerSupport {
    public <T, E extends Throwable> void close(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        System.out.println("Retry close");
    }

    public <T, E extends Throwable> void onError(RetryContext context, RetryCallback<T, E> callback, Throwable throwable) {
        System.out.println("Retry onError");
    }

    public <T, E extends Throwable> boolean open(RetryContext context, RetryCallback<T, E> callback) {
        System.out.println("Retry open");
        return true;
    }
}
