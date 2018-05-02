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

    @RequestMapping(value = "/getTestsByTopicIdRest/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Test> getTestsByTopicIdRest(@PathVariable("id") Integer topicId) {
        List<Test> testList = testService.findByTopicId(topicId);
        return testList;
    }

    @RequestMapping(value = "/getQuestionsByTestId", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Question> getQuestionsByTestId(Model model, @ModelAttribute("test") String testName) {
        Test test = testService.findByTestName(testName);
        List<Question> questionList = questionService.findByTestId(test.getId());
        return questionList;
    }

    @RequestMapping(value = "/getQuestionsByTestIdRest/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Question> getQuestionsByTestIdRest(@PathVariable("id") Integer testId) {
        List<Question> questionList = questionService.findByTestId(testId);
        return questionList;
    }

    @RequestMapping(value = "/addTopicRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addTopicRest(@RequestBody Topic topic) {
        topicService.addTopic(topic);
    }


    @RequestMapping(value = "/getTopicsRest", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Topic> getTopicsRest() {
        List<Topic> topicList = topicService.getTopics();
        return topicList;
    }

    @RequestMapping(value = "/addTestRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addTestRest(@RequestBody Test test) {
        testService.addTest(test);
    }

    @RequestMapping(value = "/deleteTestRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void deleteTestRest(@RequestBody Test test) {
        testService.deleteTest(test);
    }

    @RequestMapping(value = "/deleteTopicRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void deleteTopicRest(@RequestBody Topic topic) {
        topicService.deleteTopic(topic);
    }

    @RequestMapping(value = "/updateTopicRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void updateTopicRest(@RequestBody Topic topic) {
        topicService.updateTopic(topic);
    }

    @RequestMapping(value = "/updateTestRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void updateTestRest(@RequestBody Test test) {
        testService.updateTest(test);
    }

}
