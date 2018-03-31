package com.JavaTests.services.tutorService.Impl;

import com.JavaTests.entity.Topic;
import com.JavaTests.repository.TopicRepository;
import com.JavaTests.services.tutorService.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Transactional
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Transactional
    public Topic findByTopicName(String name) {
        return topicRepository.findByName(name);
    }

    @Transactional
    public void deleteTopic(Topic topic) {

    }

    @Transactional
    public void editTopic(Topic topic) {

    }

    @Transactional
    public List<Topic> getTopics() {
        List<Topic> topicList = new ArrayList<>();
        Iterator<Topic> iterator = topicRepository.findAll().iterator();
        while(iterator.hasNext())
            topicList.add(iterator.next());
        return topicList;
    }
}
