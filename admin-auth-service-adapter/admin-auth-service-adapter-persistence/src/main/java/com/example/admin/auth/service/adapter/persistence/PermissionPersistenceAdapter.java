package com.example.admin.auth.service.adapter.persistence;

import com.example.admin.auth.service.adapter.persistence.domain.repository.PermissionJpaRepository;
import com.example.admin.auth.service.adapter.persistence.mapper.PermissionJpaMapper;
import com.example.admin.auth.service.application.port.output.PermissionRepository;
import com.example.admin.auth.service.domain.entity.Permission;
import com.example.admin.auth.service.domain.valueobject.Action;
import com.example.admin.auth.service.domain.valueobject.ResourceType;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class PermissionPersistenceAdapter implements PermissionRepository {

    private final PermissionJpaRepository permissionJpaRepository;
    private final PermissionJpaMapper permissionJpaMapper;

    @Override
    public void save(Permission permission) {
        permissionJpaRepository.save(permissionJpaMapper.mapToJpaEntity(permission));
    }

    @Override
    public List<Permission> getPermissions() {
        return permissionJpaRepository.getPermissions(null)
            .stream()
            .map(permissionJpaMapper::mapToDomain)
            .toList();
    }

    @Override
    public List<Permission> getPermissions(List<Long> permissionIds) {
        return permissionJpaRepository.getPermissions(permissionIds)
            .stream()
            .map(permissionJpaMapper::mapToDomain)
            .toList();
    }

    @Override
    public Optional<Permission> findByResourceAndActionAndResourceType(String resource, Action action, ResourceType resourceType) {
        return permissionJpaRepository.findByResourceAndActionAndResourceType(resource, action, resourceType)
            .map(permissionJpaMapper::mapToDomain);
    }
}
