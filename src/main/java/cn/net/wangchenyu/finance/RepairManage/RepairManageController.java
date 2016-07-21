package cn.net.wangchenyu.finance.RepairManage;

import cn.net.wangchenyu.finance.dao.OutputDao;
import cn.net.wangchenyu.finance.dao.RepairRecordDao;
import cn.net.wangchenyu.finance.model.Output;
import cn.net.wangchenyu.finance.model.RepairRecord;
import cn.net.wangchenyu.finance.model.ReturnMessage;
import cn.net.wangchenyu.finance.service.AuthService;
import cn.net.wangchenyu.finance.session.SessionUser;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by cheneyveron on 7/19/16.
 */
@RestController
public class RepairManageController {

    @Autowired
    private AuthService authService;
    @Autowired
    private RepairRecordDao repairRecordDao;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private OutputDao outputDao;

    //获取系统中所有的任务
    @RequestMapping(method = RequestMethod.GET, path = "/backend/repairmanage/getalltasks")
    public Object getAllTasks(){
        ReturnMessage returnMessage = new ReturnMessage();
        if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "您未登录!";
            return returnMessage;
        }//如果未认证

        //找出前20未完成的项
        List<RepairRecord> repairRecords = repairRecordDao.findTop20ByRepairstatus("未分配");
        repairRecords.addAll(repairRecordDao.findTop20ByRepairstatus("分配未检测"));
        repairRecords.addAll(repairRecordDao.findTop20ByRepairstatus("检测完成维修未完成"));
        //建立taskDetail对象链表
        List<taskDetail> taskDetails = new ArrayList<taskDetail>(){};
        //格式化日期
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //重新载入RepairRecord进taskDetails
        for(RepairRecord repairRecord:repairRecords){
            taskDetails.add(new taskDetail(repairRecord.getRepairnumber(),repairRecord.getRepairpersonnel(),repairRecord.getInspectionrecord(),repairRecord.getRepairrecord(),formatter.format(repairRecord.getRepairinspection()),repairRecord.getWorkload(), repairRecord.getRepairdevice(),repairRecord.getRepairstatus()));
        }

        returnMessage.id = 0;
        returnMessage.message = repairRecords;
        return returnMessage;
    }

    //获取我的任务
    @RequestMapping(method = RequestMethod.GET, path = "/backend/repairmanage/mytasks")
    public Object myTasks(){
        ReturnMessage returnMessage = new ReturnMessage();
        if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "您未登录!";
            return returnMessage;
        }//如果未认证
        //只有技术工程师能访问
        String UserRole = (String) httpSession.getAttribute("visit_user_role");
        if(!UserRole.equals("技术工程师")){
            returnMessage.id = 1;
            returnMessage.message = "您无权访问!";
            return returnMessage;
        }//不是技术工程师则提示无权访问

        //读取所有的维修记录
        List<RepairRecord> repairRecords = repairRecordDao.findByRepairpersonnel((int)httpSession.getAttribute("visit_user_id"));
        returnMessage.id = 0;
        returnMessage.message = repairRecords;

        return returnMessage;
    }

    //修改记录
    @RequestMapping(method = RequestMethod.POST, path = "/backend/repairmanage/modifymine")
    public Object modifyMine(RepairRecord repairRecord){
        ReturnMessage returnMessage = new ReturnMessage();
        if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "您未登录!";
            return returnMessage;
        }//如果未认证,直接return

        //检查是否是此人的维修任务
        RepairRecord repairRecordCheck = repairRecordDao.findOne(repairRecord.getRepairnumber());
        if(repairRecordCheck==null){
            returnMessage.id = 1;
            returnMessage.message = "维修任务不存在!";
            return returnMessage;
        }else{
            if(repairRecordCheck.getRepairpersonnel()!=(int)httpSession.getAttribute("visit_user_id")){
                returnMessage.id = 1;
                returnMessage.message = "不是你的维修任务!";
                return returnMessage;
            }
        }

        //如果一切通过
        //保存到数据库
        repairRecordDao.save(repairRecord);

        returnMessage.id = 0;
        returnMessage.message = "修改成功。";
        return returnMessage;
    }

    //删除记录
    @RequestMapping(method = RequestMethod.POST, path = "/backend/repairmanage/deletemine")
    public Object deleteMine(int Repairnumber){
        ReturnMessage returnMessage = new ReturnMessage();
        if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "您未登录!";
            return returnMessage;
        }//如果未认证,直接return

        //检查是否是此人的维修任务
        RepairRecord repairRecordCheck = repairRecordDao.findOne(Repairnumber);
        if(repairRecordCheck==null){
            returnMessage.id = 1;
            returnMessage.message = "维修任务不存在!";
            return returnMessage;
        }else{
            if(repairRecordCheck.getRepairpersonnel()!=(int)httpSession.getAttribute("visit_user_id")){
                returnMessage.id = 1;
                returnMessage.message = "不是你的维修任务!";
                return returnMessage;
            }
        }

        //全部通过,删除数据库
        repairRecordDao.delete(Repairnumber);

        returnMessage.id = 0;
        returnMessage.message = "删除成功。";
        return returnMessage;
    }

    //申请备件
    @RequestMapping(method = RequestMethod.POST, path = "/backend/repairmanage/requirepart")
    public Object requirePart(RequiredPart requiredPart){
        ReturnMessage returnMessage = new ReturnMessage();
        if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "您未登录!";
            return returnMessage;
        }//如果未认证,直接return

        //检查是否是此人的维修任务
        RepairRecord repairRecordCheck = repairRecordDao.findOne(requiredPart.Repairnumber);
        if(repairRecordCheck==null){
            returnMessage.id = 1;
            returnMessage.message = "维修任务不存在!";
            return returnMessage;
        }else{
            if(repairRecordCheck.getRepairpersonnel()!=(int)httpSession.getAttribute("visit_user_id")){
                returnMessage.id = 1;
                returnMessage.message = "不是你的维修任务!";
                return returnMessage;
            }
        }

        //检查通过,修改待出库记录
        Output output = new Output(requiredPart.Name,(int)httpSession.getAttribute("visit_user_id"),requiredPart.Qid, requiredPart.Repairnumber,requiredPart.amount);
        outputDao.save(output);

        returnMessage.id = 0;
        returnMessage.message = "添加成功";
        return returnMessage;
    }

    //获取并处理时间的方法
    @RequestMapping("/gettime")
    public Object gettime(Date time){
        //格式化的方法
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
/*        //创建一个基于传入时间的date对象
        Date date = new Date(time);*/
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.message = formatter.format(time);
        return returnMessage;
    }
}
