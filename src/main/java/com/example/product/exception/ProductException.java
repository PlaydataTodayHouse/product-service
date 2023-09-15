package com.example.product.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ProductException extends RuntimeException {

    private final HttpStatus status;
    private final String errorCode;
    private final String errorMessage;

    public ProductException(HttpStatus status) {
        ExceptionType exceptionType = ExceptionType.of(this.getClass());
        this.status = status;
        this.errorCode = exceptionType.getErrorCode();
        this.errorMessage = exceptionType.getErrorMessage();
    }

}
