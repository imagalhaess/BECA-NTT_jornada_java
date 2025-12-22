package br.alura.com.screenmatch.exception;

public class ConversionYearAndRuntimeError extends RuntimeException {
    private String message;

    public ConversionYearAndRuntimeError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
