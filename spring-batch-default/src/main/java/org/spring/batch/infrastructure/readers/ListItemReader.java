package org.spring.batch.infrastructure.readers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.item.*;

/**
 * Created by iurii.dziuban on 18.07.2016.
 */
public class ListItemReader implements ItemStreamReader<Transaction> {

    private static final Log LOGGER = LogFactory.getLog(ListItemReader.class);

    private int numberOfTransactionsToRead = 2;

    @Override
    public Transaction read() {
        if (numberOfTransactionsToRead == 0) {
            return null;
        }
        Transaction transaction = new Transaction();
        transaction.setId(numberOfTransactionsToRead);
        transaction.setName("ListItemReader item");
        LOGGER.info("Transaction is read " + transaction);
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
