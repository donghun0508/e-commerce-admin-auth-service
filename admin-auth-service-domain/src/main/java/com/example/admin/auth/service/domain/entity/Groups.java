package com.example.admin.auth.service.domain.entity;

import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Groups {

    private final List<Group> groups;

    @Builder
    private Groups(List<Group> groups) {
        this.groups = new ArrayList<>(groups);
    }
}
