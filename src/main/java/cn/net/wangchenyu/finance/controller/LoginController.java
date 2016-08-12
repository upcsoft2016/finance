package cn.net.wangchenyu.finance.controller;

import cn.net.wangchenyu.finance.dao.LoginRecordDao;
import cn.net.wangchenyu.finance.dao.ManagerDao;
import cn.net.wangchenyu.finance.dao.RepairRecordDao;
import cn.net.wangchenyu.finance.model.*;
import cn.net.wangchenyu.finance.service.AuthService;
import cn.net.wangchenyu.finance.session.SessionUser;
import cn.net.wangchenyu.finance.util.RandomCharUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Column;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;

/**
 * Created by cheneyveron on 7/18/16.
 */
@RestController
public class LoginController {

    @Autowired
    private LoginRecordDao loginRecordDao;
    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private HttpSession httpSession;

    //登录验证
    //仅支持POST方式
    //登录成功id=0
    //登录失败id=1
    @RequestMapping(method = RequestMethod.POST,path = "/backend/login_verify")
    public Object LoginVerify(@RequestParam(name = "email") String email,@RequestParam(name="password") String password){
        ReturnMessage returnMessage = new ReturnMessage();
        //判断是否有此用户
        //获取数据库信息
        List<Manager> managers = managerDao.findTop1ByEmail(email);

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(managers.isEmpty()){
            returnMessage.id = 1;
            returnMessage.message = "登录失败,email不存在。";
            //顺便把session失效
            httpSession.invalidate();
        }else if(passwordEncoder.matches(password,managers.get(0).getPassword())){
            //登录成功
            returnMessage.id = 0;
            Manager manager = managers.get(0);

            //保存登录记录
            Date thisTime = new Date(System.currentTimeMillis());
            String thisToken = RandomCharUtil.getRandomUpperLetterChar(16);
            LoginRecord loginRecord = new LoginRecord(manager.getNo(),manager.getWorkrole(), thisTime,thisToken);
            loginRecordDao.save(loginRecord);

            //设置session
            httpSession.setAttribute("visit_time", thisTime.getTime());
            httpSession.setAttribute("visit_token", thisToken);
            httpSession.setAttribute("visit_user_name", manager.getName());
            httpSession.setAttribute("visit_user_id", manager.getNo());
            httpSession.setAttribute("visit_user_role", manager.getWorkrole());
            httpSession.setMaxInactiveInterval(1200);//20分钟不活动则会话失效

            SessionUser sessionUser = new SessionUser((long)httpSession.getAttribute("visit_time"),(String)httpSession.getAttribute("visit_token"),(String)httpSession.getAttribute("visit_user_name"),(String)httpSession.getAttribute("visit_user_role"),(int)httpSession.getAttribute("visit_user_id"));
            returnMessage.message = sessionUser;
        }else{
            returnMessage.id = 1;
            returnMessage.message = "登录失败,密码错误。";
        }
        return returnMessage;
    }

    //注册验证
    //仅支持POST方式
    //登注册成功id=0
    //自动设置session
    //登录失败id=1
    @RequestMapping(method = RequestMethod.POST,path = "/backend/register_verify")
    public Object RegisterVerify(@RequestParam(name = "username") String username,@RequestParam(name="password") String password,@RequestParam(name="email") String email,@RequestParam(name="role") String role){
        ReturnMessage returnMessage = new ReturnMessage();
        //判断是否有此用户
        //获取数据库信息
        List<Manager> managers = managerDao.findByNameOrEmail(username,email);
        if(managers.isEmpty()){
            //如果数据库没有数据
            returnMessage.id = 0;
            //插入数据库
            //加密密码
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            Manager manager = new Manager(username,role,passwordEncoder.encode(password),email,RandomCharUtil.getRandomUpperLetterChar(16));
            managerDao.save(manager);

            //保存登录记录
            Date thisTime = new Date(System.currentTimeMillis());
            String thisToken = RandomCharUtil.getRandomUpperLetterChar(16);
            LoginRecord loginRecord = new LoginRecord(manager.getNo(),manager.getWorkrole(), thisTime,thisToken);
            loginRecordDao.save(loginRecord);

            //设置session
            httpSession.setAttribute("visit_time", thisTime.getTime());
            httpSession.setAttribute("visit_token", thisToken);
            httpSession.setAttribute("visit_user_name", username);
            httpSession.setAttribute("visit_user_id", manager.getNo());
            httpSession.setAttribute("visit_user_role",manager.getWorkrole());
            httpSession.setMaxInactiveInterval(1200);//20分钟不活动则会话失效
            SessionUser sessionUser = new SessionUser((long)httpSession.getAttribute("visit_time"),(String)httpSession.getAttribute("visit_token"),(String)httpSession.getAttribute("visit_user_name"),(String)httpSession.getAttribute("visit_user_role"),(int)httpSession.getAttribute("visit_user_id"));
            returnMessage.message = sessionUser;
        }else{
            returnMessage.id = 1;
            returnMessage.message = "注册失败,用户名或邮箱已存在。";
            //顺便把session失效
            httpSession.invalidate();
        }
        return returnMessage;
    }

    @RequestMapping("/backend/logout")
    public Object logOut(){
        ReturnMessage returnMessage = new ReturnMessage();
        //设置session
        httpSession.invalidate();
        returnMessage.id = 0;
        returnMessage.message = "登出成功";
        return returnMessage;
    }

    @RequestMapping("/testpost")
    public Object testPost(
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
            String Repairstatus
    ){
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
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.id = 1;
        returnMessage.message = repairList;
        return returnMessage;
    }

    @RequestMapping("/getsession")
    public Object getSession(){
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.message = loginRecordDao.findTop2ByNoOrderByNoDesc((int)httpSession.getAttribute("visit_user_id"));
        return returnMessage;
    }

    @RequestMapping("/getall")
    public Object getAll(
            double crepaircost,
            String cmaterialcost,
            String cpromise,
            String cattention,
            Date cdate){
        /*Date date = new Date(Long.parseLong(cdate));*/

        ReturnMessage returnMessage = new ReturnMessage();

        returnMessage.id = 0;
        return returnMessage;
    }

    @RequestMapping("/encode")
    public Object encode(){

        //加密密码
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Iterable<Manager> managers = managerDao.findAll();
        for(Manager manager:managers){
            manager.setPassword(passwordEncoder.encode(manager.getPassword()));
            managerDao.save(manager);
        }
        return 1;
    }

}
