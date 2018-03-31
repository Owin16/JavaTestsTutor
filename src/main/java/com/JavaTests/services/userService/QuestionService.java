package com.JavaTests.services.userService;

import com.JavaTests.entity.Question;
import com.JavaTests.repository.QuestionRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;


    public List<Question> findAll(){
        return Lists.newArrayList(questionRepository.findAll());
    }

    public Question getById(int id){
        return questionRepository.findOne(id);
    }

    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    public void updateQuestion(Question question) {
        questionRepository.save(question);
    }

    public void deleteQuestion(int id) {
        questionRepository.delete(id);
    }

    public List<Question> findByUserId(int id){
        return Lists.newArrayList(questionRepository.findByUserId(id));
    }

    public List<Question> findByTestId(Integer testId){
        return Lists.newArrayList(questionRepository.findByTestId(testId));
    }

    public List<Question> findByTestName(String testName){
        return Lists.newArrayList(questionRepository.findByTestName(testName));
    }
}
