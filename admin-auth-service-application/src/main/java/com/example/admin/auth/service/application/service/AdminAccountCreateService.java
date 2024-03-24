package com.example.admin.auth.service.application.service;

import com.example.admin.auth.service.application.port.input.AdminAccountCreateUseCase;
import com.example.admin.auth.service.application.port.output.MemberRepository;
import com.example.admin.auth.service.domain.entity.Member;
import com.example.admin.auth.service.domain.exception.EmailDuplicateException;
import com.example.admin.auth.service.domain.factory.AdminAccountDomainFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AdminAccountCreateService implements AdminAccountCreateUseCase {

    private final AdminAccountDomainFactory adminAccountDomainFactory;
    private final MemberRepository memberRepository;

    @Override
    public void createAdminAccount(AdminAccountCreateCommand command) {
        duplicateEmail(command.email());
        Member adminAccount = adminAccountDomainFactory.createAdminAccount(toDomainDto(command));
        memberRepository.save(adminAccount);
    }

    private void duplicateEmail(String email) {
        memberRepository.findByEmail(email).ifPresent(member -> {
            throw new EmailDuplicateException();
        });
    }

    private AdminAccountDomainFactory.AdminAccountCreateDomainDto toDomainDto(AdminAccountCreateCommand command) {
        return AdminAccountDomainFactory.AdminAccountCreateDomainDto.builder()
            .build();
    }
}
