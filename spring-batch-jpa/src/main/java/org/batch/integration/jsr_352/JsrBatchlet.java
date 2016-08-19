package org.batch.integration.jsr_352;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;

/**
 * Created by iurii.dziuban on 17.08.2016.
 */
//@Named
public class JsrBatchlet extends AbstractBatchlet {

    private static final Log LOGGER = LogFactory.getLog(JsrBatchlet.class);

    @Override
    public String process() {
        LOGGER.info("Running inside a batchlet");
        return BatchStatus.COMPLETED.toString();
    }
}