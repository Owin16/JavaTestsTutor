package com.JavaTests.controller.admin;

import com.JavaTests.entity.Role;
import com.JavaTests.entity.User;
import com.JavaTests.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/users")
public class AdminUsersController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/adminHome", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String adminHome() {
        return "admin/adminHome";
    }

    @RequestMapping(value = "/getUsers", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getUsers(Model model) {
        List<User> userList = userService.getUsers();
        model.addAttribute("userList", userList);
        return "admin/users";
    }

    @RequestMapping(value = "/getUsersRest", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<User> getUsersRest() {
        List<User> userList = userService.getAllUsers();
        return userList;
    }

    @RequestMapping(value = "/saveAsTutor/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void saveAsTutorRest(@PathVariable("id") int userId) {
        Role tutor = userService.getTutorRole();
        User user = userService.findById(userId);
        user.setRole(tutor);
        userService.saveUser(user);
    }

    @RequestMapping(value = "/saveAsAdmin/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void saveAsAdminRest(@PathVariable("id") int userId) {
        Role admin = userService.getAdminRole();
        User user = userService.findById(userId);
        user.setRole(admin);
        userService.saveUser(user);
    }

    @RequestMapping(value = "/saveAsUser/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void saveAsUserRest(@PathVariable("id") int userId) {
        Role userRole = userService.getUserRole();
        User user = userService.findById(userId);
        user.setRole(userRole);
        userService.saveUser(user);
    }

    @RequestMapping(value = "/checkUser", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public boolean checkUser(@ModelAttribute("userLogin") String userLogin) {
        User user = userService.findByLogin(userLogin);
        if (user == null) return false;
        return true;
    }

    @RequestMapping(value = "/saveAsTutor", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String saveAsTutor(Model model, @ModelAttribute("userLogin") String userLogin) {
        User user = userService.findByLogin(userLogin);
        Role role = userService.getTutorRole();
        user.setRole(role);
        userService.saveUser(user);
        return "admin/users";
    }
}
