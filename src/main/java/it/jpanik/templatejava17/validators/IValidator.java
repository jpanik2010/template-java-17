package it.jpanik.templatejava17.validators;

import it.jpanik.templatejava17.exceptions.ValidationException;
import org.slf4j.Logger;

import java.util.List;

/**
 * @author jPanik
 * @param <DTO> DTO
 */
public interface IValidator<DTO> {

    void validate(DTO testDto) throws ValidationException;

    Logger getLogger();

    default void checkEmpty(String value, String property) throws ValidationException {
        if (value == null || value.trim().isEmpty()) {
            getLogger().warn("String value is null or empty");
            throw new ValidationException(String.format("'%s' non può essere vuoto", property));
        }
    }

    default void checkEmpty(Long value, String property) throws ValidationException {
        if (value == null) {
            getLogger().warn("Long value is null");
            throw new ValidationException(String.format("'%s' non può essere vuoto", property));
        }
    }

    default void checkEmpty(List<?> values, String property) throws ValidationException {
        if (values == null || values.isEmpty()) {
            getLogger().warn("List is null or empty");
            throw new ValidationException(String.format("'%s' non può essere vuoto", property));
        }
    }

    default void checkNull(Object obj, String property) throws ValidationException {
        if (obj == null) {
            getLogger().warn("Object is null");
            throw new ValidationException(String.format("'%s' non può essere vuoto", property));
        }
    }
}
