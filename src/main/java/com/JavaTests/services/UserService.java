package com.JavaTests.services;

import com.JavaTests.entity.Role;
import com.JavaTests.entity.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    List<User> getAllUsers();

    User findByLogin(String userLogin);

    User findById (int id);

    void saveUser(User user);

    Role getTutorRole();

    Role getAdminRole();

    Role getUserRole();

    void save(User user);
}
