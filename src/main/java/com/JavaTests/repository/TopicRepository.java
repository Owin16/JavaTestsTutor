package com.JavaTests.repository;

import com.JavaTests.entity.Test;
import com.JavaTests.entity.Topic;
import org.springframework.data.repository.CrudRepository;

public interface TopicRepository extends CrudRepository<Topic, Integer> {

    Topic findByName(String name);
}
