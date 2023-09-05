package com.inventario.nexos.domain.core.exception;

public class ProductBelowZeroException extends RuntimeException{
    public ProductBelowZeroException(String message) {
        super(message);
    }

    public ProductBelowZeroException(String message, Throwable cause) {
        super(message, cause);
    }
}
