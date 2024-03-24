package com.example.admin.auth.service.adapter.persistence;

import com.example.admin.auth.service.application.port.output.PoliciesRepository;
import com.example.admin.auth.service.domain.entity.Policies;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
class PoliciesPersistenceAdapter implements PoliciesRepository {

    @Override
    public void save(Policies policies) {

    }
}
