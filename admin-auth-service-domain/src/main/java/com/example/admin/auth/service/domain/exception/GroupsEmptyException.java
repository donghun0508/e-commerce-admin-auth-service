package com.example.admin.auth.service.domain.exception;

public class GroupsEmptyException extends AbstractAuthenticationAdminException {

    public GroupsEmptyException() {
        super(AuthenticationErrorCode.GROUPS_EMPTY);
    }
}
