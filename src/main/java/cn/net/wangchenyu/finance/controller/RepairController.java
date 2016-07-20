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
        if(authService.isAuthenticated()){
            if(authService.getCurrentUserRole()){
                if(toString().equals("客服"))
            repairListDao.save(repairList);
            returnMessage.id = 0;
            returnMessage.message = "提交成功！";
            }
        }
        return returnMessage;
    }
    /*class ReportInfo {
        private int Maintenancenumber;     //维修编号
        private int CustomerID;            //客户编号
        private int Producttype;          //产品类型
        private String IMVorDelta;        //机器品牌
        private String Machinemodel;      //机器型号
        private String Serialnumber;      //系列号
        private String Serialnumber;     //系列号
        private String Lackparts;         //缺少零件
        private String Machinefaultpheno;//机器故障现象
        private int Faulttype;          //故障类型
        private String Appearanceinsp;   //机器外观检查
        private String Bootpassword;     //开机口令
        private String Importinformation;//重要资料
        private String HDD;              //硬件
        private String Memory;           //内存
        private String PCcard;           //外置PC卡
        private String Acadapter;        //ＡＣ适配器
        private String Battery;           //电池
        private String Externaldrives;    //外接光驱
        private String Floppydrive;       //外接软驱
        private String Others;            //其它
        private String Repairtime;        //报修时间
        private float Estimateprice;     //预估价格
        private int Repairstatus;         //报修状态
        }*/
}