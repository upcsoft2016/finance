package com.vacation.java.user.models;

import javax.persistence.*;

/**
 * Created by luxin on 2016/7/17.
 */
@Entity
@Table(name="fx_WorkRole")
public class WorkRole {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String workrole;

    public int getId() {
        return id;
    }

    public String getWorkrole() {
        return workrole;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWorkrole(String workrole) {
        this.workrole = workrole;
    }
}
