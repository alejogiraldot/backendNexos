package com.inventario.nexos.api;

import com.inventario.nexos.domain.core.exception.ProductBelowZeroException;
import com.inventario.nexos.domain.core.exception.ProductRepeatCreateException;
import com.inventario.nexos.domain.core.exception.UserNotMatchWithMerchandise;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = {ProductRepeatCreateException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO handleException(ProductRepeatCreateException productRepeatCreateException) {
        return new ErrorDTO(productRepeatCreateException.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(value = {ProductBelowZeroException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO handleException(ProductBelowZeroException productBelowZeroException) {
        return new ErrorDTO(productBelowZeroException.getMessage());
    }
    @ResponseBody
    @ExceptionHandler(value = {UserNotMatchWithMerchandise.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorDTO handleException(UserNotMatchWithMerchandise userNotMatchWithMerchandise) {
        return new ErrorDTO(userNotMatchWithMerchandise.getMessage());
    }

}
