package com.example.admin.auth.service.domain.exception;


import com.example.admin.auth.service.common.domain.exception.AuthenticationAdminException;

public abstract class AbstractAuthenticationAdminException extends AuthenticationAdminException {

    public AbstractAuthenticationAdminException(AuthenticationErrorCode authenticationErrorCode) {
        super(authenticationErrorCode.getMessage(), authenticationErrorCode.getDetailMessage(), authenticationErrorCode.name(), authenticationErrorCode.getHttpStatusCode());
    }
}
