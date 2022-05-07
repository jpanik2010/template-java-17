package it.jpanik.templatejava17.advices;

import it.jpanik.templatejava17.dtos.ErrorDto;
import it.jpanik.templatejava17.exceptions.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author jPanik
 */
@ControllerAdvice
public class ExceptionAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleException(Exception exception) {
        LOGGER.error("Unexpected exception", exception);
        ErrorDto errorResponse = new ErrorDto(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Errore inaspettato"
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDto> handleServiceException(ServiceException exception) {
        ErrorDto errorResponse = new ErrorDto(
                exception.getStatus().value(),
                exception.getErrorMessage()
        );
        return new ResponseEntity<>(errorResponse, exception.getStatus());
    }

}
