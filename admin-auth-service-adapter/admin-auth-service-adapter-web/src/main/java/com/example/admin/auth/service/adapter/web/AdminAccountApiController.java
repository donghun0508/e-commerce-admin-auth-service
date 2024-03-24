package com.example.admin.auth.service.adapter.web;

import com.example.admin.auth.service.adapter.web.request.AdminAccountCreateRequest;
import com.example.admin.auth.service.application.port.input.AdminAccountCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admin-accounts")
public class AdminAccountApiController {

    private final AdminAccountCreateUseCase adminAccountCreateUseCase;

    @PostMapping
    public void createAdminAccount(@RequestBody AdminAccountCreateRequest request) {
        adminAccountCreateUseCase.createAdminAccount(request.toCommand());
    }
}
