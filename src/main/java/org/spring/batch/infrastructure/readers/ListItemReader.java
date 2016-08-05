package org.spring.batch.infrastructure.readers;

import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.item.*;

/**
 * Created by iurii.dziuban on 18.07.2016.
 */
public class ListItemReader implements ItemStreamReader<Transaction> {

    private int numberOfTransactionsToRead = 2;

    @Override
    public Transaction read() {
        if (numberOfTransactionsToRead == 0) {
            return null;
        }
        Transaction transaction = new Transaction();
        transaction.setId(numberOfTransactionsToRead);
        transaction.setName("ListItemReader invoked");
        numberOfTransactionsToRead--;
        return transaction;
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        System.out.println("ItemStreamReader open connection invoked");
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        System.out.println("ItemStreamReader update invoked to persist state");
    }

    @Override
    public void close() throws ItemStreamException {
        System.out.println("ItemStreamReader close connection invoked");
    }
}
