package org.spring.batch.infrastructure.validators;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.JobParametersValidator;

/**
 * Created by iurii.dziuban on 18.07.2016.
 * Simple validator implementation with logging
 * Invoked twice https://jira.spring.io/browse/BATCH-2143
 */
public class ParametersValidator implements JobParametersValidator {

    private static final Log LOGGER = LogFactory.getLog(ParametersValidator.class);

    public void validate(JobParameters jobParameters) throws JobParametersInvalidException {
        LOGGER.info("parameters validator started");
    }
}
