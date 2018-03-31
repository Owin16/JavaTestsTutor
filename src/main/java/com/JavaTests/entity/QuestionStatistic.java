package com.JavaTests.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "question_statistic")
public class QuestionStatistic {

    @Id
    @Column(name = "questionId")
    private int questionId;
    @Column(name = "description")
    private String description;
    @Column(name = "count")
    private int count;
    @Column(name = "correct")
    private double correct;
    @Column(name = "incorrect")
    private double incorrect;

    public QuestionStatistic(){

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public double getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(double incorrect) {
        this.incorrect = incorrect;
    }
}
