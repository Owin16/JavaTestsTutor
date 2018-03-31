package com.JavaTests.services.tutorService.Impl;

import com.JavaTests.entity.Answer;
import com.JavaTests.repository.AnswerRepository;
import com.JavaTests.services.tutorService.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    public void addAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    @Transactional
    public List<Answer> findByQuestionId(Integer questionId) {
        return answerRepository.findByQuestionId(questionId);
    }
}
