package com.example.admin.auth.service.domain.factory;

import com.example.admin.auth.service.domain.entity.Groups;
import com.example.admin.auth.service.domain.entity.Member;
import com.example.admin.auth.service.domain.valueobject.Email;
import com.example.admin.auth.service.domain.valueobject.Nickname;
import com.example.admin.auth.service.domain.valueobject.Password;
import lombok.Builder;

public class AdminAccountDomainFactory {

    public Member createAdminAccount(AdminAccountCreateDomainDto adminAccountCreateDomainDto) {
        Member adminMember = Member.builder()
                .memberId(null)
                .email(new Email(adminAccountCreateDomainDto.email))
                .password(new Password(adminAccountCreateDomainDto.password))
                .nickname(new Nickname(adminAccountCreateDomainDto.nickname))
                .isDeleted(false)
                .groups(adminAccountCreateDomainDto.adminGroups)
                .build();

        adminMember.validate();
        adminMember.encryptPassword(adminAccountCreateDomainDto.encryptedPassword);
        return adminMember;
    }

    @Builder
    public record AdminAccountCreateDomainDto(
            String email,
            String password,
            String encryptedPassword,
            String nickname,
            Groups adminGroups
    ) {

    }
}
