package org.batch.integration.mongo;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.batch.infrastructure.model.Transaction;
import org.springframework.util.Assert;

/**
 * Created by iurii.dziuban on 30.08.2016.
 */
public class TransactionConverter implements Converter {

    private static final Log LOGGER = LogFactory.getLog(TransactionConverter.class);

    @Override
    public boolean canConvert(Class type) {
        return type.equals(Transaction.class);
    }

    @Override
    public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
    }

    @Override
    public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
        Transaction transaction = new Transaction();
        transaction.setId(Integer.valueOf(reader.getAttribute("id")));

        reader.moveDown();
        Assert.isTrue("name".equals(reader.getNodeName()));

        String name = reader.getValue();
        transaction.setName(name);
        reader.moveUp();
        LOGGER.info(transaction);
        return transaction;
    }
}
