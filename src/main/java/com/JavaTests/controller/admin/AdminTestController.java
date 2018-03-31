package com.JavaTests.controller.admin;

import com.JavaTests.entity.Test;
import com.JavaTests.entity.Topic;
import com.JavaTests.services.adminService.AdminTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/test")
public class AdminTestController {

    private AdminTestService adminTestService;

    @Autowired
    public AdminTestController(AdminTestService adminTestService) {
        this.adminTestService = adminTestService;
    }

    // получение всех Tests при нажатии на стрелочку (jsp)
    @RequestMapping(value = "/getTest", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getTest(Model model) {
        List<Test> testList = adminTestService.getTests();
        model.addAttribute("test", new Test());
        model.addAttribute("testList", testList);
        return "admin/test";
    }

    // получение всех Tests при вводе в поле (jsp)
    @RequestMapping(value = "/getTestAutoSave", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getTestAutoSave(Model model) {
        List<Test> testList = adminTestService.getTests();
        model.addAttribute("test", new Test());
        model.addAttribute("testList", testList);
        return "admin/test";
    }

    // получение всех Tests при нажатии на стрелочку (REST)
    @RequestMapping(value = "/getTestRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void getTestRest(@RequestBody Test test) {
        adminTestService.getTestRest(test);
    }

    // получение всех Tests при вводе в поле (REST)
    @RequestMapping(value = "/getTestAutoSaveRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void getTestAutoSaveRest(@RequestBody Test test) {
        adminTestService.getTestRest(test);
    }


//    @RequestMapping(value = "/getTest")
//    public String getTest(Model model) {
//        model.addAttribute("getTest", testModel.getTest());
//        return "test";
//    }
//
//    @RequestMapping(value = "/getTestSave")
//    public String testSave(Model model) {
//        model.addAttribute("testSave", testModel.getTestSave());
//        return "testSave";
//    }
//
//    @RequestMapping(value = "/getTestRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public Test getTestRest(@RequestBody Test test) {
//        return testModel.getTestRest(test);
//    }
//
//    @RequestMapping(value = "/getTestSaveRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public Test getTestSaveRest(@RequestBody Test test) {
//        return testModel.getTestSaveRest(test);
//    }

}
