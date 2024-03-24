package com.example.admin.auth.service.domain.factory;

import com.example.admin.auth.service.domain.entity.Permission;
import com.example.admin.auth.service.domain.valueobject.Action;
import com.example.admin.auth.service.domain.valueobject.ResourceType;
import lombok.Builder;

public class PermissionDomainFactory {

    public Permission create(PermissionCreateDomainDto permissionCreateDomainDto) {
        return Permission.builder()
            .permissionId(null)
            .orderNumber(permissionCreateDomainDto.orderNumber())
            .description(permissionCreateDomainDto.description())
            .resource(permissionCreateDomainDto.resource())
            .resourceType(permissionCreateDomainDto.resourceType())
            .action(permissionCreateDomainDto.action())
            .build();
    }

    @Builder
    public record PermissionCreateDomainDto(
        Long orderNumber,
        String description,
        Action action,
        String resource,
        ResourceType resourceType
    ) {

    }
}
