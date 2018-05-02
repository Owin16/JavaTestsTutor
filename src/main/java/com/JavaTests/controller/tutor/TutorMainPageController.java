package com.JavaTests.controller.tutor;

import com.JavaTests.entity.Question;
import com.JavaTests.entity.Test;
import com.JavaTests.entity.Topic;
import com.JavaTests.services.QuestionService;
import com.JavaTests.services.TestService;
import com.JavaTests.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/tutor")
public class TutorMainPageController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private TestService testService;

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/tutorMainPage", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getMainPage() {
        return "tutor/tutorMain";
    }

    @RequestMapping(value = "/getTopics", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getTopicPage(Model model) {
        List<Topic> topicList = topicService.getTopics();
        model.addAttribute("topicList", topicList);
        return "tutor/tests";
    }

    @RequestMapping(value = "/getQuestions", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getQuestionPage(Model model) {
        List<Question> questionList = questionService.getQuestions();
        List<Test> testList = testService.getTests();
        model.addAttribute("testList", testList);
        model.addAttribute("questionList", questionList);
        return "tutor/questions";
    }

    @RequestMapping(value = "/getStatistics", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getStatisticPage() {
        return "tutor/statistics";
    }

}
