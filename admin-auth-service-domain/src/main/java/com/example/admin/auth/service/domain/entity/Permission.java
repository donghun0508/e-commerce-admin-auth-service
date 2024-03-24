package com.example.admin.auth.service.domain.entity;

import com.example.admin.auth.service.common.domain.entity.AggregateRoot;
import com.example.admin.auth.service.common.domain.valueobject.PermissionId;
import com.example.admin.auth.service.domain.valueobject.Action;
import com.example.admin.auth.service.domain.valueobject.ResourceType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Permission extends AggregateRoot<PermissionId> {

    private Long orderNumber;
    private String description;
    private final String resource;
    private final ResourceType resourceType;
    private final Action action;

    @Builder
    private Permission(PermissionId permissionId, Long orderNumber, String description, String resource, ResourceType resourceType, Action action) {
        super.setId(permissionId);
        this.orderNumber = orderNumber;
        this.description = description;
        this.resource = resource;
        this.resourceType = resourceType;
        this.action = action;
    }
}
