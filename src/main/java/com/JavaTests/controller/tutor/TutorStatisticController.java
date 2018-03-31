package com.JavaTests.controller.tutor;

import com.JavaTests.entity.QuestionStatistic;
import com.JavaTests.entity.TestStatistic;
import com.JavaTests.entity.UserStatistic;
import com.JavaTests.services.tutorService.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/tutor/getStatistics")
public class TutorStatisticController {

    @Autowired
    private StatisticService statisticService;

    @RequestMapping(value = "/getTestStatistic", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getTestStatistic(Model model) {
        List<TestStatistic> testStatisticList = statisticService.getTestStatistic();
        model.addAttribute("testStatistic", testStatisticList);
        return "tutor/testsStatistic";
    }

    @RequestMapping(value = "/getQuestionStatistic", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getQuestionStatistic(Model model) {
    List<QuestionStatistic> questionStatisticList = statisticService.getQuestionStatistic();
    model.addAttribute("questionStatistic", questionStatisticList);
        return "tutor/questionStatistic";
    }

    @RequestMapping(value = "/getUserStatistic", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getUserStatistic(Model model) {
        List<UserStatistic> userStatisticList = statisticService.getUserStatistic();
        model.addAttribute("userStatistic", userStatisticList);
        return "tutor/userStatistic";
    }

    @RequestMapping(value = "/getTestStatisticRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void getTestStatisticRest() {
        statisticService.getTestStatistic();
    }

    @RequestMapping(value = "/getQuestionStatisticRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void getQuestionStatisticRest() {
        statisticService.getQuestionStatistic();
    }

    @RequestMapping(value = "/getUserStatisticRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void getUserStatisticRest() {
        statisticService.getUserStatistic();
    }
}
