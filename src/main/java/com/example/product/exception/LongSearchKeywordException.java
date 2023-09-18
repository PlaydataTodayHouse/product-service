package com.example.product.exception;

import org.springframework.http.HttpStatus;

public class LongSearchKeywordException extends ProductException {
        public LongSearchKeywordException() {
            super(HttpStatus.BAD_REQUEST);
        }
}
