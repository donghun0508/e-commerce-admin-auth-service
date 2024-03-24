package com.example.admin.auth.service.adapter.persistence.domain.repository;

import com.example.admin.auth.service.adapter.persistence.domain.entity.PermissionJpaEntity;
import com.example.admin.auth.service.domain.valueobject.Action;
import com.example.admin.auth.service.domain.valueobject.ResourceType;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionJpaRepository extends JpaRepository<PermissionJpaEntity, Long>, CustomPermissionJpaRepository {

    Optional<PermissionJpaEntity> findByResourceAndActionAndResourceType(String resource, Action action, ResourceType resourceType);
}
