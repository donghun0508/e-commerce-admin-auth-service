package com.example.admin.auth.service.domain.entity;

import com.example.admin.auth.service.common.domain.entity.AggregateRoot;
import com.example.admin.auth.service.common.domain.valueobject.PermissionId;
import com.example.admin.auth.service.common.domain.valueobject.PoliciesId;
import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Policies extends AggregateRoot<PoliciesId> {

    private String name;
    private String description;
    private List<PermissionId> permissions;

    @Builder
    private Policies(PoliciesId policiesId, String name, String description, List<PermissionId> permissions) {
        super.setId(policiesId);
        this.name = name;
        this.description = description;
        this.permissions = permissions;
    }
}
