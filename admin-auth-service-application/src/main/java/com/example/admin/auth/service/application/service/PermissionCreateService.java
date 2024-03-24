package com.example.admin.auth.service.application.service;

import com.example.admin.auth.service.application.port.input.PermissionCreateUseCase;
import com.example.admin.auth.service.application.port.output.PermissionRepository;
import com.example.admin.auth.service.domain.entity.Permission;
import com.example.admin.auth.service.domain.exception.PermissionDuplicateException;
import com.example.admin.auth.service.domain.factory.PermissionDomainFactory;
import com.example.admin.auth.service.domain.factory.PermissionDomainFactory.PermissionCreateDomainDto;
import com.example.admin.auth.service.domain.valueobject.Action;
import com.example.admin.auth.service.domain.valueobject.ResourceType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class PermissionCreateService implements PermissionCreateUseCase {

    private final PermissionDomainFactory permissionDomainFactory;
    private final PermissionRepository permissionRepository;

    @Override
    public void createPermission(PermissionCreateCommand command) {
        duplicatePermissionCheck(command);
        Permission permission = permissionDomainFactory.create(toDomainDto(command));
        permissionRepository.save(permission);
    }

    private void duplicatePermissionCheck(PermissionCreateUseCase.PermissionCreateCommand command) {
        permissionRepository.findByResourceAndActionAndResourceType(command.resource(), Action.valueOf(command.action()), ResourceType.valueOf(command.resourceType()))
            .ifPresent(permission -> {
                throw new PermissionDuplicateException();
            });
    }

    private PermissionCreateDomainDto toDomainDto(PermissionCreateCommand command) {
        return PermissionCreateDomainDto.builder()
            .orderNumber(command.orderNumber())
            .description(command.description())
            .action(Action.valueOf(command.action()))
            .resource(command.resource())
            .resourceType(ResourceType.valueOf(command.resourceType()))
            .build();
    }
}
