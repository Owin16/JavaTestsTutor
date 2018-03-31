package com.JavaTests.repository;

import com.JavaTests.entity.Literature;
import org.springframework.data.repository.CrudRepository;

public interface LiteratureRepository extends CrudRepository<Literature, Integer> {
}
