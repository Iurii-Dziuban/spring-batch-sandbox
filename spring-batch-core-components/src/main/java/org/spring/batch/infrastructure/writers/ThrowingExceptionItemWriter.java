package org.spring.batch.infrastructure.writers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;

import java.util.List;

/**
 * Created by iurii.dziuban on 19.07.2016.
 *
 * TODO not used?
 */
public class ThrowingExceptionItemWriter implements ItemStreamWriter<Transaction> {

    private static final Log LOGGER = LogFactory.getLog(ThrowingExceptionItemWriter.class);
    private boolean throwException = true;

    @Override
    public void write(List<? extends Transaction> items) throws Exception {
        if (throwException) {
            throwException = false;
            throw new IllegalArgumentException();
        }
        LOGGER.info(items);
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        LOGGER.info("ItemStreamWriter open connection invoked");
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        LOGGER.info("ItemStreamWriter update invoked to persist state");
    }

    @Override
    public void close() throws ItemStreamException {
        LOGGER.info("ItemStreamWriter close connection invoked");
    }
}

