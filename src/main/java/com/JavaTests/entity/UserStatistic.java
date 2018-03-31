package com.JavaTests.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_statistic")
public class UserStatistic {

    @Id
    @Column(name = "userId")
    private int userId;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "count")
    private int count;
    @Column(name = "correct")
    private double correct;
    @Column(name = "incorrect")
    private double incorrect;

    public UserStatistic(){

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getIncorrect() {
        return incorrect;
    }

    public void setIncorrect(double incorrect) {
        this.incorrect = incorrect;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
