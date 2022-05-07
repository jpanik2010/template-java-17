package it.jpanik.templatejava17.validators.impl;

import it.jpanik.templatejava17.dtos.TestDto;
import it.jpanik.templatejava17.exceptions.ValidationException;
import it.jpanik.templatejava17.validators.ITestValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author jPanik
 */
@Service
public class TestValidator implements ITestValidator {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestValidator.class);

    public void validate(TestDto testDto) throws ValidationException {
        checkEmpty(testDto.getName(), "Name: required field");
    }

    @Override
    public Logger getLogger() {
        return LOGGER;
    }
}
