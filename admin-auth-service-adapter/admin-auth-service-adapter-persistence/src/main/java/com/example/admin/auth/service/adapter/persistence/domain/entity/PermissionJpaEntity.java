package com.example.admin.auth.service.adapter.persistence.domain.entity;

import com.example.admin.auth.service.domain.valueobject.Action;
import com.example.admin.auth.service.domain.valueobject.ResourceType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "permission")
public class PermissionJpaEntity extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id")
    private Long id;

    private Long orderNumber;
    private String resource;
    private String description;
    @Enumerated(EnumType.STRING)
    private Action action;
    @Enumerated(EnumType.STRING)
    private ResourceType resourceType;

    @Builder
    private PermissionJpaEntity(Long id, Long orderNumber, String resource, String description, Action action, ResourceType resourceType) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.resource = resource;
        this.description = description;
        this.action = action;
        this.resourceType = resourceType;
    }
}
