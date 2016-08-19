package org.batch.integration.mybatis.xml;

import org.spring.batch.infrastructure.model.Transaction;

import java.util.List;

/**
 * Created by iurii.dziuban on 18.07.2016.
 */

/**
 * Used for XML mapping
 */
public interface TransactionDao {

    List<Transaction> findAll();

    void insertTransaction(Transaction transaction);
}
