package com.example.product.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

    private static final String INVALID_DTO_FIELD_ERROR_MESSAGE_FORMAT = "%s : %s (request value: %s)";
    private static final String UNKNOWN_EXCEPTION_FORMAT = "Unknown Exception !! : %s\n" + "%s:%s:%s";

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorResponse> applicationException(ProductException e) {
        log.info(String.format("Application Exception!! type : %s", e.getClass().getSimpleName()));

        return ResponseEntity
                .status(e.getStatus())
                .body(new ErrorResponse(e.getErrorCode(), e.getErrorMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.info(String.format("MethodArgumentNotValidException : %s", e));

        FieldError firstFieldError = e.getFieldErrors().get(0);
        String errorCode = firstFieldError.getCode();
        String errorMessage = String.format(INVALID_DTO_FIELD_ERROR_MESSAGE_FORMAT, firstFieldError.getField(),
                firstFieldError.getDefaultMessage(), firstFieldError.getRejectedValue());

        ErrorResponse errorResponse = new ErrorResponse(errorCode, errorMessage);

        return ResponseEntity
                .badRequest()
                .body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> unknownException(Exception e) {
        StackTraceElement[] stackTrace = e.getStackTrace();

        log.error(String.format(UNKNOWN_EXCEPTION_FORMAT, e, stackTrace[0].getClassName(),
                stackTrace[0].getMethodName(), stackTrace[0].getLineNumber()), e);

        String errorCode = ExceptionType.UNKNOWN_EXCEPTION.getErrorCode();
        String message = ExceptionType.UNKNOWN_EXCEPTION.getErrorMessage();

        return ResponseEntity
                .internalServerError()
                .body(new ErrorResponse(errorCode, message));
    }

}
