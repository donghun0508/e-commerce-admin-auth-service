package com.example.admin.auth.service.adapter.persistence.domain.repository;

import com.example.admin.auth.service.adapter.persistence.domain.entity.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<MemberJpaEntity, Long> {

    Optional<MemberJpaEntity> findByEmail(String email);
}
