package com.vacation.java.user.controllers;

import com.vacation.java.user.daos.UserTypeDao;
import com.vacation.java.user.models.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by luxin on 2016/7/18.
 */
public class UserTypeController {
    @Autowired
    private UserTypeDao userTypeDao;
    @RequestMapping("/usertype")
    public Object ccharacter(String usertype){
        UserType type = new UserType();
        type.setUsertype("usertype");
        return userTypeDao.save(type);
    }
}
