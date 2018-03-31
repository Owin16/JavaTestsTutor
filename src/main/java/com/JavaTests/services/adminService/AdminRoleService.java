package com.JavaTests.services.adminService;

import com.JavaTests.entity.Role;
import com.JavaTests.repository.RoleRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdminRoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles() {
        return Lists.newArrayList(roleRepository.findAll());
    }
}
