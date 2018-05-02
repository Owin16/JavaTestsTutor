package com.JavaTests.controller.user;

import com.JavaTests.entity.*;
import com.JavaTests.services.*;
import com.JavaTests.services.impl.LiteratureServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user/test")
public class UserTestController {

    @Autowired
    private TestService testService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private StatisticService statisticService;

    @Autowired
    private UserService userService;

    @Autowired
    private LiteratureService literatureService;

    @Autowired
    private LinkService linkService;

    private List<Question> questionList;
    private List<Question> rightQuestions;
    private List<Question> wrongQuestions;

    @RequestMapping(value = "/getTests", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getTestsPage(Model model) {
        List<Test> testList = testService.getTests();
        model.addAttribute("testList", testList);
        return "user/chooseTest";
    }

    @RequestMapping(value = "/mainPage", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getUserHome() {
       return "user/home";
    }

    @RequestMapping(value = "/getTestsRest", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Test> getTestsRest() {
        return testService.getTests();
    }

    @RequestMapping(value = "/getQuestions", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getQuestions(Model model, @ModelAttribute("test") String testName) {
        Test test = testService.findByName(testName);
        if(test == null)
            return "redirect:/user/test/getTests";
        else {
            questionList = questionService.findByTestId(test.getId());
            rightQuestions = new ArrayList<>();
            wrongQuestions = new ArrayList<>();
            return "redirect:/user/test/getQuestion";
        }
    }

    @RequestMapping(value = "/getQuestionsByTestIdRest/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Question> getQuestionsByTestRest(@PathVariable("id") Integer testId) {
        questionList = questionService.findByTestId(testId);
        rightQuestions = new ArrayList<>();
        wrongQuestions = new ArrayList<>();
        return questionList;
    }

    @RequestMapping(value = "/getQuestion", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getQuestion(Model model) {
        if (questionList.size() != 0) {
            Question question = questionList.get(0);
            model.addAttribute("question", question);
            List<Answer> answerList = answerService.findByQuestionId(question.getId());
            model.addAttribute("answerList", answerList);
            return "user/getTest";
        }else {
            double right = rightQuestions.size();
            double wrong = wrongQuestions.size();
            double resultTest = right/(right+wrong);
            model.addAttribute("resultTest", resultTest);
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            User user = userService.findByLogin(userName);
            Date date = new Date();
            List<Statistic> resultStatistic = new ArrayList<>();
            for (Question question: rightQuestions) {
                Statistic statistic = new Statistic(date, true, question, user);
                statisticService.addStatistic(statistic);
                resultStatistic.add(statistic);
                model.addAttribute("resultStatistic", resultStatistic);
            }
            for (Question question: wrongQuestions) {
                Statistic statistic = new Statistic(date, false, question, user);
                statisticService.addStatistic(statistic);
                resultStatistic.add(statistic);
                model.addAttribute("resultStatistic", resultStatistic);
            }
            return "user/getResultTest";
        }
    }

    @RequestMapping(value = "/getAnswersByQuestionIdRest/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Answer> getAnswersByQuestionRest(@PathVariable("id") Integer questionId) {
        return answerService.findByQuestionId(questionId);
    }

    @RequestMapping(value = "/getAnswer", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getAnswer(@RequestParam("answerId") Integer[] answers) {

        List<Answer> answerList = answerService.findByQuestionId(questionList.get(0).getId());
        List<Answer> userAnswers = new ArrayList<>();

        for (int i: answers) {
            Answer userAnswer = answerService.findById(i);
            userAnswers.add(userAnswer);
        }

        addResultQuestion(answerList, userAnswers);

        questionList.remove(0);

        return "redirect:/user/test/getQuestion";
    }

    @RequestMapping(value = "/setAnswersRest/{questionId}", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public void getAnswersByQuestionRest(@RequestBody List<Answer> userAnswer, @PathVariable("questionId") Integer questionId) {
        List<Answer> answerList = answerService.findByQuestionId(questionId);
        addResultQuestion(answerList, userAnswer);
    }

    private void addResultQuestion(List<Answer> answerList, List<Answer> userAnswers){

        boolean questionCorrect = false;

        for(Answer answer: answerList){
            boolean isContain = isContainAnswer(answer, userAnswers);
            if(answer.isCorrect()){
                if(!isContain){
                    wrongQuestions.add(answer.getQuestion());
                    questionCorrect = false;
                    break;
                }
            }else{
                if(isContain) {
                    wrongQuestions.add(answer.getQuestion());
                    questionCorrect = false;
                    break;
                }
            }
            questionCorrect = true;
        }

        if(questionCorrect) rightQuestions.add(answerList.get(0).getQuestion());
    }

    private boolean isContainAnswer (Answer answer, List<Answer> userAnswers){
        boolean contain = false;
            for (Answer userAnswer: userAnswers){
                if (answer.getId() == userAnswer.getId()) {contain = true; break;}
            }
        return contain;
    }

    @RequestMapping(value = "/checkTest", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public boolean checkTest(@ModelAttribute("test") String testName) {
        Test test = testService.findByName(testName);
        if (test == null) return false;
        return true;
    }

    @RequestMapping(value = "/getResultStatisticRest", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Statistic> getResultStatistic(){

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findByLogin(userName);
        Date date = new Date();
        List<Statistic> resultStatistic = new ArrayList<>();
        for (Question question: rightQuestions) {
            Statistic statistic = new Statistic(date, true, question, user);
            statisticService.addStatistic(statistic);
            resultStatistic.add(statistic);
        }
        for (Question question: wrongQuestions) {
            Statistic statistic = new Statistic(date, false, question, user);
            statisticService.addStatistic(statistic);
            resultStatistic.add(statistic);
        }

        questionList = null;
        rightQuestions = null;
        wrongQuestions = null;

        return resultStatistic;
    }

    @RequestMapping(value = "/getLiteratureByQuestionId/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Literature> getLiterature(@PathVariable("id") Integer questionId) {
        return literatureService.findByQuestionId(questionId);
    }

    @RequestMapping(value = "/getLinkByQuestionId/{id}", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Link> getLink(@PathVariable("id") Integer questionId) {
        List<Literature> literatureList = literatureService.findByQuestionId(questionId);
        List<Link> linkList = new ArrayList<>();
        for (Literature literature : literatureList){
            linkList.addAll(linkService.findByLiteratureId(literature.getId()));
        }
        return linkList;
    }

}
