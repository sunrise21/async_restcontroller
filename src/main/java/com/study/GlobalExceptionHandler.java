package com.study;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<?> handleArithmeticExceptionException(final ArithmeticException e, HttpServletRequest request) {

        StringBuilder sb = new StringBuilder();
        String reason = sb.append("Exception = ").append(e.getMessage())
                          .toString();
        return ResponseEntity.status(409).body("ArithmeticExceptionnnn");
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(final Exception e, HttpServletRequest request) {

        StringBuilder sb = new StringBuilder();
        String reason = sb.append("Exception = ").append(e.getMessage())
                          .toString();
        return ResponseEntity.status(408).body("exceptionnnn");
    }
}
