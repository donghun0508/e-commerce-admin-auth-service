package com.example.admin.auth.service.adapter.persistence.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "member")
public class MemberJpaEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;
    private String password;
    private String nickName;
    private boolean isDeleted;
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<GroupMemberJpaEntity> groupMembers = new ArrayList<>();
}
