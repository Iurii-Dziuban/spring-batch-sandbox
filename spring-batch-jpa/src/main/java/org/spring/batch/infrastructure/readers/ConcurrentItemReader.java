package org.spring.batch.infrastructure.readers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.item.ItemReader;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by iurii.dziuban on 08.08.2016.
 */
public class ConcurrentItemReader implements ItemReader<Transaction> {

    private static final Log LOGGER = LogFactory.getLog(ConcurrentItemReader.class);

    private final AtomicInteger numberOfTransactionsToRead = new AtomicInteger(2);

    @Override
    public Transaction read() throws Exception {
        int numberToRead = numberOfTransactionsToRead.decrementAndGet();
        if (numberToRead >= 0) {
            Transaction transaction = new Transaction();
            transaction.setId(numberToRead);
            transaction.setName("ListItemReader item " + numberToRead);
            LOGGER.info(transaction);
            return transaction;
        }
        return null;
    }

}
