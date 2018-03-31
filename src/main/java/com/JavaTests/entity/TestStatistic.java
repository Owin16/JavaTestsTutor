package com.JavaTests.entity;

import javax.persistence.*;

@Entity
@Table(name = "test_statistic")
public class TestStatistic {

    @Id
    @Column(name = "testId")
    private int testId;
    @Column(name = "name")
    private String name;
    @Column(name = "count")
    private int count;
    @Column(name = "correct")
    private double correct;
    @Column(name = "incorrect")
    private double incorrect;

    public TestStatistic(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getCorrect() {
        return correct;
    }

    public void setCorrect(double correct) {
        this.correct = correct;
    }

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public double getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(double incorrect) {
        this.incorrect = incorrect;
    }
}
