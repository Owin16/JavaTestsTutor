package com.JavaTests.services;

import com.JavaTests.entity.Topic;

import java.util.List;

public interface TopicService {

    void addTopic(Topic topic);

    Topic findByTopicName(String name);

    List<Topic> getTopics();

    void deleteTopic(Topic topic);

    void updateTopic(Topic topic);
}
