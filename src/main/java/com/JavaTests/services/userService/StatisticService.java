package com.JavaTests.services.userService;

import com.JavaTests.entity.Statistic;
import com.JavaTests.repository.StatisticRepository;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StatisticService {

    @Autowired
    private StatisticRepository statisticRepository;


    public List<Statistic> findAll(){
        return Lists.newArrayList(statisticRepository.findAll());
    }

    public Statistic getById(int id){
        return statisticRepository.findOne(id);
    }

    public void addStatistic(Statistic statistic) {
        statisticRepository.save(statistic);
    }

    public void updateStatistic(Statistic statistic) {
        statisticRepository.save(statistic);
    }

    public void deleteStatistic(int id) {
        statisticRepository.delete(id);
    }
}
