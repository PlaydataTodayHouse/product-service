package com.example.product.exception;

import org.springframework.http.HttpStatus;

public class InvalidPageStartException extends ProductException {
        public InvalidPageStartException() {
            super(HttpStatus.BAD_REQUEST);
        }
}
