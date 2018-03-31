package com.JavaTests.services;

import com.JavaTests.entity.Literature;
import com.JavaTests.repository.LiteratureRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LiteratureService {

    @Autowired
    private LiteratureRepository literatureRepository;


    public List<Literature> findAll(){
        return Lists.newArrayList(literatureRepository.findAll());
    }

    public Literature getById(int id){
        return literatureRepository.findOne(id);
    }

    public void addLiterature(Literature literature) {
        literatureRepository.save(literature);
    }

    public void updateLiterature(Literature literature) {
        literatureRepository.save(literature);
    }

    public void deleteLiterature(int id) {
        literatureRepository.delete(id);
    }
}
