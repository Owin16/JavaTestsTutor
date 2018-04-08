package com.JavaTests.repository;

import com.JavaTests.entity.Literature;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LiteratureRepository extends CrudRepository<Literature, Integer> {
    List<Literature> findByQuestionId(Integer questionId);
}
