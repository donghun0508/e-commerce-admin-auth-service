package com.example.admin.auth.service.domain.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AuthenticationErrorCode {

    DUPLICATE_EMAIL(409, "DUPLICATE_EMAIL", "Email already exists"),
    GROUPS_EMPTY(400, "GROUPS_EMPTY", "Groups cannot be empty"),
    INVALID_EMAIL(400, "INVALID_EMAIL", "Invalid email"),
    INVALID_PASSWORD(400, "INVALID_PASSWORD", "Invalid password"),
    INVALID_NICKNAME(400, "INVALID_NICKNAME", "Invalid nickname"),
    PERMISSION_ALREADY_EXIST(409, "PERMISSION_ALREADY_EXIST", "Permission already exist"),
    PERMISSION_DUPLICATE(400, "PERMISSION_DUPLICATE", "Permission duplicate"),
    PERMISSION_NOT_FOUND(404, "PERMISSION_NOT_FOUND", "Permission not found"),
    ROLE_ALREADY_EXIST(409, "ROLE_ALREADY_EXIST", "Role already exist"),
    ROLE_NOT_FOUND(404, "ROLE_NOT_FOUND", "Role not found"),
    PASSWORD_NOT_MATCH(400, "PASSWORD_NOT_MATCH", "Password not match"),
    ;

    private final Integer httpStatusCode;
    private final String message;
    private final String detailMessage;
}
