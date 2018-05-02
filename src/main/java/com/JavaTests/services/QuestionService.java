package com.JavaTests.services;

import com.JavaTests.entity.Answer;
import com.JavaTests.entity.Question;

import java.util.List;

public interface QuestionService {

    void addQuestion(Question question);

    Question findById(Integer id);

    List<Question> getQuestions();

    List<Question> findByTestId(Integer id);

    Question findByDescription(String questionDescription);

    void deleteQuestion(Question question);

    void updateQuestion(Question question);
}
