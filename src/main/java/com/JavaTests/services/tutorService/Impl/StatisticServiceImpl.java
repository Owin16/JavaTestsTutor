package com.JavaTests.services.tutorService.Impl;

import com.JavaTests.entity.QuestionStatistic;
import com.JavaTests.entity.TestStatistic;
import com.JavaTests.entity.UserStatistic;
import com.JavaTests.repository.QuestionStatisticRepository;
import com.JavaTests.repository.TestStatisticRepository;
import com.JavaTests.repository.UserStatisticRepository;
import com.JavaTests.services.tutorService.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private QuestionStatisticRepository questionStatisticRepository;

    @Autowired
    private TestStatisticRepository testStatisticRepository;

    @Autowired
    private UserStatisticRepository userStatisticRepository;

    @Transactional
    public List<QuestionStatistic> getQuestionStatistic() {
        List<QuestionStatistic> resultList = new ArrayList<>();
        Iterator<QuestionStatistic> it = questionStatisticRepository.findAll().iterator();
        while (it.hasNext())
            resultList.add(it.next());
        return resultList;
    }

    @Transactional
    public List<TestStatistic> getTestStatistic() {
        List<TestStatistic> resultList = new ArrayList<>();
        Iterator<TestStatistic> it = testStatisticRepository.findAll().iterator();
        while (it.hasNext())
            resultList.add(it.next());
        return resultList;
    }

    @Transactional
    public List<UserStatistic> getUserStatistic() {
        List<UserStatistic> resultList = new ArrayList<>();
        Iterator<UserStatistic> it = userStatisticRepository.findAll().iterator();
        while (it.hasNext())
            resultList.add(it.next());
        return resultList;
    }
}
