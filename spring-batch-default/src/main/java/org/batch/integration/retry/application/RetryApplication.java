package org.batch.integration.retry.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

/**
 * Created by iurii.dziuban on 16.08.2016.
 *
 * Retry application programmatic example
 */
@Configuration
@EnableRetry
public class RetryApplication {
    @Bean
    public RetryableService service() {
        return new RetryableService();
    }
}
