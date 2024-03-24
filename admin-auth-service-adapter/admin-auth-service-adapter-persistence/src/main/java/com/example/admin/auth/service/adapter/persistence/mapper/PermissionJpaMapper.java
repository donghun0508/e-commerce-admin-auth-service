package com.example.admin.auth.service.adapter.persistence.mapper;

import com.example.admin.auth.service.adapter.persistence.domain.entity.PermissionJpaEntity;
import com.example.admin.auth.service.common.domain.valueobject.PermissionId;
import com.example.admin.auth.service.domain.entity.Permission;
import java.util.Objects;
import org.springframework.stereotype.Component;

@Component
public class PermissionJpaMapper {

    public PermissionJpaEntity mapToJpaEntity(Permission permission) {
        return PermissionJpaEntity.builder()
            .id(Objects.isNull(permission.getId()) ? null : permission.getId().getValue())
            .orderNumber(permission.getOrderNumber())
            .action(permission.getAction())
            .description(permission.getDescription())
            .resource(permission.getResource())
            .resourceType(permission.getResourceType())
            .build();
    }

    public Permission mapToDomain(PermissionJpaEntity permissionJpaEntity) {
        return Permission.builder()
            .permissionId(new PermissionId(permissionJpaEntity.getId()))
            .orderNumber(permissionJpaEntity.getOrderNumber())
            .description(permissionJpaEntity.getDescription())
            .resource(permissionJpaEntity.getResource())
            .resourceType(permissionJpaEntity.getResourceType())
            .action(permissionJpaEntity.getAction())
            .build();
    }
}
