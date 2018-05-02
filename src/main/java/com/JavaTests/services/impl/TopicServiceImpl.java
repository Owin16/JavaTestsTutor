package com.JavaTests.services.impl;

import com.JavaTests.entity.Topic;
import com.JavaTests.repository.TopicRepository;
import com.JavaTests.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void addTopic(Topic topic) {
        topicRepository.save(topic);
    }

    @Override
    public Topic findByTopicName(String name) {
        return topicRepository.findByName(name);
    }

    @Override
    public void deleteTopic(Topic topic) {
        topicRepository.delete(topic);
    }

    @Override
    public void updateTopic(Topic topic) {
        Topic topic1 = topicRepository.findOne(topic.getId());
        if (topic1 != null) {
            topic.setId(topic1.getId());
            topicRepository.save(topic);
        }
    }

    @Override
    public List<Topic> getTopics() {
        List<Topic> topicList = new ArrayList<>();
        Iterator<Topic> iterator = topicRepository.findAll().iterator();
        while(iterator.hasNext())
            topicList.add(iterator.next());
        return topicList;
    }
}
