package com.vacation.java.user.models;

import javax.persistence.*;

/**
 * Created by luxin on 2016/7/17.
 */
@Entity
@Table(name="fx_UserType")
public class UserType {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String usertype;

    public int getId() {
        return id;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }
}
