package com.example.admin.auth.service.adapter.web;

import com.example.admin.auth.service.adapter.web.request.PoliciesCreateRequest;
import com.example.admin.auth.service.adapter.web.response.BaseResponse;
import com.example.admin.auth.service.application.port.input.PoliciesCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/policies")
public class PoliciesApiController {

    private final PoliciesCreateUseCase policiesCreateUseCase;

    @PostMapping
    public void createPolicies(@RequestBody PoliciesCreateRequest request) {
        policiesCreateUseCase.create(request.toCommand());
    }
}
