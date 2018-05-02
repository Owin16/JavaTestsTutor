package com.JavaTests.services.impl;

import com.JavaTests.entity.Test;
import com.JavaTests.repository.TestRepository;
import com.JavaTests.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class TestsServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Override
    public void addTest(Test test) {
        testRepository.save(test);
    }

    @Override
    public List<Test> getTests() {
        List<Test> testList = new ArrayList<>();
        Iterator<Test> iterator = testRepository.findAll().iterator();
        while(iterator.hasNext())
            testList.add(iterator.next());
        return testList;
    }

    @Override
    public Test findByTestName(String name) {
        return testRepository.findByName(name);
    }

    @Override
    public void deleteTest(Test test) {
        testRepository.delete(test);
    }

    @Override
    public List<Test> findByTopicId(Integer topicId) {
        return testRepository.findByTopicId(topicId);
    }

    @Override
    public Test findByName(String testName) {
        return testRepository.findByName(testName);
    }

    @Override
    public void updateTest(Test test) {
        Test test1 = testRepository.findOne(test.getId());
        if (test1 != null){
            test.setId(test1.getId());
            testRepository.save(test);
        }
    }
}
