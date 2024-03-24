package com.example.admin.auth.service.adapter.persistence.domain.repository.impl;

import static com.example.admin.auth.service.adapter.persistence.domain.entity.QPermissionJpaEntity.permissionJpaEntity;

import com.example.admin.auth.service.adapter.persistence.domain.entity.PermissionJpaEntity;
import com.example.admin.auth.service.adapter.persistence.domain.repository.CustomPermissionJpaRepository;
import com.example.admin.auth.service.domain.entity.Permission;
import com.example.admin.auth.service.domain.valueobject.Action;
import com.example.admin.auth.service.domain.valueobject.ResourceType;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
class CustomPermissionJpaRepositoryImpl implements CustomPermissionJpaRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<PermissionJpaEntity> getPermissions(List<Long> permissionIds) {
        return queryFactory
            .select(permissionJpaEntity)
            .from(permissionJpaEntity)
            .where(
                permissionIdsIn(permissionIds)
            )
            .orderBy(permissionJpaEntity.createdAt.asc())
            .fetch();
    }

    private BooleanExpression permissionIdsIn(List<Long> permissionIds) {
        if(permissionIds == null || permissionIds.isEmpty()) {
            return null;
        }
        return permissionJpaEntity.id.in(permissionIds);
    }

}
