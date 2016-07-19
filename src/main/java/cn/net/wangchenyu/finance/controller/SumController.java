package cn.net.wangchenyu.finance.controller;

import cn.net.wangchenyu.finance.dao.RepairListDao;
import cn.net.wangchenyu.finance.model.RepairList;
import cn.net.wangchenyu.finance.model.ReturnMessage;
import lists.ClosingCost;
import lists.ClosingCostDao;
import lists.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

/**
 * Created by lenovo on 2016/7/17.
 */
@RestController
public class SumController {

    @Autowired
    private RepairListDao repairListDao;
    @RequestMapping("/backend/feesummary/getall")
   public Object dadea(){
      /*  ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.id = 1;
        returnMessage.message ="abc";
        return  returnMessage;*/
        Iterable<RepairList> repairList = repairListDao.findAll();
        return repairList;
    }

    @RequestMapping(value="/backend/feesummary/submit",method= RequestMethod.POST)
    public Object
        dateb(){
    }

    @RequestMapping(value="backend/feesummary/getdetail",method=RequestMethod.POST)
    public Object dadec(){

    }
}