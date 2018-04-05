package com.JavaTests.services.userService;

import com.JavaTests.entity.Test;
import com.JavaTests.entity.Topic;
import com.JavaTests.repository.TestRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class TestService {

    @Autowired
    TestRepository testRepository;

    @Transactional
    public List<Test> findByTopicId(Integer topicId){
        return testRepository.findByTopicId(topicId);
    }

    public List<Test> findByTopicName(String topicName){
        return Lists.newArrayList(testRepository.findByTopicName(topicName));
    }

    public List<Test> findByTopic(Topic topic){
        return Lists.newArrayList(testRepository.findByTopic(topic));
    }

    public Test getTest(int id){
        return testRepository.findOne(id);
    }

    public List<Test> getTests() {
        List<Test> testList = new ArrayList<>();
        Iterator<Test> iterator = testRepository.findAll().iterator();
        while(iterator.hasNext())
            testList.add(iterator.next());
        return testList;
    }

    public Test findByName(String testName) {
        return testRepository.findByName(testName);
    }
}
