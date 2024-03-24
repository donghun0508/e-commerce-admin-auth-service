package com.example.admin.auth.service.application.port.output;

import com.example.admin.auth.service.domain.entity.Permission;
import com.example.admin.auth.service.domain.valueobject.Action;
import com.example.admin.auth.service.domain.valueobject.ResourceType;
import java.util.List;
import java.util.Optional;

public interface PermissionRepository {

    void save(Permission permission);

    List<Permission> getPermissions();

    List<Permission> getPermissions(List<Long> permissionIds);

    Optional<Permission> findByResourceAndActionAndResourceType(String resource, Action action, ResourceType resourceType);
}
