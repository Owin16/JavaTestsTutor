package com.JavaTests.controller.tutor;

import com.JavaTests.entity.Answer;
import com.JavaTests.entity.Question;
import com.JavaTests.entity.Test;
import com.JavaTests.services.tutorService.AnswerService;
import com.JavaTests.services.tutorService.QuestionService;
import com.JavaTests.services.tutorService.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tutor/getQuestions")
public class TutorQuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private TestService testService;


    @RequestMapping(value = "/getAnswersByQuestion", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Answer> getAnswersByQuestion(@ModelAttribute("question") String questionDescription) {
        Question question = questionService.findByDescription(questionDescription);
        List<Answer> answerList = answerService.findByQuestionId(question.getId());
        return answerList;
    }

    @RequestMapping(value = "/addAnswer", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String AddAnswer(@ModelAttribute("answer") String answerDescription,@ModelAttribute("question") String questionDescription,
                            @ModelAttribute("correct") boolean correct, @ModelAttribute("test") String testName ) {
        Test test = testService.findByTestName(testName);
        Question question = questionService.findByDescription(questionDescription);
        if (question == null){
            question = new Question(questionDescription, test);
            questionService.addQuestion(question);
        }
        Answer answer = new Answer(answerDescription, correct, question);
        answerService.addAnswer(answer);
        return "redirect:/tutor/getQuestions";
    }

    @RequestMapping(value = "/deleteAnswer", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String deleteAnswer(@ModelAttribute("answer") Integer answerId) {
        Answer answer = answerService.findById(answerId);
        answerService.deleteAnswer(answer);
        return "redirect:/tutor/getQuestions";
    }

    @RequestMapping(value = "/deleteQuestion", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String deleteQuestion(@ModelAttribute("question") String questionDescription) {
        Question question = questionService.findByDescription(questionDescription);
        List<Answer> answerList = answerService.findByQuestionId(question.getId());
        for (Answer answer:answerList)
        answerService.deleteAnswer(answer);
        questionService.deleteQuestion(question);
        return "redirect:/tutor/getQuestions";
    }

    @RequestMapping(value = "/checkQuestion", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public boolean checkQuestion(@ModelAttribute("question") String questionDescription) {
        Question question = questionService.findByDescription(questionDescription);
        if (question == null) return false;
        return true;
    }

    @RequestMapping(value = "/checkTest", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public boolean checkTest(@ModelAttribute("test") String testName) {
        Test test = testService.findByTestName(testName);
        if (test == null) return false;
        return true;
    }

    @RequestMapping(value = "/getQuestionsRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void getQuestionssRest() {
        questionService.getQuestions();
    }

    @RequestMapping(value = "/addQuestionRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addQuestionRest(@RequestBody Question question) {
        questionService.addQuestion(question);
    }
}
