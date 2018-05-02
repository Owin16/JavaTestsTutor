package com.JavaTests.services.impl;

import com.JavaTests.entity.Literature;
import com.JavaTests.entity.Question;
import com.JavaTests.repository.LiteratureRepository;
import com.JavaTests.services.LiteratureService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class LiteratureServiceImpl implements LiteratureService {

    @Autowired
    private LiteratureRepository literatureRepository;

    public void addLiterature(Literature literature) {
        literatureRepository.save(literature);
    }

    public void updateLiterature(Literature literature) {
        Literature literature1 = literatureRepository.findOne(literature.getId());
        if (literature1 != null) {
            literature.setId(literature1.getId());
            literatureRepository.save(literature);
        }
    }

    public void deleteLiterature(Literature literature) {
        literatureRepository.delete(literature);
    }

    @Override
    public List<Literature> findAll() {
        List<Literature> literatureList = new ArrayList<>();
        Iterator<Literature> iterator = literatureRepository.findAll().iterator();
        while (iterator.hasNext()){
            literatureList.add(iterator.next());
        }
        return literatureList;
    }

    public List<Literature> findByQuestionId(Integer questionId) {
        return literatureRepository.findByQuestionId(questionId);
    }
}
