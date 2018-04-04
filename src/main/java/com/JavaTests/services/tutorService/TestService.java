package com.JavaTests.services.tutorService;

import com.JavaTests.entity.Test;
import com.JavaTests.entity.Topic;

import java.util.List;

public interface TestService{

    List<Test> getTests();

    void addTest(Test test);

    List<Test> findByTopicId(Integer topicId);

    Test findByTestName(String testName);
}
