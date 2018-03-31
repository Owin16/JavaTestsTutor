package com.JavaTests.services.tutorService.Impl;

import com.JavaTests.entity.Test;
import com.JavaTests.repository.TestRepository;
import com.JavaTests.services.tutorService.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestRepository testRepository;

    @Transactional
    public void addTest(Test test) {
        testRepository.save(test);
    }

    @Transactional
    public List<Test> getTests() {
        List<Test> testList = new ArrayList<>();
        Iterator<Test> iterator = testRepository.findAll().iterator();
        while(iterator.hasNext())
            testList.add(iterator.next());
        return testList;
    }

    @Transactional
    public Test editTest(Test test) {
        Test testToUpdate = new Test(test.getId(), test.getName(), test.getDescription());
        testRepository.save(testToUpdate);
        return test;
    }

    @Transactional
    public void deleteTest(Test test) {
        testRepository.delete(test);
    }

    @Transactional
    public List<Test> findByTopicId(Integer topicId) {
        return testRepository.findByTopicId(topicId);
    }
}
