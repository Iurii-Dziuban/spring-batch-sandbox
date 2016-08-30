package org.batch.integration.spring_integration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

/**
 * Created by iurii.dziuban on 17.08.2016.
 *
 * Mapper to configure and create Transaction from data
 */
public class TransactionFieldSetMapper implements FieldSetMapper<Transaction>{

    private static final Log LOGGER = LogFactory.getLog(TransactionFieldSetMapper.class);

    @Override
    public Transaction mapFieldSet(FieldSet fieldSet) throws BindException {
        LOGGER.info("From FieldSet to Transaction");
        Transaction transaction = new Transaction();
        transaction.setId(fieldSet.readInt("id"));
        transaction.setName(fieldSet.readString("name"));
        LOGGER.info(transaction);
        return transaction;
    }
}


