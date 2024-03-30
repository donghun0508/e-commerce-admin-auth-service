package com.example.admin.auth.service.domain.exception;

import static com.example.admin.auth.service.domain.exception.AuthenticationErrorCode.PASSWORD_NOT_MATCH;

public class PasswordNotMatchException extends AbstractAuthenticationAdminException {
    public PasswordNotMatchException() {
        super(PASSWORD_NOT_MATCH);
    }
}
