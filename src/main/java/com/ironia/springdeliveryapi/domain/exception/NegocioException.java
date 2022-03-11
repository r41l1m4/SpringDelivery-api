package com.ironia.springdeliveryapi.domain.exception;

public class NegocioException extends RuntimeException{
    private static Long serialVersionUID = 1L;

    public NegocioException(String message) {
        super(message);
    }
}
