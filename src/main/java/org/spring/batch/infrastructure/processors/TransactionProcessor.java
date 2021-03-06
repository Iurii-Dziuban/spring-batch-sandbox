package org.spring.batch.infrastructure.processors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by iurii.dziuban on 09.08.2016.
 *
 * Transaction processor mainly for partitioner example
 */
public class TransactionProcessor implements ItemProcessor<Transaction, Transaction> {

    private static final Log LOGGER = LogFactory.getLog(TransactionProcessor.class);

    private String threadName;

    @Override
    public Transaction process(Transaction item) throws Exception {
        LOGGER.info(threadName + " processing : " + item.getId() + " : " + item.getName());
        return item;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
}
