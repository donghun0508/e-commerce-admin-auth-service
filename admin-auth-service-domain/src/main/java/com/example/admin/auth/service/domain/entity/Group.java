package com.example.admin.auth.service.domain.entity;

import com.example.admin.auth.service.common.domain.entity.BaseEntity;
import com.example.admin.auth.service.common.domain.valueobject.GroupId;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Group extends BaseEntity<GroupId> {

    private String name;
    private String description;

    @Builder
    private Group(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
