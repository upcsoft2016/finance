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
    @RequestMapping("/backend/repairreport/setinfo")//地址映射
    public Object setInfo(RepairList repairList) {
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
        /*if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        };
        //验证通过后保存到数据库
        if(authService.isAuthenticated()){
            if(authService.getCurrentUserRole().equal("客户")){
            repairListDao.save(repairList);
            returnMessage.id = 0;
            returnMessage.message = "提交成功！";
            }
        }
        return returnMessage;
      }*/
        RepairList repairList1 = new RepairList(repairList.Maintenancenumber,repairList.customerID,repairList.producttype,
                repairList.IMVorDelta,repairList.machinemodel,repairList.serialnumber,repairList.lackparts,repairList.machinefaultpheno,
                repairList.faulttype,repairList.appearanceinsp,repairList.bootpassword,repairList.importinformation,repairList.HDD,
                repairList.memory,repairList.PCcard,repairList.acadapter,repairList.battery ,repairList.externaldrives,
                repairList.floppydrive,repairList.others,repairList.repairtime,repairList.estimateprice,repairList.repairstatus);
        repairListDao.save(repairList1);

}