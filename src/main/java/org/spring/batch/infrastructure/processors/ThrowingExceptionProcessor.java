package org.spring.batch.infrastructure.processors;

import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by iurii.dziuban on 19.07.2016.
 */
public class ThrowingExceptionProcessor implements ItemProcessor<Transaction, Transaction> {

    private boolean throwException = true;

    @Override
    public Transaction process(Transaction transaction) throws Exception {
        if (throwException) {
            throwException = false;
            throw new IllegalArgumentException();
        }
        System.out.println("ThrowingExceptionProcessor for transaction invoked");
        return transaction;
    }
}