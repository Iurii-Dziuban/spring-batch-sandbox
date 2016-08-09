package org.spring.batch.infrastructure.readers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

/**
 * Created by iurii.dziuban on 19.07.2016.
 */
public class ThrowingExceptionItemReader implements ItemStreamReader<Transaction> {

    private static final Log LOGGER = LogFactory.getLog(ThrowingExceptionItemReader.class);

    private int numberOfTransactionsToRead = 2;

    @Override
    public Transaction read() {
        if (numberOfTransactionsToRead == 0) {
            return null;
        }
        if (numberOfTransactionsToRead == 2) {
            numberOfTransactionsToRead--;
            throw new IllegalStateException();
        }
        Transaction transaction = new Transaction();
        transaction.setId(numberOfTransactionsToRead);
        transaction.setName("ListItemReader item");
        numberOfTransactionsToRead--;
        return transaction;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        LOGGER.info("ItemStreamReader open connection invoked");
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        LOGGER.info("ItemStreamReader update invoked to persist state");
    }

    @Override
    public void close() throws ItemStreamException {
        LOGGER.info("ItemStreamReader close connection invoked");
    }
}
