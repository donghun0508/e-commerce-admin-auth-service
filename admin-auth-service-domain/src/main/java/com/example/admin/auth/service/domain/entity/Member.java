package com.example.admin.auth.service.domain.entity;

import com.example.admin.auth.service.common.domain.entity.AggregateRoot;
import com.example.admin.auth.service.common.domain.valueobject.MemberId;
import com.example.admin.auth.service.domain.valueobject.Email;
import com.example.admin.auth.service.domain.valueobject.Nickname;
import com.example.admin.auth.service.domain.valueobject.Password;
import lombok.Builder;
import lombok.Getter;

@Getter
public class Member extends AggregateRoot<MemberId> {

    private final Email email;
    private final Groups groups;
    private Password password;
    private Nickname nickname;
    private boolean isDeleted;

    @Builder
    private Member(MemberId memberId, Email email, Groups groups, Password password, Nickname nickname, boolean isDeleted) {
        super.setId(memberId);
        this.email = email;
        this.groups = groups;
        this.password = password;
        this.nickname = nickname;
        this.isDeleted = isDeleted;
    }

    public void validate() {
        this.email.validate();
        this.password.validate();
        this.nickname.validate();
    }

    public void encryptPassword(String encryptedPassword) {
        this.password = new Password(encryptedPassword);
    }
}
