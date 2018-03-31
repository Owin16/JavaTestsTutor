package com.JavaTests.services.adminService;

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
public class AdminTestService {

    @Autowired
    TestRepository testRepository;

    public List<Test> getTests() {
        return Lists.newArrayList(testRepository.findAll());
    }

    public List<Test> getTestRest(Test test) {
        List<Test> testsList = new ArrayList<>();
        Iterator<Test> iterator = testRepository.findAll().iterator();
        while (iterator.hasNext()) {
            testsList.add(iterator.next());
        }
        return testsList;
    }
}
