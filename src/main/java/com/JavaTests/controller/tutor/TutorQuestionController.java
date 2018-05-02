package com.JavaTests.controller.tutor;

import com.JavaTests.entity.*;
import com.JavaTests.services.*;
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

    @Autowired
    LiteratureService literatureService;

    @Autowired
    LinkService linkService;

    @RequestMapping(value = "/getAnswersByQuestion", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Answer> getAnswersByQuestion(@ModelAttribute("question") String questionDescription) {
        Question question = questionService.findByDescription(questionDescription);
        List<Answer> answerList = answerService.findByQuestionId(question.getId());
        return answerList;
    }

    @RequestMapping(value = "/getAnswersByQuestionIdRest/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Answer> getAnswersByQuestionIdRest(@PathVariable("id") Integer questionId) {
        List<Answer> answerList = answerService.findByQuestionId(questionId);
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

    @RequestMapping(value = "/addQuestionRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addQuestionRest(@RequestBody Question question) {
        questionService.addQuestion(question);
    }

    @RequestMapping(value = "/addAnswerRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addAnswerRest(@RequestBody Answer answer) {
        answerService.addAnswer(answer);
    }

    @RequestMapping(value = "/deleteAnswerRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void deleteAnswerRest(@RequestBody Answer answer) {
        answerService.deleteAnswer(answer);
    }

    @RequestMapping(value = "/deleteQuestionRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void deleteQuestionRest(@RequestBody Question question) {
        questionService.deleteQuestion(question);
    }

    @RequestMapping(value = "/updateQuestionRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void updateQuestionRest(@RequestBody Question question) {
        questionService.updateQuestion(question);
    }

    @RequestMapping(value = "/updateAnswerRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void updateAnswerRest(@RequestBody Answer answer) {
        answerService.updateAnswer(answer);
    }

    @RequestMapping(value = "/getLiteratureRest", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Literature> getLiteratureRest() {
        return literatureService.findAll();
    }

    @RequestMapping(value = "/addLiteratureRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addLiteratureRest(@RequestBody Literature literature) {
        literatureService.addLiterature(literature);
    }

    @RequestMapping(value = "/updateLiteratureRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void updateLiteratureRest(@RequestBody Literature literature) {
        literatureService.updateLiterature(literature);
    }

    @RequestMapping(value = "/deleteLiteratureRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void deleteLiteratureRest(@RequestBody Literature literature) {
        literatureService.deleteLiterature(literature);
    }

    @RequestMapping(value = "/getLinksRest", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Link> getLinksRest() {
        return linkService.findAll();
    }

    @RequestMapping(value = "/getLinksByLiteratureIdRest/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Link> getLinksByLiteratureIdRest(@PathVariable ("id") Integer literatureId) {
        return linkService.findByLiteratureId(literatureId);
    }

    @RequestMapping(value = "/addLinkRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void addLinkRest(@RequestBody Link link) {
        linkService.addLink(link);
    }

    @RequestMapping(value = "/updateLinkRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void updateLinkRest(@RequestBody Link link) {
        linkService.updateLink(link);
    }

    @RequestMapping(value = "/deleteLinkRest", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void deleteLinkRest(@RequestBody Link link) {
        linkService.deleteLink(link);
    }


}
