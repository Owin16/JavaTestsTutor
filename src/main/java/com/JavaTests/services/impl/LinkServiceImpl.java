package com.JavaTests.services.impl;

import com.JavaTests.entity.Link;
import com.JavaTests.repository.LinkRepository;
import com.JavaTests.services.LinkService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkRepository linkRepository;

    @Override
    public void addLink(Link link) {
        linkRepository.save(link);
    }

    @Override
    public void updateLink(Link link) {
        Link link1 = linkRepository.findOne(link.getId());
        if (link1 != null) {
            link.setId(link1.getId());
            linkRepository.save(link);
        }
    }

    @Override
    public void deleteLink(Link link) {
        linkRepository.delete(link);
    }

    @Override
    public List<Link> findAll() {
        List<Link> linkList = new ArrayList<>();
        Iterator<Link> iterator = linkRepository.findAll().iterator();
        while (iterator.hasNext()){
            linkList.add(iterator.next());
        }
        return linkList;
    }

    @Override
    public List<Link> findByLiteratureId(Integer id) {
        return linkRepository.findByLiteratureId(id);
    }
}
