package com.JavaTests.services.impl;

import com.JavaTests.entity.Question;
import com.JavaTests.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class QuestionServiceImpl implements com.JavaTests.services.QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public void addQuestion(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Question findById(Integer id) {
        return questionRepository.findById(id);
    }

    @Override
    public List<Question> getQuestions() {
        List<Question> questionList = new ArrayList<>();
        Iterator<Question> iterator = questionRepository.findAll().iterator();
        while(iterator.hasNext())
            questionList.add(iterator.next());
        return questionList;
    }


    @Override
    public List<Question> findByTestId(Integer testId) {
        return questionRepository.findByTestId(testId);
    }

    @Override
    public Question findByDescription(String questionDescription) {
        return questionRepository.findByDescription(questionDescription);
    }

    @Override
    public void deleteQuestion(Question question) {
        questionRepository.delete(question);
    }

    @Override
    public void updateQuestion(Question question) {
        Question question1 = questionRepository.findOne(question.getId());
        if (question1 != null){
            question.setId(question1.getId());
            questionRepository.save(question);
        }
    }
}
