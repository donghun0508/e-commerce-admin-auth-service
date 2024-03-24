package com.example.admin.auth.service.domain.exception;

public class RoleAlreadyExistsException extends AbstractAuthenticationAdminException {

    public RoleAlreadyExistsException() {
        super(AuthenticationErrorCode.ROLE_ALREADY_EXIST);
    }
}
