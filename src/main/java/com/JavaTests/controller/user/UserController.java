package com.JavaTests.controller.user;


import com.JavaTests.entity.User;
import com.JavaTests.services.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/user/c")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/personalStatistics", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getUser(Model model) {
        List<User> listOfUsers = userService.findAll();
        model.addAttribute("user", new User());
        model.addAttribute("listOfUsers", listOfUsers);
        return "user/userStatistic";
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public User getUserById(@PathVariable int id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/userId/{id}", method = RequestMethod.GET)
    public String getUs(@PathVariable int id){
        return userService.getById(id).toString();
    }

}
