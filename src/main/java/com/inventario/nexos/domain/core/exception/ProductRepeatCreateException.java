package com.inventario.nexos.domain.core.exception;

public class ProductRepeatCreateException extends RuntimeException{
    public ProductRepeatCreateException(String message) {
        super(message);
    }

    public ProductRepeatCreateException(String message, Throwable cause) {
        super(message, cause);
    }

}
