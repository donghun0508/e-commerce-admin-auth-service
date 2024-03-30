package com.example.admin.auth.service.adapter.persistence.domain.repository;

import com.example.admin.auth.service.adapter.persistence.domain.entity.GroupJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupJpaRepository extends JpaRepository<GroupJpaEntity, Long> {
}
