package com.example.admin.auth.service.application.port.output;

import com.example.admin.auth.service.domain.entity.Member;

import java.util.Optional;

public interface MemberRepository {
    void save(Member member);

    Optional<Member> findByEmail(String email);
}
