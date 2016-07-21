package cn.net.wangchenyu.finance.RepairReport;
/**
 * Created by lenovo on 2016/7/14.
 */
import cn.net.wangchenyu.finance.dao.RepairListDao;
import cn.net.wangchenyu.finance.dao.UserDao;
import cn.net.wangchenyu.finance.model.*;

import cn.net.wangchenyu.finance.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
class RepairReportController {
    @Autowired//@Autowired可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作
    private AuthService authService;
    @Autowired
    private RepairListDao repairListDao;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private UserDao userDao;

    //实例化产品类型
    //保存信息
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
        String role = (String)httpSession.getAttribute("visit_user_role");
        if(role.equals("客服")) {
            repairListDao.save(repairList);
            returnMessage.id = 0;
            returnMessage.message = "提交成功！";
        }else{
            returnMessage.id = 1;
            returnMessage.message = "无权操作!";
        }
        return returnMessage;
    }

    //根据客户编号读取客户信息
    @RequestMapping("/backend/repairreport/getcustominfo")
    public Object getCustomInfo(int no){
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
        if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        };

        returnMessage.id=0;
        returnMessage.message = userDao.findOne(no);

        return returnMessage;
    }
}