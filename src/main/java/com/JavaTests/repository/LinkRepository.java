package com.JavaTests.repository;

import com.JavaTests.entity.Link;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LinkRepository extends CrudRepository<Link, Integer> {
    List<Link> findByLiteratureId(Integer id);
}
