package com.example.admin.auth.service.adapter.persistence.mapper;

import com.example.admin.auth.service.adapter.persistence.domain.entity.MemberJpaEntity;
import com.example.admin.auth.service.domain.entity.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberJpaMapper {
    public Member toDomain(MemberJpaEntity memberJpaEntity) {
        return null;
    }
}
