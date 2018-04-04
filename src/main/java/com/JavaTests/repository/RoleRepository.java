package com.JavaTests.repository;

import com.JavaTests.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findByAdmin(Integer admin);

    Role findByUser(Integer user);

    Role findByTutor(Integer tutor);

}
