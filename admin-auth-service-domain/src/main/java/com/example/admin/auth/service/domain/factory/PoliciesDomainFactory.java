package com.example.admin.auth.service.domain.factory;

import com.example.admin.auth.service.common.domain.valueobject.PermissionId;
import com.example.admin.auth.service.domain.entity.Policies;
import java.util.List;
import lombok.Builder;

public class PoliciesDomainFactory {

    public Policies create(PoliciesCreateDomainDto policiesCreateDomainDto) {
        return null;
    }

    @Builder
    public record PoliciesCreateDomainDto(
        String name,
        String description,
        List<PermissionId> permissions
    ) {

    }

}
