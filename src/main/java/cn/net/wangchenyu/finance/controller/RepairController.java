package com.repairlist.controllers;
/**
 * Created by lenovo on 2016/7/14.
 */
import com.repairlist.lists.*;
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
    private RepairStatusDao repairstatusDao;
    //实例化产品类型
    @RequestMapping("/create1")//地址映射
    public Object create1() {
        ProductType productType = new ProductType();
        productType.setId(1);
        productType.setType("台式机");
        return producttypeDao.save(productType);
    }
    @RequestMapping("/create2")
    public Object create2(){
        ProductType productType = new ProductType();
        productType.setId(2);
        productType.setType("笔记本");
        return producttypeDao.save(productType);
    }
    @RequestMapping("/create3")
    public Object create3(){
        ProductType productType = new ProductType();
        productType.setId(3);
        productType.setType("投影仪");
        return producttypeDao.save(productType);
    }
    @RequestMapping("/create4")
    public Object create4(){
        ProductType productType = new ProductType();
        productType.setId(4);
        productType.setType("打印机");
        return producttypeDao.save(productType);
    }
    @RequestMapping("/create5")
    public Object create5(){
        ProductType productType = new ProductType();
        productType.setId(5);
        productType.setType("其他");
        return producttypeDao.save(productType);
    }
    @RequestMapping("/create6")
    public Object create6(){
        FaultType faultType = new FaultType();
        faultType.setId(1);
        faultType.setType("固定性故障");
        return faulttypeDao.save(faultType);
    }
    @RequestMapping("/create7")
    public Object create7(){
        FaultType faultType = new FaultType();
        faultType.setId(2);
        faultType.setType("间隙性故障");
        return faulttypeDao.save(faultType);
    }
    @RequestMapping("/create8")
    public Object create8(){
        RepairStatus repairStatus = new RepairStatus();
        repairStatus.setId(0);
        repairStatus.setStatus("未打印");
        return repairstatusDao.save(repairStatus);
    }
    @RequestMapping("/create9")
    public Object create9(){
        RepairStatus repairStatus = new RepairStatus();
        repairStatus.setId(1);
        repairStatus.setStatus("打印");
        return repairstatusDao.save(repairStatus);
    }
    @RequestMapping("/create10")
    public Object create10(){
        RepairStatus repairStatus = new RepairStatus();
        repairStatus.setId(2);
        repairStatus.setStatus("提交");
        return repairstatusDao.save(repairStatus);
    }
}