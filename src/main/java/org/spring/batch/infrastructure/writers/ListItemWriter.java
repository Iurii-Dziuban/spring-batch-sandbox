package org.spring.batch.infrastructure.writers;

import org.springframework.batch.item.*;
import org.springframework.util.Assert;

import java.util.List;

/**
 * Created by iurii.dziuban on 13.07.2016.
 */
public class ListItemWriter<T> implements ItemStreamWriter<T> {
    private final List<T> items;

    public ListItemWriter(List<T> items) {
        Assert.notNull(items);
        this.items = items;
    }

    @Override
    public void write(List<? extends T> items) throws Exception {
        System.out.println(items);
        this.items.addAll(items);
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {
        System.out.println("ItemStreamWriter open connection invoked");
    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {
        System.out.println("ItemStreamWriter update invoked to persist state");
    }

    @Override
    public void close() throws ItemStreamException {
        System.out.println("ItemStreamWriter close connection invoked");
    }
}
