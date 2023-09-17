package com.example.product.exception;

import org.springframework.http.HttpStatus;

public class InvalidPageSizeException extends ProductException {
        public InvalidPageSizeException() {
            super(HttpStatus.BAD_REQUEST);
        }
}
