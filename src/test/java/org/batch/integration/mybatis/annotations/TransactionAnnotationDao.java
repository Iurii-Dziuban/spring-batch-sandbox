package org.batch.integration.mybatis.annotations;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.spring.batch.infrastructure.model.Transaction;

import java.util.List;

/**
 * Created by iurii.dziuban on 19.07.2016.
 */

/**
 * Annotations based mapping
 */
public interface TransactionAnnotationDao {

    @Select("SELECT * FROM TRANSACTIONS")
    List<Transaction> findAll();

    @Insert("INSERT INTO TRANSACTIONS (id, name) VALUES (#{id}, #{name})")
    void insertTransaction(Transaction transaction);

}
