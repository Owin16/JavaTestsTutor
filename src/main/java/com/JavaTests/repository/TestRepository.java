package com.JavaTests.repository;

import com.JavaTests.entity.Test;
import com.JavaTests.entity.Topic;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TestRepository extends CrudRepository<Test, Integer> {

    List<Test> findByTopicId(Integer topicId);

    List<Test> findByTopicName(String topicName);

    List<Test> findByTopic(Topic topic);

    Test findByName(String name);
}
