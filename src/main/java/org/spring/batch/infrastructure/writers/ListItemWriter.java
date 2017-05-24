package org.spring.batch.infrastructure.writers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;

import java.util.List;

/**
 * Created by iurii.dziuban on 13.07.2016.
 *
 * Stream writer with possibility to open and close connections
 */
public class ListItemWriter<T> implements ItemStreamWriter<T> {

    private static final Log LOGGER = LogFactory.getLog(ListItemWriter.class);

    @Override
    public void write(List<? extends T> items) throws Exception {
        LOGGER.info("Items are " + items);
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
