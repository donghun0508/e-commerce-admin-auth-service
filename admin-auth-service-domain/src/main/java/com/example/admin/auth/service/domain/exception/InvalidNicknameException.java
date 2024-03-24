package com.example.admin.auth.service.domain.exception;

public class InvalidNicknameException extends AbstractAuthenticationAdminException {

    public InvalidNicknameException() {
        super(AuthenticationErrorCode.INVALID_NICKNAME);
    }
}
