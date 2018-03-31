package com.JavaTests.entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user")
    private int user;

    @Column(name = "tutor")
    private int tutor;

    @Column(name = "admin")
    private int admin;


    public Role() {
    }


    public Role(int user, int tutor, int admin) {
        this.user = user;
        this.tutor = tutor;
        this.admin = admin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getTutor() {
        return tutor;
    }

    public void setTutor(int tutor) {
        this.tutor = tutor;
    }

    public int getAdmin() {
        return admin;
    }

    public void setAdmin(int admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", user=" + user +
                ", tutor=" + tutor +
                ", admin=" + admin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role role = (Role) o;

        if (getId() != role.getId()) return false;
        if (getUser() != role.getUser()) return false;
        if (getTutor() != role.getTutor()) return false;
        return getAdmin()==(role.getAdmin());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getUser();
        result = 31 * result + getTutor();
        result = 31 * result + getAdmin();
        return result;
    }
}
