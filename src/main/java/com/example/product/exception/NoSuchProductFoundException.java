package com.example.product.exception;

import org.springframework.http.HttpStatus;

public class NoSuchProductFoundException extends ProductException {
        public NoSuchProductFoundException() {
            super(HttpStatus.NOT_FOUND);
        }
}
