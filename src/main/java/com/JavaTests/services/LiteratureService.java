package com.JavaTests.services;

import com.JavaTests.entity.Literature;

import java.util.List;

public interface LiteratureService {

    void addLiterature(Literature literature);

    void updateLiterature(Literature literature);

    void deleteLiterature(Literature literature);

    List<Literature> findAll();

    List<Literature> findByQuestionId(Integer questionId);
}
