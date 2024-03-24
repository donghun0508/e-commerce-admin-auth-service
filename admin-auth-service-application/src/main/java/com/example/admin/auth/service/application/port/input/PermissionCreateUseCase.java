package com.example.admin.auth.service.application.port.input;

import static com.example.admin.auth.service.common.validate.Validation.validate;

import com.example.admin.auth.service.common.validate.ValidEnum;
import com.example.admin.auth.service.domain.valueobject.Action;
import com.example.admin.auth.service.domain.valueobject.ResourceType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

public interface PermissionCreateUseCase {

    void createPermission(PermissionCreateCommand command);

    record PermissionCreateCommand(
        @NotNull Long orderNumber,
        String description,
        @ValidEnum(enumClass = Action.class) String action,
        @NotBlank String resource,
        @ValidEnum(enumClass = ResourceType.class) String resourceType
    ) {
        @Builder
        public PermissionCreateCommand(
            @NotNull Long orderNumber,
            String description,
            @ValidEnum(enumClass = Action.class) String action,
            @NotBlank String resource,
            @ValidEnum(enumClass = ResourceType.class) String resourceType) {
            this.orderNumber = orderNumber;
            this.description = description;
            this.action = action;
            this.resource = resource;
            this.resourceType = resourceType;

            validate(this);
        }
    }

}
