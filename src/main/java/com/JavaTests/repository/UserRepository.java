package com.JavaTests.repository;

import com.JavaTests.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByLogin(String login);

}
