package main.general.java_config;

import org.spring.batch.infrastructure.model.Transaction;
import org.spring.batch.infrastructure.readers.ListItemReader;
import org.spring.batch.infrastructure.writers.ListItemWriter;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by iurii.dziuban on 22.07.2016.
 */

@Configuration
public class JobConfiguration {

    @Autowired
    private JobBuilderFactory jobs;

    @Autowired
    private StepBuilderFactory steps;

    @Bean
    public Job retrySample() {
        return jobs.get("retrySample").start(step()).build();
    }

    @Bean
    protected Step step() {
        return steps.get("step").<Transaction, Transaction>chunk(1).reader(reader()).writer(writer()).faultTolerant()
                .retry(Exception.class).retryLimit(3).build();
    }

    @Bean
    protected ItemReader<Transaction> reader() {
        return new ListItemReader();
    }

    @Bean
    protected ItemWriter<Transaction> writer() {
        return new ListItemWriter<Transaction>();
    }

}
