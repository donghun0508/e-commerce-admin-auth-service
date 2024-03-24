package com.example.admin.auth.service.application.service;

import com.example.admin.auth.service.application.mapper.PermissionMapper;
import com.example.admin.auth.service.application.port.input.PermissionFindUseCase;
import com.example.admin.auth.service.application.port.output.PermissionRepository;
import com.example.admin.auth.service.domain.entity.Permission;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class PermissionFindService implements PermissionFindUseCase {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    @Override
    public List<PermissionFindResponse> getPermissions() {
        List<Permission> permissions = permissionRepository.getPermissions();
        return permissions.stream().map(permissionMapper::mapToResponse).toList();
    }
}
