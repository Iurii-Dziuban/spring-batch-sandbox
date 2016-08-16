package org.spring.batch.infrastructure.processors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by iurii.dziuban on 19.07.2016.
 */
public class ThrowingExceptionProcessor implements ItemProcessor<Transaction, Transaction> {

    private static final Log LOGGER = LogFactory.getLog(ThrowingExceptionProcessor.class);
    private int numberOfTimesToThrowException = 1;

    @Override
    public Transaction process(Transaction transaction) throws Exception {
        if (numberOfTimesToThrowException-- > 0) {
            LOGGER.error("ThrowingExceptionProcessor throws Exception", new IllegalArgumentException());
            throw new IllegalArgumentException();
        }
        LOGGER.info("ThrowingExceptionProcessor for transaction invoked " + transaction);
        return transaction;
    }
}