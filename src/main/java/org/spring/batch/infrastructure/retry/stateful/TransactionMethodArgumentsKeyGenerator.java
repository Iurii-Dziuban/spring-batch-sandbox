package org.spring.batch.infrastructure.retry.stateful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.retry.interceptor.MethodArgumentsKeyGenerator;

/**
 * Created by iurii.dziuban on 12.08.2016.
 */
public class TransactionMethodArgumentsKeyGenerator implements MethodArgumentsKeyGenerator{

    private static final Log LOGGER = LogFactory.getLog(TransactionMethodArgumentsKeyGenerator.class);

    @Override
    public Object getKey(Object[] items) {
        LOGGER.info("TransactionMethodArgumentsKeyGenerator invoked");
        for (Object item : items) {
            if (item instanceof Transaction) {
                return ((Transaction) item).getId();
            }
        }
        if (items.length == 0) {
            throw new IllegalArgumentException(
                    "Method parameters are empty.  The key generator cannot determine a unique key.");
        }
        return items[0];
    }

}
