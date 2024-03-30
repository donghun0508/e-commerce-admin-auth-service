package com.example.admin.auth.service.adapter.persistence.domain.repository;

import com.example.admin.auth.service.adapter.persistence.domain.entity.MemberJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<MemberJpaEntity, Long> {

    @Query("select m from MemberJpaEntity m " +
            "join fetch m.groupMembers gm " +
            "join fetch gm.group where m.email = :email")
    Optional<MemberJpaEntity> findByEmailFetchJoin(@Param("email") String email);
}
