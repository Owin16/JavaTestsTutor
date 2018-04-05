package com.JavaTests.controller.user;

import com.JavaTests.entity.*;
import com.JavaTests.services.userService.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private TopicService topicService;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private AnswerService answerService;

    @Autowired
    StatisticService statisticService;

    @Autowired
    UserService userService;

    private List<Question> questionList;
    private List<Question> rightQuestions;
    private List<Question> wrongQuestions;

    @RequestMapping(value = "/getTests", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getTestsPage(Model model) {
        List<Test> testList = testService.getTests();
        model.addAttribute("testList", testList);
        return "user/chooseTest";
    }

    @RequestMapping(value = "/getQuestions", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String getTQuestions(Model model, @ModelAttribute("test") String testName) {
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
            for (Question question: rightQuestions) {
                Statistic statistic = new Statistic(date, true, question, user);
                statisticService.addStatistic(statistic);
            }
            for (Question question: wrongQuestions) {
                Statistic statistic = new Statistic(date, false, question, user);
                statisticService.addStatistic(statistic);
            }
            return "user/getResultTest";
        }
    }

    @RequestMapping(value = "/getAnswer", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getAnswer(@RequestParam("answerId") Integer[] answers) {

        List<Answer> answerList = answerService.findByQuestionId(questionList.get(0).getId());
        List<Answer> userAnswers = new ArrayList<>();
        for (int i: answers) {
            Answer userAnswer = answerService.findById(i);
            userAnswers.add(userAnswer);
        }
        boolean questionCorrect = false;

        for(Answer answer: answerList){
            boolean isContain = isContainAnswer(answer, userAnswers);
            if(answer.isCorrect()){
                if(!isContain){
                    wrongQuestions.add(questionList.get(0));
                    questionCorrect = false;
                    break;
                }
            }else{
                if(isContain) {
                    wrongQuestions.add(questionList.get(0));
                    questionCorrect = false;
                    break;
                }
            }
         questionCorrect = true;
        }

        if(questionCorrect) rightQuestions.add(questionList.get(0));

        questionList.remove(0);

        return "redirect:/user/test/getQuestion";
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
//    @RequestMapping(value = "/getTopics", method = RequestMethod.GET, headers = "Accept=application/json")
//    public String getTopics(Model model) {
//        List<Topic> listOfTopics = topicService.findAllTopic();
//        model.addAttribute("topic", new Topic());
//        model.addAttribute("listOfTopics", listOfTopics);
//        return "user/chooseTopicAndTest";
//    }

//    @RequestMapping(value = "/getTestsFromTopic/{topicId}", method = RequestMethod.GET, headers = "Accept=application/json")
//    public String getTestsFromTopic(Model model, @PathVariable("topicId") Integer topicId) {
//        Topic topic = topicService.getTopicById(topicId);
//        List<Test> listOfTests = testService.findByTopicId(topic.getId());
//        model.addAttribute("test", new Test());
//        model.addAttribute("listOfTests", listOfTests);
//        return "user/chooseTopicAndTest";
//    }

    @RequestMapping(value = "/getTestsFromTopic/{topicId}", method = RequestMethod.GET)
    public ResponseEntity<List<Test>> getTestsFromTopic(@PathVariable("topicId") Integer topicId) {
        Topic topic = topicService.getTopicById(topicId);
        List<Test> listOfTests = testService.findByTopicId(topic.getId());
//        List<Test> testList = new ArrayList<>();
//        Test test = new Test("sdfsdfsd");
//        testList.add(test);
//        return new ResponseEntity<>(testList, HttpStatus.OK);
        return new ResponseEntity<>(listOfTests, HttpStatus.OK);
    }

}
