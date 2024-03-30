package com.example.admin.auth.service.adapter.persistence.mapper;

import com.example.admin.auth.service.adapter.persistence.domain.entity.GroupJpaEntity;
import com.example.admin.auth.service.adapter.persistence.domain.entity.GroupMemberJpaEntity;
import com.example.admin.auth.service.adapter.persistence.domain.entity.MemberJpaEntity;
import com.example.admin.auth.service.common.domain.valueobject.GroupId;
import com.example.admin.auth.service.common.domain.valueobject.MemberId;
import com.example.admin.auth.service.domain.entity.Group;
import com.example.admin.auth.service.domain.entity.Groups;
import com.example.admin.auth.service.domain.entity.Member;
import com.example.admin.auth.service.domain.valueobject.Email;
import com.example.admin.auth.service.domain.valueobject.Nickname;
import com.example.admin.auth.service.domain.valueobject.Password;
import org.springframework.stereotype.Component;

import java.util.Objects;

import static java.util.Objects.isNull;

@Component
public class MemberJpaMapper {
    public Member toDomain(MemberJpaEntity memberJpaEntity) {
        return Member.builder()
                .memberId(new MemberId(memberJpaEntity.getId()))
                .email(new Email(memberJpaEntity.getEmail()))
                .password(new Password(memberJpaEntity.getPassword()))
                .nickname(new Nickname(memberJpaEntity.getNickName()))
                .isDeleted(memberJpaEntity.isDeleted())
                .groups(Groups.builder()
                        .groups(memberJpaEntity.getGroupMembers().stream().map(gm -> Group.builder()
                                .groupId(new GroupId(gm.getGroup().getId()))
                                .name(gm.getGroup().getName())
                                .description(gm.getGroup().getDescription())
                                .build()).toList())
                        .build())
                .build();
    }

    public MemberJpaEntity toEntity(Member member) {
        MemberJpaEntity memberJpaEntity = MemberJpaEntity.builder()
                .id(isNull(member.getId()) ? null : member.getId().getValue())
                .email(member.getEmail().value())
                .password(member.getPassword().value())
                .nickName(member.getNickname().value())
                .isDeleted(member.isDeleted())
                .build();

        memberJpaEntity.setGroupMembers(member.getGroups().getGroups().stream().map(group -> GroupMemberJpaEntity.builder()
                .member(memberJpaEntity)
                .group(GroupJpaEntity.builder()
                        .id(group.getId().getValue())
                        .name(group.getName())
                        .description(group.getDescription())
                        .build())
                .build()).toList());

        return memberJpaEntity;
    }
}
