package com.JavaTests.services.adminService;

import com.JavaTests.entity.Topic;
import com.JavaTests.repository.TopicRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Transactional
public class AdminTopicService {

    @Autowired
    private TopicRepository topicRepository;

//    @Autowired
//    public TopicService(TopicRepository topicRepository) {
//        this.topicRepository = topicRepository;
//    }

    public List<Topic> getTopics() {
        return Lists.newArrayList(topicRepository.findAll());
    }

//    public Topic getTopicRest(Topic topic) {
//        return topicRepository.findAll(topic);
//    }

    public List<Topic> getTopicRest(Topic topic) {
        List<Topic> topicsList = new ArrayList<>();
        Iterator<Topic> iterator = topicRepository.findAll().iterator();
        while (iterator.hasNext()) {
            topicsList.add(iterator.next());
        }
        return topicsList;
    }


}
