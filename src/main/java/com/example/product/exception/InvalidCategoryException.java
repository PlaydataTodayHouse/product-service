package com.example.product.exception;

import org.springframework.http.HttpStatus;

public class InvalidCategoryException extends ProductException {
    public InvalidCategoryException() {
        super(HttpStatus.BAD_REQUEST);
    }
}
