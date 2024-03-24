package com.example.admin.auth.service.domain.exception;

public class RoleNotFoundException extends AbstractAuthenticationAdminException {

    public RoleNotFoundException() {
        super(AuthenticationErrorCode.ROLE_NOT_FOUND);
    }
}
