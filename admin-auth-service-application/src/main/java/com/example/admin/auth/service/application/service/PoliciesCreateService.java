package com.example.admin.auth.service.application.service;

import com.example.admin.auth.service.application.port.input.PoliciesCreateUseCase;
import com.example.admin.auth.service.application.port.output.PermissionRepository;
import com.example.admin.auth.service.application.port.output.PoliciesRepository;
import com.example.admin.auth.service.domain.entity.Permission;
import com.example.admin.auth.service.domain.entity.Policies;
import com.example.admin.auth.service.domain.factory.PoliciesDomainFactory;
import com.example.admin.auth.service.domain.factory.PoliciesDomainFactory.PoliciesCreateDomainDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
class PoliciesCreateService implements PoliciesCreateUseCase {

    private final PermissionRepository permissionRepository;
    private final PoliciesDomainFactory policiesDomainFactory;
    private final PoliciesRepository policiesRepository;

    @Override
    public void create(PoliciesCreateCommand command) {
        List<Permission> permissions = permissionRepository.getPermissions(command.permissions());
        Policies policies = policiesDomainFactory.create(toDomainDto(command, permissions));
        policiesRepository.save(policies);
    }

    private PoliciesCreateDomainDto toDomainDto(PoliciesCreateCommand command, List<Permission> permissions) {
        return PoliciesCreateDomainDto.builder()
            .name(command.name())
            .description(command.description())
            .permissions(permissions.stream().map(Permission::getId).toList())
            .build();
    }

}
