package com.JavaTests.services.userService;

import com.JavaTests.entity.Answer;
import com.JavaTests.repository.AnswerRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnswerService {

    @Autowired
    private AnswerRepository answerRepository;


    public List<Answer> findAll(){
        return Lists.newArrayList(answerRepository.findAll());
    }

    public Answer getById(int id){
        return answerRepository.findOne(id);
    }

    public void addAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public void updateAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public void deleteAnswer(int id) {
        answerRepository.delete(id);
    }

    public List<Answer> findByQuestionId(Integer questionId){
        return Lists.newArrayList(answerRepository.findByQuestionId(questionId));
    }

}
