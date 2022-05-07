package it.jpanik.templatejava17.dtos;

/**
 * @author jPanik
 */
public class AckDto {

    private boolean result;

    public AckDto() {
        this.result = true;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}
