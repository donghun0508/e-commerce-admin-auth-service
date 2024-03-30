package com.example.admin.auth.service.application.port.output;

import com.example.admin.auth.service.domain.entity.Group;
import com.example.admin.auth.service.domain.entity.Groups;

import java.util.List;

public interface GroupRepository {
    List<Group> findAll();
}
