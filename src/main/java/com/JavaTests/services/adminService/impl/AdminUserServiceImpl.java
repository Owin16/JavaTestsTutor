package com.JavaTests.services.adminService.impl;

import com.JavaTests.entity.Role;
import com.JavaTests.entity.User;
import com.JavaTests.repository.RoleRepository;
import com.JavaTests.repository.UserRepository;
import com.JavaTests.services.adminService.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public List<User> getUsers() {
        Role role = roleRepository.findByUser(1);
        List <User> userList = userRepository.findAllByRole(role);
        return userList;
    }

    @Override
    public User findByLogin(String userLogin) {
        return userRepository.findByLogin(userLogin);
    }

    @Override
    public void saveAsTutor(User user) {
        userRepository.save(user);
    }
}
