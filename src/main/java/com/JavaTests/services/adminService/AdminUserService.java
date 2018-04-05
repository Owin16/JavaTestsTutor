package com.JavaTests.services.adminService;

import com.JavaTests.entity.User;

import java.util.List;

public interface AdminUserService {
    List<User> getUsers();

    User findByLogin(String userLogin);

    void saveAsTutor(User user);
}
