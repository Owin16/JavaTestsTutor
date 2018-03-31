package com.JavaTests.controller.tutor;

import com.JavaTests.entity.Test;
import com.JavaTests.entity.Topic;
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

    @RequestMapping(value = "/addTopic", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String addTopic(@ModelAttribute("topic") String topicName, @ModelAttribute("test") String testName) {
        Topic topic = topicService.findByTopicName(topicName);
        if (topic == null){
            topic = new Topic(topicName);
            topicService.addTopic(topic);
        }
        Test test = new Test(testName, topic);
        testService.addTest(test);
    return "redirect:/getTopics";
    }

    @RequestMapping(value = "/getTestsByTopicId", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Test> getTestsById(Model model, @ModelAttribute("topic") String topicName) {
        Topic topic = topicService.findByTopicName(topicName);
        List<Test> testList = testService.findByTopicId(topic.getId());
        return testList;
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
