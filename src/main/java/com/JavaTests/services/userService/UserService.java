package com.JavaTests.services.userService;


import com.JavaTests.entity.Role;
import com.JavaTests.entity.User;
import com.JavaTests.repository.RoleRepository;
import com.JavaTests.repository.UserRepository;
import com.google.common.collect.Lists;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    public List<User> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    public User getById(int id) {
        return userRepository.findOne(id);
    }

    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        Role role = roleRepository.findByTutor(1);
        user.setRole(role);
        userRepository.save(user);
    }

    public void updateUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(int id) {
        userRepository.delete(id);
    }

    public User findByLogin(String login) {
        return userRepository.findByLogin(login);
    }


}
