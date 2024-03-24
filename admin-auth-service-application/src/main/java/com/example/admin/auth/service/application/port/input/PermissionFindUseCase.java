package com.example.admin.auth.service.application.port.input;

import java.util.List;
import lombok.Builder;
import org.springframework.data.domain.Page;

public interface PermissionFindUseCase {

    List<PermissionFindResponse> getPermissions();

    @Builder
    record PermissionFindResponse(
        Long permissionId,
        Long orderNumber,
        String description,
        String resource,
        String resourceType,
        String action
    ) {

    }
}
