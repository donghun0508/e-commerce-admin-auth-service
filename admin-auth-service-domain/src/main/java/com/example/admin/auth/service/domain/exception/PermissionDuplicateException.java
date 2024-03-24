package com.example.admin.auth.service.domain.exception;

public class PermissionDuplicateException extends AbstractAuthenticationAdminException {

    public PermissionDuplicateException() {
        super(AuthenticationErrorCode.PERMISSION_DUPLICATE);
    }
}
