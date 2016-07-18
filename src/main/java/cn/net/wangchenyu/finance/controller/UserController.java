package cn.net.wangchenyu.finance.controller;

import cn.net.wangchenyu.finance.dao.UserDao;
import cn.net.wangchenyu.finance.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * Created by luxin on 2016/7/18.
 */
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/createuser")
    public Object createUser(){
        Date date = new Date(System.currentTimeMillis());
        User user=new User(1,"",date,3,"","","","","","","");
        return userDao.save(user);
    }
    @RequestMapping("/checkuser")
    public Object checkUser(String no,String name){
        return userDao.findByNoOrName(no,name);
    }

    @RequestMapping("/showall")
    public Object showAll(){
        return userDao.findAll();
    }

    @RequestMapping("/deleteall")
    public void deleteAll(){
        userDao.deleteAll();
    }
    @RequestMapping("/delete")
    public void deleteUser(String no){
        userDao.deleteByNo(no);
    }
}
