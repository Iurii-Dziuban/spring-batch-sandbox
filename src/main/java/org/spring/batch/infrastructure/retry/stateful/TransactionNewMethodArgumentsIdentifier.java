package org.spring.batch.infrastructure.retry.stateful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.retry.interceptor.NewMethodArgumentsIdentifier;

/**
 * Created by iurii.dziuban on 12.08.2016.
 */
public class TransactionNewMethodArgumentsIdentifier implements NewMethodArgumentsIdentifier {

    private static final Log LOGGER = LogFactory.getLog(TransactionNewMethodArgumentsIdentifier.class);

    @Override
    public boolean isNew(Object[] args) {
        LOGGER.info("TransactionNewMethodArgumentsIdentifier is invoked");
        for (Object item : args) {
            if (item instanceof Transaction) {
                return true;
            }
        }
        return false;
    }
}
