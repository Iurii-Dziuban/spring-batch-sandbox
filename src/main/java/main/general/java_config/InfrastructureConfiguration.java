package main.general.java_config;

import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * Created by iurii.dziuban on 10.08.2016.
 */
public interface InfrastructureConfiguration {
    DataSource dataSource();
}
