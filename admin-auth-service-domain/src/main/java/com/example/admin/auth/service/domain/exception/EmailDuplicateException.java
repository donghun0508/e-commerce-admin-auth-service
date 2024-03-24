package com.example.admin.auth.service.domain.exception;

public class EmailDuplicateException extends AbstractAuthenticationAdminException {

    public EmailDuplicateException() {
        super(AuthenticationErrorCode.DUPLICATE_EMAIL);
    }
}
