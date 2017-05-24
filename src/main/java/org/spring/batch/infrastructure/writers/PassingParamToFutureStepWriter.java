package org.spring.batch.infrastructure.writers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamWriter;

import java.util.List;

/**
 * Created by iurii.dziuban on 11.08.2016.
 *
 * Writer with checking if parameter "Name" exists
 */
public class PassingParamToFutureStepWriter<T> implements ItemStreamWriter<T> {

    private static final Log LOGGER = LogFactory.getLog(PassingParamToFutureStepWriter.class);

    private StepExecution stepExecution;

    @BeforeStep
    public void saveStepExecution(StepExecution stepExecution) {
        this.stepExecution = stepExecution;
    }

    @Override
    public void write(List<? extends T> items) throws Exception {
        LOGGER.info(items);
        LOGGER.info("Name = " + stepExecution.getExecutionContext().get("Name"));
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        LOGGER.info("PassingParamToFutureStepWriter open connection invoked");
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        LOGGER.info("PassingParamToFutureStepWriter update invoked to persist state");
    }

    @Override
    public void close() throws ItemStreamException {
        LOGGER.info("PassingParamToFutureStepWriter close connection invoked");
    }

}
