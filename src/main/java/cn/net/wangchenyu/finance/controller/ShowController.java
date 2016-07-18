package cn.net.wangchenyu.test2.controller;

import cn.net.wangchenyu.test2.dao.ComponentsDao;
import cn.net.wangchenyu.test2.dao.OutputDao;
import cn.net.wangchenyu.test2.dao.StatementDao;
import cn.net.wangchenyu.test2.model.Components;
import cn.net.wangchenyu.test2.model.Output;
import cn.net.wangchenyu.test2.model.ReturnMessage;
import cn.net.wangchenyu.test2.model.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by JunFeng on 2016/7/18.
 */
@RestController
public class ShowController {
/*
    @Autowired
    private ComponentsDao componentsDao;
    @Autowired
    private OutputDao outputDao;
    @Autowired
    private StatementDao statementDao;

    @RequestMapping("/findallcom")
    public Object  findallcom(){
        return componentsDao.findAll();
    }
    @RequestMapping("/findallpro")
    public Object  findallpro(){
        return outputDao.findAll();
    }

    @RequestMapping("/findallsta")
    public Object  findallsta(){
        return statementDao.findAll();
    }
    @RequestMapping("/verify1")
    public Object verify(Components components){
        ReturnMessage returnMessage=new ReturnMessage();
        returnMessage.setMessage(components.getName());
        returnMessage.setMid(components.getUid());
        return returnMessage;

    }
    @RequestMapping("/verify2")
    public Object verify(Output output){
        ReturnMessage returnMessage=new ReturnMessage();
        returnMessage.setMessage(output.getName());
        returnMessage.setMid(output.getUid());
        return returnMessage;

    }
    @RequestMapping("/verify3")
    public Object verify(Statement statement){
        ReturnMessage returnMessage=new ReturnMessage();
        returnMessage.setMessage(statement.getName());
        returnMessage.setMid(statement.getUid());
        return returnMessage;

    }*/
}
