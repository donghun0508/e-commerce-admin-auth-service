package com.example.admin.auth.service.domain.exception;

public class InvalidEmailException extends AbstractAuthenticationAdminException {

    public InvalidEmailException() {
        super(AuthenticationErrorCode.INVALID_EMAIL);
    }
}
