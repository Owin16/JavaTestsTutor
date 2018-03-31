package com.JavaTests.controller.user;

import com.JavaTests.entity.Test;
import com.JavaTests.entity.Topic;
import com.JavaTests.services.userService.TestService;
import com.JavaTests.services.userService.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


//@Controller
@RestController
@RequestMapping("/user/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private TopicService topicService;

//    @RequestMapping(value = "/getTopics", method = RequestMethod.GET, headers = "Accept=application/json")
//    public String getTopics(Model model) {
//        List<Topic> listOfTopics = topicService.findAllTopic();
//        model.addAttribute("topic", new Topic());
//        model.addAttribute("listOfTopics", listOfTopics);
//        return "user/chooseTopicAndTest";
//    }

//    @RequestMapping(value = "/getTestsFromTopic/{topicId}", method = RequestMethod.GET, headers = "Accept=application/json")
//    public String getTestsFromTopic(Model model, @PathVariable("topicId") Integer topicId) {
//        Topic topic = topicService.getTopicById(topicId);
//        List<Test> listOfTests = testService.findByTopicId(topic.getId());
//        model.addAttribute("test", new Test());
//        model.addAttribute("listOfTests", listOfTests);
//        return "user/chooseTopicAndTest";
//    }

    @RequestMapping(value = "/getTestsFromTopic/{topicId}", method = RequestMethod.GET)
    public ResponseEntity<List<Test>> getTestsFromTopic(@PathVariable("topicId") Integer topicId) {
        Topic topic = topicService.getTopicById(topicId);
        List<Test> listOfTests = testService.findByTopicId(topic.getId());
//        List<Test> testList = new ArrayList<>();
//        Test test = new Test("sdfsdfsd");
//        testList.add(test);
//        return new ResponseEntity<>(testList, HttpStatus.OK);
        return new ResponseEntity<>(listOfTests, HttpStatus.OK);
    }

}
