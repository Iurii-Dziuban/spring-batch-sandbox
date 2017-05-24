package org.batch.integration.retry.recoverer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.retry.interceptor.MethodInvocationRecoverer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by iurii.dziuban on 12.08.2016.
 *
 * Recoverer implementation
 */
public class TransactionRecoverer implements MethodInvocationRecoverer<Transaction> {

    private static final Log LOGGER = LogFactory.getLog(TransactionRecoverer.class);
    public AtomicInteger id = new AtomicInteger(100);

    @Override
    public Transaction recover(Object[] args, Throwable cause) {
        LOGGER.error("TransactionRecoverer is invoked");
        Transaction transaction = new Transaction();
        transaction.setId(id.getAndIncrement());
        transaction.setName("Recovered Transaction");
        return transaction;
    }
}
