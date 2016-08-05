package org.spring.batch.infrastructure.validators;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;

import java.util.Map;

/**
 * Created by iurii.dziuban on 18.07.2016.
 * Invoked twice https://jira.spring.io/browse/BATCH-2143
 */
public class ParametersValidator implements JobParametersValidator {

    public void validate(JobParameters jobParameters) throws JobParametersInvalidException {
        System.out.println("parameters validator started");
    }
}
