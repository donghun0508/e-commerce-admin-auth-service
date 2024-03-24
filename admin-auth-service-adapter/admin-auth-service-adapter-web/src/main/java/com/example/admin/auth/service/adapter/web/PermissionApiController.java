package com.example.admin.auth.service.adapter.web;

import com.example.admin.auth.service.adapter.web.request.PermissionCreateRequest;
import com.example.admin.auth.service.adapter.web.response.BaseResponse;
import com.example.admin.auth.service.application.port.input.PermissionCreateUseCase;
import com.example.admin.auth.service.application.port.input.PermissionFindUseCase;
import com.example.admin.auth.service.application.port.input.PermissionFindUseCase.PermissionFindResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/permissions")
public class PermissionApiController {

    private final PermissionFindUseCase permissionFindUseCase;
    private final PermissionCreateUseCase permissionCreateUseCase;

    @GetMapping
    public BaseResponse<List<PermissionFindResponse>> getPermissions() {
        return BaseResponse.success(permissionFindUseCase.getPermissions());
    }

    @PostMapping
    public void createPermission(@RequestBody PermissionCreateRequest request) {
        permissionCreateUseCase.createPermission(request.toCommand());
    }
}
