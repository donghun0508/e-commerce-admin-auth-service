package com.example.admin.auth.service.adapter.persistence;

import com.example.admin.auth.service.adapter.persistence.domain.entity.GroupJpaEntity;
import com.example.admin.auth.service.adapter.persistence.domain.repository.GroupJpaRepository;
import com.example.admin.auth.service.adapter.persistence.mapper.GroupJpaMapper;
import com.example.admin.auth.service.application.port.output.GroupRepository;
import com.example.admin.auth.service.domain.entity.Group;
import com.example.admin.auth.service.domain.entity.Groups;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
class GroupPersistenceAdapter implements GroupRepository {

    private final GroupJpaMapper groupJpaMapper;
    private final GroupJpaRepository groupJpaRepository;

    @Override
    public List<Group> findAll() {
        return groupJpaRepository.findAll().stream()
                .map(groupJpaMapper::toDomain)
                .toList();
    }
}
