package it.jpanik.templatejava17.exceptions;

import org.springframework.http.HttpStatus;

/**
 * @author jPanik
 */
public class ServiceException extends Exception {

    private final HttpStatus status;
    private final String errorMessage;

    public ServiceException(HttpStatus status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public ServiceException(String errorMessage) {
        this(HttpStatus.EXPECTATION_FAILED, errorMessage);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
