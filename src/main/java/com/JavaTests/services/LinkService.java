package com.JavaTests.services;

import com.JavaTests.entity.Link;
import com.JavaTests.repository.LinkRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LinkService {

    @Autowired
    private LinkRepository linkRepository;


    public List<Link> findAll(){
        return Lists.newArrayList(linkRepository.findAll());
    }

    public Link getById(int id){
        return linkRepository.findOne(id);
    }

    public void addLink(Link link) {
        linkRepository.save(link);
    }

    public void updateLink(Link link) {
        linkRepository.save(link);
    }

    public void deleteLink(int id) {
        linkRepository.delete(id);
    }
}
