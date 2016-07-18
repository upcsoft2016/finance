package cn.net.wangchenyu.test2.controller;

import cn.net.wangchenyu.test2.dao.ComponentsDao;
import cn.net.wangchenyu.test2.dao.OutputDao;
import cn.net.wangchenyu.test2.dao.StatementDao;
import cn.net.wangchenyu.test2.model.Components;
import cn.net.wangchenyu.test2.model.Output;
import cn.net.wangchenyu.test2.model.Statement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;

/**
 * Created by JunFeng on 2016/7/18.
 */
@RestController
public class InsertController {
    @Autowired
    private ComponentsDao componentsDao;
    @Autowired
    private OutputDao outputDao;
    @Autowired
    private StatementDao statementDao;

    @RequestMapping("/insertsta")
    public void insertsta(Statement statement) {
        statementDao.save(statement);
    }

    @RequestMapping("/insertout")
    public void insert(Output output) {
        outputDao.save(output);
    }

    @RequestMapping("/searchandinsert")
    public void searchandinsert(Components components) {
        if (componentsDao.exists(components.getUid())) {
            componentsDao.findByName(components.getName());
            componentsDao.findByName(components.getName());
        } else {
            int i=components.getAmount();
            int j=components.getWline();
            if(i>j) components.setStatus("正常");
            else if (i==0) components.setStatus("缺货") ;
            else if (i==j) components.setStatus("临界");
            else components.setStatus("警戒");
            componentsDao.save(components);
        }
    }


   @RequestMapping("/searchanddelete")
    public void searchanddelete(Output output) {
       componentsDao.findByName(output.getName());
       componentsDao.findByName(output.getName());
    }

    @RequestMapping("/status")
    public void setstatus(Components components){
        int i=components.getAmount();
        int j=components.getWline();
        if(i>j) components.setStatus("正常");
        else if (i==0) components.setStatus("缺货") ;
        else if (i==j) components.setStatus("临界");
        else components.setStatus("警戒");
        //componentsDao.save(components);
    }


}



