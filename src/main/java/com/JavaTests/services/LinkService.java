package com.JavaTests.services;

import com.JavaTests.entity.Link;

import java.util.List;

public interface LinkService {

    void addLink(Link link);

    void updateLink(Link link);

    void deleteLink(Link link);

    List<Link> findAll();

    List<Link> findByLiteratureId(Integer id);
}
