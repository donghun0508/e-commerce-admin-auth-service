package com.example.admin.auth.service.adapter.persistence.domain.repository;

import com.example.admin.auth.service.adapter.persistence.domain.entity.PermissionJpaEntity;
import com.example.admin.auth.service.domain.entity.Permission;
import com.example.admin.auth.service.domain.valueobject.Action;
import com.example.admin.auth.service.domain.valueobject.ResourceType;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Range;

public interface CustomPermissionJpaRepository {

    List<PermissionJpaEntity> getPermissions(List<Long> permissionIds);
}
