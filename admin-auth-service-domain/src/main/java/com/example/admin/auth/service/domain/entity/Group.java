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
    private Group(GroupId groupId, String name, String description) {
        super.setId(groupId);
        this.name = name;
        this.description = description;
    }
}
