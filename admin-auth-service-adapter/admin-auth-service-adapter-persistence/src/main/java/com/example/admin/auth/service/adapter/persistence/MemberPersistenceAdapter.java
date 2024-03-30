package com.example.admin.auth.service.adapter.persistence;

import com.example.admin.auth.service.adapter.persistence.domain.repository.MemberJpaRepository;
import com.example.admin.auth.service.adapter.persistence.mapper.MemberJpaMapper;
import com.example.admin.auth.service.application.port.output.MemberRepository;
import com.example.admin.auth.service.domain.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class MemberPersistenceAdapter implements MemberRepository {

    private final MemberJpaMapper memberJpaMapper;
    private final MemberJpaRepository memberJpaRepository;

    @Override
    public void save(Member member) {
        memberJpaRepository.save(memberJpaMapper.toEntity(member));
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        return memberJpaRepository.findByEmailFetchJoin(email).map(memberJpaMapper::toDomain);
    }
}
