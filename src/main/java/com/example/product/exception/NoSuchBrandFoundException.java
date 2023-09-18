package com.example.product.exception;

import org.springframework.http.HttpStatus;

public class NoSuchBrandFoundException extends ProductException {
        public NoSuchBrandFoundException() {
            super(HttpStatus.NOT_FOUND);
        }
}
