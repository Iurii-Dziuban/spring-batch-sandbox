package org.spring.batch.infrastructure.writers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

/**
 * Created by iurii.dziuban on 08.08.2016.
 */
public class ConcurrentItemWriter implements ItemWriter<Transaction> {

    private static final Log LOGGER = LogFactory.getLog(ConcurrentItemWriter.class);

    @Override
    public void write(List<? extends Transaction> items) throws Exception {
        LOGGER.info(items);
    }
}
