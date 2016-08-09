package org.spring.batch.infrastructure.partitioner;

import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by iurii.dziuban on 09.08.2016.
 */
public class TransactionMapper implements RowMapper<Transaction> {

        public Transaction mapRow(ResultSet rs, int rowNum) throws SQLException {
            Transaction transaction = new Transaction();
            transaction.setId(rs.getInt("id"));
            transaction.setName(rs.getString("name"));
            return transaction;
        }
}
