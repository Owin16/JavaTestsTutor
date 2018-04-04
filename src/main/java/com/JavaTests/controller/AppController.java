package com.JavaTests.controller;

import com.JavaTests.entity.Role;
import com.JavaTests.entity.Topic;
import com.JavaTests.entity.User;
import com.JavaTests.services.security.SecurityService;
import com.JavaTests.services.userService.UserService;
import com.JavaTests.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.List;

@Controller
public class AppController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidator userValidator;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "security/registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "security/registration";
        }

        userService.save(userForm);

      //  securityService.autologin(userForm.getLogin(), userForm.getPassword());
        System.out.println("uuuuser");

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

    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model) {
        Collection user = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        switch (user.toString()){
            case "[ROLE_TUTOR]":
                return "tutor/tutorMain";
            case "[ROLE_ADMIN]":
                return "admin/role";
            case "[ROLE_USER]":
                return "user/home";
            default:
                return "security/login";
        }
    }
}
