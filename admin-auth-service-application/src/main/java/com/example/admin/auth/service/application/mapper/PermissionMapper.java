package com.example.admin.auth.service.application.mapper;

import com.example.admin.auth.service.application.port.input.PermissionFindUseCase.PermissionFindResponse;
import com.example.admin.auth.service.domain.entity.Permission;
import org.springframework.stereotype.Component;

@Component
public class PermissionMapper {

    public PermissionFindResponse mapToResponse(Permission permission) {
        return PermissionFindResponse.builder()
            .permissionId(permission.getId().getValue())
            .orderNumber(permission.getOrderNumber())
            .description(permission.getDescription())
            .resource(permission.getResource())
            .resourceType(permission.getResourceType().name())
            .action(permission.getAction().name())
            .build();
    }
}
