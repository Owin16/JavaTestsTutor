package com.JavaTests.services.tutorService;

import com.JavaTests.entity.Question;
import com.JavaTests.entity.Topic;

import java.util.List;

public interface QuestionService {

    void addQuestion(Question question);

    Question findById(Integer id);

    List<Question> getQuestions();

    List<Question> findByTestId(Integer id);

    Question findByDescription(String questionDescription);

    void deleteQuestion(Question question);
}
