package com.example.admin.auth.service.application.port.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

public interface AdminAccountCreateUseCase {

    void createAdminAccount(AdminAccountCreateCommand command);

    @Builder
    record AdminAccountCreateCommand(
            @NotBlank String email,
            @NotBlank String password,
            @NotBlank String nickName
    ) {

    }
}
