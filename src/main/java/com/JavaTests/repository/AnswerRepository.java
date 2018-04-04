package com.JavaTests.repository;

import com.JavaTests.entity.Answer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Integer> {

    List<Answer> findByQuestionId(Integer questionId);

    Answer findByDescription(String answerDescription);

    Answer findById(Integer answerId);
}
