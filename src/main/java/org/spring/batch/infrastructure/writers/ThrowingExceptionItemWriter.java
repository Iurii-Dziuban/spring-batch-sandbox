package org.spring.batch.infrastructure.writers;

import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;
import org.springframework.util.Assert;

import java.util.IllegalFormatException;
import java.util.List;

/**
 * Created by iurii.dziuban on 19.07.2016.
 */
public class ThrowingExceptionItemWriter implements ItemStreamWriter<Transaction> {

    private boolean throwException = true;

    @Override
    public void write(List<? extends Transaction> items) throws Exception {
        if (throwException) {
            throwException = false;
            throw new IllegalArgumentException();
        }
        System.out.println(items);
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        System.out.println("ItemStreamWriter open connection invoked");
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        System.out.println("ItemStreamWriter update invoked to persist state");
    }

    @Override
    public void close() throws ItemStreamException {
        System.out.println("ItemStreamWriter close connection invoked");
    }
}

