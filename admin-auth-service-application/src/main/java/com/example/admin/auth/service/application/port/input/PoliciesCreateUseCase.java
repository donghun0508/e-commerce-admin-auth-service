package com.example.admin.auth.service.application.port.input;

import java.util.List;

public interface PoliciesCreateUseCase {

    void create(PoliciesCreateCommand command);

    record PoliciesCreateCommand(
        String name,
        String description,
        List<Long> permissions) {

    }

}
