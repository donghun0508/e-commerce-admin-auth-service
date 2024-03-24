package com.example.admin.auth.service.adapter.web.request;

import com.example.admin.auth.service.application.port.input.PermissionCreateUseCase;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PermissionCreateRequest {

    private Long orderNumber;
    private String resource;
    private String description;
    private String action;
    private String resourceType;

    public PermissionCreateUseCase.PermissionCreateCommand toCommand() {
        return PermissionCreateUseCase.PermissionCreateCommand.builder()
                .orderNumber(orderNumber)
                .resource(resource)
                .description(description)
                .action(action)
                .resourceType(resourceType)
                .build();
    }
}
