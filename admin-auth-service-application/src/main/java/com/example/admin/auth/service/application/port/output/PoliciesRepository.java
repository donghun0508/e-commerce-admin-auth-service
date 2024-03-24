package com.example.admin.auth.service.application.port.output;

import com.example.admin.auth.service.domain.entity.Policies;

public interface PoliciesRepository {

    void save(Policies policies);
}
