package com.example.admin.auth.service.application.port.input;

import jakarta.validation.constraints.NotBlank;

public interface AdminAccountCreateUseCase {

    void createAdminAccount(AdminAccountCreateCommand command);

    record AdminAccountCreateCommand(
            @NotBlank String email,
            @NotBlank String password,
            @NotBlank String nickName
    ) {

    }
}
