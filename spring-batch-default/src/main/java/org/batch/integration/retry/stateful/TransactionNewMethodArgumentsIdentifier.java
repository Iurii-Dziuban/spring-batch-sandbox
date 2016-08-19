package org.batch.integration.retry.stateful;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.retry.interceptor.NewMethodArgumentsIdentifier;

/**
 * Created by iurii.dziuban on 12.08.2016.
 */
public class TransactionNewMethodArgumentsIdentifier implements NewMethodArgumentsIdentifier {

    private static final Log LOGGER = LogFactory.getLog(TransactionNewMethodArgumentsIdentifier.class);

    @Override
    public boolean isNew(Object[] args) {
        // Default return value have to be false
        return false;
    }
}
