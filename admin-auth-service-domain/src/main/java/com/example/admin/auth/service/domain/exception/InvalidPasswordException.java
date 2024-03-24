package com.example.admin.auth.service.domain.exception;

public class InvalidPasswordException extends AbstractAuthenticationAdminException {

    public InvalidPasswordException() {
        super(AuthenticationErrorCode.INVALID_PASSWORD);
    }
}
