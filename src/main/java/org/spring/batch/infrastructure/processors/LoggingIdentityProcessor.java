package org.spring.batch.infrastructure.processors;

import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by iurii.dziuban on 18.07.2016.
 */
public class LoggingIdentityProcessor implements ItemProcessor<Transaction, Transaction> {

    @Override
    public Transaction process(Transaction transaction) throws Exception {
        System.out.println("LoggingIdentityProcessor for transaction invoked");
        return transaction;
    }
}
