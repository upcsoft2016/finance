package cn.net.wangchenyu.finance.controller;

import cn.net.wangchenyu.finance.dao.UserTypeDao;
import cn.net.wangchenyu.finance.model.UserType;
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
