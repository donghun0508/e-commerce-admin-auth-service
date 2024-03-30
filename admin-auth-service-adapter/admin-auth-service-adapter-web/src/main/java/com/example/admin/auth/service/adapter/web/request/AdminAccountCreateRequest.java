package com.example.admin.auth.service.adapter.web.request;

import com.example.admin.auth.service.application.port.input.AdminAccountCreateUseCase;
import lombok.Getter;

@Getter
public class AdminAccountCreateRequest {

    private String email;
    private String password;
    private String nickName;

    public AdminAccountCreateUseCase.AdminAccountCreateCommand toCommand() {
        return AdminAccountCreateUseCase.AdminAccountCreateCommand.builder()
                .email(email)
                .password(password)
                .nickName(nickName)
                .build();
    }
}
