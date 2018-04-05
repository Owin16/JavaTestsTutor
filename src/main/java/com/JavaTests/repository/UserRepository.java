package com.JavaTests.repository;

import com.JavaTests.entity.Role;
import com.JavaTests.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByLogin(String login);

    List<User> findAllByRole(Role role);

}
