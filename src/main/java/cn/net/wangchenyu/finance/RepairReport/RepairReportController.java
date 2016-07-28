package cn.net.wangchenyu.finance.RepairReport;
/**
 * Created by lenovo on 2016/7/14.
 */
import cn.net.wangchenyu.finance.dao.ManagerDao;
import cn.net.wangchenyu.finance.dao.RepairListDao;
import cn.net.wangchenyu.finance.dao.RepairRecordDao;
import cn.net.wangchenyu.finance.dao.UserDao;
import cn.net.wangchenyu.finance.model.*;

import cn.net.wangchenyu.finance.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
class RepairReportController {
    @Autowired//@Autowired可以对成员变量、方法和构造函数进行标注，来完成自动装配的工作
    private AuthService authService;
    @Autowired
    private RepairListDao repairListDao;
    @Autowired
    private RepairRecordDao repairRecordDao;
    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private UserDao userDao;

    //实例化产品类型
    //保存信息
    @RequestMapping("/backend/repairreport/setinfo")//地址映射
    public Object setInfo(
            int Maintenancenumber,
            int CustomerID,
            String Producttype,
            String IMVorDelta,
            String Machinemodel,
            String Serialnumber,
            String Lackparts,
            String Machinefaultpheno,
            String Faulttype,
            String Appearanceinsp,
            String Bootpassword,
            String Importinformation,
            String HDD,
            String Memory,
            String PCcard,
            String Acadapter,
            String Battery,
            String Externaldrives,
            String Floppydrive,
            String Others,
            Date Repairtime,
            float Estimateprice,
            String Repairstatus) {
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
        if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        };
        //创建repairList对象
        RepairList repairList = new RepairList(
                Maintenancenumber,
                CustomerID,
                Producttype,
                IMVorDelta,
                Machinemodel,
                Serialnumber,
                Lackparts,
                Machinefaultpheno,
                Faulttype,
                Appearanceinsp,
                Bootpassword, Importinformation,
                HDD,
                Memory,
                PCcard,
                Acadapter,
                Battery,
                Externaldrives,
                Floppydrive,
                Others,
                Repairtime,
                Estimateprice,
                Repairstatus);

        //验证通过后保存到数据库
        String role = (String)httpSession.getAttribute("visit_user_role");
        if(role!=null && role.equals("客服")) {
            //把当前记录保存到数据库
            repairList = repairListDao.save(repairList);

            /*----开始自动分配任务------*/
            //找出所有的维修人员
            //最少工作量和人员id
            int personId = -1;
            String personName = null;
            int least = 9999999;
            Iterable<Manager> managers = managerDao.findByWorkrole("技术工程师");
            for(Manager manager:managers){
                //如果当前最小工作量大于等于他的工作量
                int currentLoad = repairRecordDao.countByRepairpersonnelAndRepairstatus(manager.getNo(),"分配未检测")+repairRecordDao.countByRepairpersonnelAndRepairstatus(manager.getNo(),"检测完成维修未完成");
                if(least>=currentLoad){
                    least = currentLoad;
                    personId = manager.getNo();
                    personName = manager.getName();
                }
            }
            //此时personId则是最闲的那个人
            //新建一个维修记录
            RepairRecord repairRecord = new RepairRecord(repairList.Maintenancenumber,personId,"分配未检测");
            //保存到数据库
            repairRecordDao.save(repairRecord);
            /*------分配任务结束-------*/

            returnMessage.id = 0;
            returnMessage.message = "任务已分配给"+personName;
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