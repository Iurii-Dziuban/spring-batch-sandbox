package org.spring.batch.infrastructure.readers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;

/**
 * Created by iurii.dziuban on 18.07.2016.
 */
public class ParamForStepReader implements ItemStreamReader<Transaction> {

    private static final Log LOGGER = LogFactory.getLog(ParamForStepReader.class);

    private int numberOfTransactionsToRead = 2;

    @Override
    public Transaction read() {


        if (numberOfTransactionsToRead == 0) {
            return null;
        }
        Transaction transaction = new Transaction();
        transaction.setId(numberOfTransactionsToRead);
        transaction.setName("ParamForStepReader item");
        numberOfTransactionsToRead--;
        return transaction;
    }

    @BeforeStep
    public void retrieveInterStepData(StepExecution stepExecution) {
        JobExecution jobExecution = stepExecution.getJobExecution();
        ExecutionContext jobContext = jobExecution.getExecutionContext();
        LOGGER.info("ParamForStepReader Name = " + jobContext.get("Name"));
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        LOGGER.info("ParamForStepReader open connection invoked");
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        LOGGER.info("ParamForStepReader update invoked to persist state");
    }

    @Override
    public void close() throws ItemStreamException {
        LOGGER.info("ParamForStepReader close connection invoked");
    }
}
