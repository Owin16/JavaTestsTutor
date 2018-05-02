package com.JavaTests.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "roleId")
    private Role role;

    public User() {
    }

    public User(String firstName, String lastName, String login, String password, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
//
//    public List<Statistic> getListStatistics() {
//        return listStatistics;
//    }
//
//    public void setListStatistics(List<Statistic> listStatistics) {
//        this.listStatistics = listStatistics;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName=" + lastName +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", role=" + role +
//                ", listStatistics=" + listStatistics +
                '}';
    }

//        @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//
//        User user = (User) o;
//
//        if (getId() != user.getId()) return false;
//        if (isLastName() != user.isLastName()) return false;
//        if (getPassword() != user.getPassword()) return false;
//        if (!getFirstName().equals(user.getFirstName())) return false;
//        if (!getLogin().equals(user.getLogin())) return false;
//        if (!getRole().equals(user.getRole())) return false;
//        return getListStatistics() != null ? getListStatistics().equals(user.getListStatistics()) : user.getListStatistics() == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getId();
//        result = 31 * result + getFirstName().hashCode();
//        result = 31 * result + (isLastName() ? 1 : 0);
//        result = 31 * result + getLogin().hashCode();
//        result = 31 * result + getPassword();
//        result = 31 * result + getRole().hashCode();
//        result = 31 * result + (getListStatistics() != null ? getListStatistics().hashCode() : 0);
//        return result;
//    }
}
