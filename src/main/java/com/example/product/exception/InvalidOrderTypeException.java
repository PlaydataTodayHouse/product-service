package com.example.product.exception;

import org.springframework.http.HttpStatus;

public class InvalidOrderTypeException extends ProductException {
        public InvalidOrderTypeException() {
            super(HttpStatus.BAD_REQUEST);
        }
}
