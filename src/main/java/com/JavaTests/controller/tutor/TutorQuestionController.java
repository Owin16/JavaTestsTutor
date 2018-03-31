package com.JavaTests.controller.tutor;

import com.JavaTests.entity.Answer;
import com.JavaTests.entity.Question;
import com.JavaTests.services.tutorService.AnswerService;
import com.JavaTests.services.tutorService.QuestionService;
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


    @RequestMapping(value = "/getAnswersByQuestionId", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Answer> getAnswersById(@ModelAttribute("question") Integer questionId) {
        List<Answer> answerList = answerService.findByQuestionId(questionId);
        return answerList;
    }

    @RequestMapping(value = "/addAnswer", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String AddAnswer(@ModelAttribute("answer") String answerDescription,@ModelAttribute("questionId") Integer questionId, @ModelAttribute("question") String questionDescription ) {
        Question question = questionService.findById(questionId);
        if (question == null){
            question = new Question(questionDescription);
            questionService.addQuestion(question);
        }
        Answer answer = new Answer(answerDescription, question);
        answerService.addAnswer(answer);
        return "redirect:/getQuestions";
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
