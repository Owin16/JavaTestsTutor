package com.JavaTests.controller.admin;

import com.JavaTests.entity.Topic;
import com.JavaTests.services.adminService.AdminTopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/admin/topic")
public class AdminTopicController {

    private AdminTopicService adminTopicService;

    @Autowired
    public AdminTopicController(AdminTopicService adminTopicService) {
        this.adminTopicService = adminTopicService;
    }

    // получение всех Topic при нажатии на стрелочку (jsp)
    @RequestMapping(value = "/getTopic", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getTopic(Model model) {
        List<Topic> topicList = adminTopicService.getTopics();
        model.addAttribute("topic", new Topic());
        model.addAttribute("topicList", topicList);
        return "admin/topic";
    }

    // получение всех Topic при вводе в поле (jsp)
    @RequestMapping(value = "/getTopicAutoSave", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getTopicAutoSave(Model model) {
        List<Topic> topicList = adminTopicService.getTopics();
        model.addAttribute("topic", new Topic());
        model.addAttribute("topicList", topicList);
        return "admin/topic";
    }

    // получение всех Topic при нажатии на стрелочку (REST)
    @RequestMapping(value = "/getTopicRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void getTopicRest(@RequestBody Topic topic) {
        adminTopicService.getTopicRest(topic);
    }

    // получение всех Topic при вводе в поле (REST)
    @RequestMapping(value = "/getTopicAutoSaveRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void getTopicAutoSaveRest(@RequestBody Topic topic) {
        adminTopicService.getTopicRest(topic);
    }

//    @RequestMapping(value = "/user/", method = RequestMethod.GET)
//    public ResponseEntity<List<User>> listAllUsers() {
//        List<User> users = userService.findAll();
//        if(users.isEmpty()){
//            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
//        }
//        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//}


//    @RequestMapping(value = "/getTopicRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public Topic getTopicRest(@RequestBody Topic topic) {
//        return topicModel.getTopicRest(topic);
//    }

//    @RequestMapping(value = "/getTopicSaveRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public Topic getTopicSaveRest(@RequestBody Topic topic) {
//        return topicModel.getTopicSaveRest(topic);
//    }

}
