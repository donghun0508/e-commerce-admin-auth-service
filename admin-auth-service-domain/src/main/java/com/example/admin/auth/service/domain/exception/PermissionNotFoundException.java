package com.example.admin.auth.service.domain.exception;

public class PermissionNotFoundException extends AbstractAuthenticationAdminException {

    public PermissionNotFoundException() {
        super(AuthenticationErrorCode.PERMISSION_NOT_FOUND);
    }
}
