package com.JavaTests.controller;

import com.JavaTests.entity.User;
import com.JavaTests.services.UserService;
import com.JavaTests.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "security/registration";
    }

    @RequestMapping(value = "/registrationRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void registrationRest(@RequestBody User user) {
        userService.save(user);
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "security/registration";
        }
        userService.save(userForm);

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "security/login";
    }

    @RequestMapping(value = {"/", "/welcome", "/JavaTests"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        Collection user = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        switch (user.toString()){
            case "[ROLE_TUTOR]":
                return "tutor/tutorMain";
            case "[ROLE_ADMIN]":
                return "admin/adminHome";
            case "[ROLE_USER]":
                return "user/home";
            default:
                return "security/login";
        }
    }
}
