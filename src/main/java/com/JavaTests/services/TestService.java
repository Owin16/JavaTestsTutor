package com.JavaTests.services;

import com.JavaTests.entity.Test;

import java.util.List;

public interface TestService {

    List<Test> getTests();

    void addTest(Test test);

    List<Test> findByTopicId(Integer topicId);

    Test findByTestName(String testName);

    void deleteTest(Test test);

    Test findByName(String name);

    void updateTest(Test test);
}
