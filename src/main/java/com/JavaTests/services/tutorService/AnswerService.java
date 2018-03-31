package com.JavaTests.services.tutorService;

import com.JavaTests.entity.Answer;

import java.util.List;

public interface AnswerService {

    void addAnswer(Answer answer);

    List<Answer> findByQuestionId(Integer questionId);
}
