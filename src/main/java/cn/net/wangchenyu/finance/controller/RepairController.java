package cn.net.wangchenyu.finance.controller;
/**
 * Created by lenovo on 2016/7/14.
 */
import cn.net.wangchenyu.finance.dao.FaultTypeDao;
import cn.net.wangchenyu.finance.dao.ProductTypeDao;
import cn.net.wangchenyu.finance.dao.RepairListDao;
import cn.net.wangchenyu.finance.dao.ReportStatusDao;
import cn.net.wangchenyu.finance.model.*;

import cn.net.wangchenyu.finance.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
class RepairController {
    @Autowired//@Autowired可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作
    private ProductTypeDao producttypeDao;
    @Autowired
    private FaultTypeDao faulttypeDao;
    @Autowired
    private ReportStatusDao repairstatusDao;
    @Autowired
    private AuthService authService;
    @Autowired
    private RepairListDao repairListDao;
    //实例化产品类型
    @RequestMapping("/create1")//地址映射
    public Object create1() {
        ProductType productType = new ProductType();
        productType.setId(1);
        productType.setType("台式机");
        return producttypeDao.save(productType);
    }
    //实例化产品类型
    @RequestMapping("/backend/repairreport/setinfo")//地址映射
    public Object setInfo(RepairList repairList) {
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
        if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        };

        //验证通过后保存到数据库
        repairListDao.save(repairList);
        returnMessage.id = 0;
        returnMessage.message = "保存成功！";
        return returnMessage;
    }
}