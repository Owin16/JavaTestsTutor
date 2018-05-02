package com.JavaTests.services.impl;

import com.JavaTests.entity.Answer;
import com.JavaTests.repository.AnswerRepository;
import com.JavaTests.services.AnswerService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Override
    public void addAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Override
    public List<Answer> findByQuestionId(Integer questionId) {
        return answerRepository.findByQuestionId(questionId);
    }

    @Override
    public void deleteAnswer(Answer answer) {
        answerRepository.delete(answer);
    }

    @Override
    public Answer findById(Integer answerId) {
        return answerRepository.findById(answerId);
    }

    @Override
    public void updateAnswer(Answer answer) {
        Answer answer1 = answerRepository.findOne(answer.getId());
        if (answer1 != null){
            answer.setId(answer1.getId());
            answerRepository.save(answer);
        }
    }


}
