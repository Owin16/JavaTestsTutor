package com.JavaTests.controller.tutor;

import com.JavaTests.entity.Question;
import com.JavaTests.entity.Test;
import com.JavaTests.entity.Topic;
import com.JavaTests.services.tutorService.QuestionService;
import com.JavaTests.services.tutorService.TestService;
import com.JavaTests.services.tutorService.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tutor/getTopics")
public class TutorTopicController {

    @Autowired
    private TopicService topicService;

    @Autowired
    private TestService testService;

    @Autowired
    private QuestionService questionService;

    @RequestMapping(value = "/addTopic", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String addTopic(@ModelAttribute("topic") String topicName, @ModelAttribute("test") String testName, @ModelAttribute("question") String questionDescription) {
        Topic topic = topicService.findByTopicName(topicName);
        if (topic == null){
            topic = new Topic(topicName);
            topicService.addTopic(topic);
        }
        Test test = testService.findByTestName(testName);
        if (test == null) {
            test = new Test(testName, topic);
            testService.addTest(test);
        }
        Question question = questionService.findByDescription(questionDescription);
        if (question == null) {
            question = new Question(questionDescription, test);
            questionService.addQuestion(question);
        }
    return "redirect:/tutor/getTopics";
    }

    @RequestMapping(value = "/getTestsByTopicId", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Test> getTestsByTopicId(Model model, @ModelAttribute("topic") String topicName) {
        Topic topic = topicService.findByTopicName(topicName);
        List<Test> testList = testService.findByTopicId(topic.getId());
        return testList;
    }

    @RequestMapping(value = "/getQuestionsByTestId", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Question> getQuestionsByTestId(Model model, @ModelAttribute("test") String testName) {
        Test test = testService.findByTestName(testName);
        List<Question> questionList = questionService.findByTestId(test.getId());
        return questionList;
    }

    @RequestMapping(value = "/addTopicRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addTopicRest(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }


    @RequestMapping(value = "/getTopicsRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void getTopicsRest() {
        topicService.getTopics();
    }
}
