package com.JavaTests.controller.user;


import com.JavaTests.entity.Topic;
import com.JavaTests.services.userService.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user/topic")
public class TopicController {


    private TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @RequestMapping(value = "/getTopics", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getTopics(Model model) {
        List<Topic> listOfTopics = topicService.findAllTopic();
        model.addAttribute("topic", new Topic());
        model.addAttribute("listOfTopics", listOfTopics);
        return "user/chooseTopicAndTest";
    }
}
