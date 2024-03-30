package com.example.admin.auth.service.application.service;

import com.example.admin.auth.service.application.port.input.AdminAccountCreateUseCase;
import com.example.admin.auth.service.application.port.output.GroupRepository;
import com.example.admin.auth.service.application.port.output.MemberRepository;
import com.example.admin.auth.service.application.port.output.PasswordEncoder;
import com.example.admin.auth.service.domain.entity.Group;
import com.example.admin.auth.service.domain.entity.Groups;
import com.example.admin.auth.service.domain.entity.Member;
import com.example.admin.auth.service.domain.exception.EmailDuplicateException;
import com.example.admin.auth.service.domain.factory.AdminAccountDomainFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AdminAccountCreateService implements AdminAccountCreateUseCase {

    private final AdminAccountDomainFactory adminAccountDomainFactory;
    private final MemberRepository memberRepository;
    private final GroupRepository groupRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void createAdminAccount(AdminAccountCreateCommand command) {
        duplicateEmail(command.email());
        List<Group> groups = groupRepository.findAll();
        Member adminAccount = adminAccountDomainFactory.createAdminAccount(toDomainDto(command, groups));
        memberRepository.save(adminAccount);
    }

    private void duplicateEmail(String email) {
        memberRepository.findByEmail(email).ifPresent(member -> {
            throw new EmailDuplicateException();
        });
    }

    private AdminAccountDomainFactory.AdminAccountCreateDomainDto toDomainDto(AdminAccountCreateCommand command, List<Group> groups) {
        return AdminAccountDomainFactory.AdminAccountCreateDomainDto.builder()
                .email(command.email())
                .password(command.password())
                .encryptedPassword(passwordEncoder.encode(command.password()))
                .nickname(command.nickName())
                .adminGroups(Groups.builder().groups(groups).build())
                .build();
    }
}
