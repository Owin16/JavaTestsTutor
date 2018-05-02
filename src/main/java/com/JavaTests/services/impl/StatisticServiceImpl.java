package com.JavaTests.services.impl;

import com.JavaTests.entity.QuestionStatistic;
import com.JavaTests.entity.Statistic;
import com.JavaTests.entity.TestStatistic;
import com.JavaTests.entity.UserStatistic;
import com.JavaTests.repository.QuestionStatisticRepository;
import com.JavaTests.repository.StatisticRepository;
import com.JavaTests.repository.TestStatisticRepository;
import com.JavaTests.repository.UserStatisticRepository;
import com.JavaTests.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class StatisticServiceImpl implements StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;

    @Autowired
    private QuestionStatisticRepository questionStatisticRepository;

    @Autowired
    private TestStatisticRepository testStatisticRepository;

    @Autowired
    private UserStatisticRepository userStatisticRepository;

    @Override
    public List<QuestionStatistic> getQuestionStatistic() {
        List<QuestionStatistic> resultList = new ArrayList<>();
        Iterator<QuestionStatistic> it = questionStatisticRepository.findAll().iterator();
        while (it.hasNext())
            resultList.add(it.next());
        return resultList;
    }

    @Override
    public List<TestStatistic> getTestStatistic() {
        List<TestStatistic> resultList = new ArrayList<>();
        Iterator<TestStatistic> it = testStatisticRepository.findAll().iterator();
        while (it.hasNext())
            resultList.add(it.next());
        return resultList;
    }

    @Override
    public List<UserStatistic> getUserStatistic() {
        List<UserStatistic> resultList = new ArrayList<>();
        Iterator<UserStatistic> it = userStatisticRepository.findAll().iterator();
        while (it.hasNext())
            resultList.add(it.next());
        return resultList;
    }

    @Override
    public void addStatistic(Statistic statistic) {
        statisticRepository.save(statistic);
    }
}
