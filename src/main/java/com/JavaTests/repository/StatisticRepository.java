package com.JavaTests.repository;

import com.JavaTests.entity.Statistic;
import com.mysql.jdbc.CallableStatement;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import java.sql.ResultSet;
import java.util.List;

public interface StatisticRepository extends CrudRepository<Statistic, Integer> {

}
