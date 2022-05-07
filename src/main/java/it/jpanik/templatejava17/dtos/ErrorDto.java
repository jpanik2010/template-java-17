package it.jpanik.templatejava17.dtos;

import java.util.StringJoiner;

/**
 * @author jPanik
 */
public class ErrorDto {

    private int status;
    private String errorMessage;

    public ErrorDto(int status, String errorMessage) {
        this.status = status;
        this.errorMessage = errorMessage;
    }

    public ErrorDto(int status, String errorMessage, String property) {
        this(status, errorMessage);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ErrorDto.class.getSimpleName() + "[", "]")
                .add("status=" + status)
                .add("errorMessage='" + errorMessage + "'")
                .toString();
    }
}
