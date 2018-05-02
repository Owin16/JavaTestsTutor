package com.JavaTests.controller.admin;

import com.JavaTests.entity.QuestionStatistic;
import com.JavaTests.entity.TestStatistic;
import com.JavaTests.entity.UserStatistic;
import com.JavaTests.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/statistic")
public class AdminStatisticController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = "/getTestStatisticRest", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<TestStatistic> getTestStatisticRest() {
        return statisticService.getTestStatistic();
    }

    @RequestMapping(value = "/getQuestionStatisticRest", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<QuestionStatistic> getQuestionStatisticRest() {
        return statisticService.getQuestionStatistic();
    }

    @RequestMapping(value = "/getUserStatisticRest", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<UserStatistic> getUserStatisticRest() {
        return statisticService.getUserStatistic();
    }
}
