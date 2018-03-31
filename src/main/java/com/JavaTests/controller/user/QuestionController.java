package com.JavaTests.controller.user;

import com.JavaTests.entity.Question;
import com.JavaTests.entity.Test;
import com.JavaTests.services.userService.QuestionService;
import com.JavaTests.services.userService.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

//    @Autowired
//    private AnswerService answerService;

    @Autowired
    private TestService testService;

//    @RequestMapping(value = "/getQ/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
//    public String getUser(Model model, @PathVariable("id") int id) {
//
//        List<Question> listOfQuestions = questionService.findByUserId(id);
//        model.addAttribute("question", new Question());
//        model.addAttribute("listOfQuestions", listOfQuestions);
//        return "user/listQuestions";
//    }

    @RequestMapping(value = "/getQuestion", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getQuestionWithAnswers(@RequestParam int id, Model model) {
        Test test = testService.getTest(id);
        List<Question> listOfQuestions = questionService.findByTestId(test.getId());
        model.addAttribute("question", new Question());
        model.addAttribute("listOfQuestions", listOfQuestions);

        return "user/question";
    }
}
