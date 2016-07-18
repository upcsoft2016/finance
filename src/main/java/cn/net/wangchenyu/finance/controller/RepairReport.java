package com.repairlist.controllers.manage;

import com.repairlist.lists.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2016/7/18.
 */
@RestController
class RepairReport {
    @Autowired
    private RepairListDao repairListDao;
    @Autowired
    private ProductTypeDao productTypeDao;
    @Autowired
    private FaultTypeDao faultTypeDao;
    @Autowired
    private RepairStatusDao repairStatusDao;
    //读取报修表
    @RequestMapping("/showlist")
    public Object showlist(){
        return repairListDao.findAll();
    }
    //读取产品类型
    @RequestMapping("/showproducetype")
    public Object showproducetype(){
        return productTypeDao.findAll();
    }
    //读取故障类型
    @RequestMapping("/showfaulttype")
    public Object showfaulttype(){
        return faultTypeDao.findAll();
    }
    //读取报修状态
    @RequestMapping("/showrepairstatus")
    public Object showrepairstatus(){
        return repairStatusDao.findAll();
    }
    //往保修表写入信息，保存并显示
    @RequestMapping(value = "/verify")
    public Object verify(RepairList repairList) {
      return repairListDao.save(repairList);
    }
}
