package com.example.admin.auth.service.domain.exception;

public class PermissionAlreadyExistException extends AbstractAuthenticationAdminException {

    public PermissionAlreadyExistException() {
        super(AuthenticationErrorCode.PERMISSION_ALREADY_EXIST);
    }
}
