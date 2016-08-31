package org.spring.batch.infrastructure.processors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by iurii.dziuban on 18.07.2016.
 *
 * Simple Logging processor
 */
public class LoggingIdentityProcessor implements ItemProcessor<Transaction, Transaction> {

    private static final Log LOGGER = LogFactory.getLog(LoggingIdentityProcessor.class);

    @Override
    public Transaction process(Transaction transaction) throws Exception {
        LOGGER.info("LoggingIdentityProcessor for transaction invoked " + transaction);
        return transaction;
    }
}
