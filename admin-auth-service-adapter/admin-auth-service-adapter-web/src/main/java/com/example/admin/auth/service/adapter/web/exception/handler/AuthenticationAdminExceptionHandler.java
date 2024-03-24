package com.example.admin.auth.service.adapter.web.exception.handler;

import com.example.admin.auth.service.adapter.web.response.ErrorResponse;
import com.example.admin.auth.service.common.domain.exception.AuthenticationAdminException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class AuthenticationAdminExceptionHandler extends GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
            .status(HttpStatus.INTERNAL_SERVER_ERROR)
            .body(ErrorResponse.builder()
                .message(e.getMessage())
                .build());
    }

    @ExceptionHandler(AuthenticationAdminException.class)
    public ResponseEntity<ErrorResponse> authenticationAdminExceptionHandler(AuthenticationAdminException e) {
        log.error(e.getMessage(), e);
        return ResponseEntity
            .status(e.getHttpStatusCode())
            .body(ErrorResponse.builder()
                .message(e.getMessage())
                .detailMessage(e.getDetailMessage())
                .errorCode(e.getErrorCode())
                .build());
    }

}
