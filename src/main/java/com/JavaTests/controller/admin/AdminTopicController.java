package com.JavaTests.controller.admin;

import com.JavaTests.entity.Test;
import com.JavaTests.entity.Topic;
import com.JavaTests.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin/topic")
public class AdminTopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/addTopicRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addTopicRest(@RequestBody Topic topic) {
        topicService.addTopic(topic);
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
}
