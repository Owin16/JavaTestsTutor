package com.JavaTests.services.tutorService;

import com.JavaTests.entity.QuestionStatistic;
import com.JavaTests.entity.TestStatistic;
import com.JavaTests.entity.UserStatistic;

import java.util.List;

public interface StatisticService {

    List<QuestionStatistic> getQuestionStatistic();

    List<TestStatistic> getTestStatistic();

    List<UserStatistic> getUserStatistic();
}
