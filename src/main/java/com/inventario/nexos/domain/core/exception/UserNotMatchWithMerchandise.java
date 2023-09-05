package com.inventario.nexos.domain.core.exception;

public class UserNotMatchWithMerchandise extends RuntimeException{
    public UserNotMatchWithMerchandise(String message) {
        super(message);
    }

    public UserNotMatchWithMerchandise(String message, Throwable cause) {
        super(message, cause);
    }


}
