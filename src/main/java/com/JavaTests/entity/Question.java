package com.JavaTests.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "question")
@NamedNativeQuery(name = "Question.findByUserId",query = "select q.description, s.correct, l.description, link.link from" +
        " question as q join statistic as s on q.id = s.questionId join literature as l on q.id = l.questionId join" +
        " link on l.id = link.literatureId where s.userId = ? group by q.description")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "testId")
    private Test test;

    public Question() {
    }

    public Question(String description) {
        this.description = description;
    }

    public Question(String description, Test test) {
        this.description = description;
        this.test = test;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

}
