package com.JavaTests.services.userService;

import com.JavaTests.entity.Topic;
import com.JavaTests.repository.TopicRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    public Topic findTopicByName(String name) {
        return topicRepository.findByName(name);
    }

    public List<Topic> findAllTopic(){
        return Lists.newArrayList(topicRepository.findAll());
    }

    public Topic getTopicById(int id){
        return topicRepository.findOne(id);
    }

}
