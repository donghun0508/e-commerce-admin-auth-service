package com.example.admin.auth.service.adapter.persistence.mapper;

import com.example.admin.auth.service.adapter.persistence.domain.entity.GroupJpaEntity;
import com.example.admin.auth.service.common.domain.valueobject.GroupId;
import com.example.admin.auth.service.domain.entity.Group;
import com.example.admin.auth.service.domain.entity.Groups;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GroupJpaMapper {

    public Group toDomain(GroupJpaEntity groupJpaEntity) {
        return Group.builder()
                .groupId(new GroupId(groupJpaEntity.getId()))
                .name(groupJpaEntity.getName())
                .description(groupJpaEntity.getDescription())
                .build();
    }
}
