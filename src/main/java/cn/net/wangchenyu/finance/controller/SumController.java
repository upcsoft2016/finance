package cn.net.wangchenyu.finance.controller;

import cn.net.wangchenyu.finance.dao.ClosingCostDao;
import cn.net.wangchenyu.finance.dao.RepairListDao;
import cn.net.wangchenyu.finance.model.ClosingCost;
import cn.net.wangchenyu.finance.model.RepairList;
import cn.net.wangchenyu.finance.model.ReturnMessage;
import cn.net.wangchenyu.finance.service.AuthService;
import lists.ClosingCost;
import lists.ClosingCostDao;
import lists.ReturnMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2016/7/17.
 */

@RestController
public class SumController {

   @Autowired
   private ClosingCostDao closingCostDao;
   @Autowired
   private AuthService authService;

   @RequestMapping("/backend/feesummary/submit")
   public  Object postInnfo(ClosingCost closingCost){
      ReturnMessage returnMessage = new ReturnMessage();
      if(!authService.isAuthenticated()) {
         returnMessage.id = 1;
         returnMessage.message = "请先登录";
         return returnMessage;
      }

      closingCostDao.save(closingCost);

      returnMessage.id = 0;
      returnMessage.message= "添加成功";
      return  returnMessage;
   }

   @RequestMapping("/backend/feesummary/getall")
    public Object getNumber(ClosingCost closingCost){
      ReturnMessage returnMessage = new ReturnMessage();
      closingCostDao.findOne();
      returnMessage.id = 0;
      returnMessage.message="查找成功";
      return returnMessage;
   }

   @RequestMapping("backend/feesummary/getdetail")
   public Object getDetail(ClosingCost closingCost){
      ReturnMessage returnMessage = new ReturnMessage();
      closingCostDao.findOne();
      returnMessage.id = 0;
      returnMessage.message ="";
   }

}