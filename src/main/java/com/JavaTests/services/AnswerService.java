package com.JavaTests.services;

import com.JavaTests.entity.Answer;

import java.util.List;

public interface AnswerService {

    void addAnswer(Answer answer);

    List<Answer> findByQuestionId(Integer questionId);

    void deleteAnswer(Answer answer);

    Answer findById(Integer answerId);

    void updateAnswer(Answer answer);
}
