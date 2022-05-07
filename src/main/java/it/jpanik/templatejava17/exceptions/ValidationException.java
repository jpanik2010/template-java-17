package it.jpanik.templatejava17.exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author jPanik
 */
public class ValidationException extends ServiceException {

    public ValidationException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
