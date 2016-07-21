package cn.net.wangchenyu.finance.controller;

import cn.net.wangchenyu.finance.dao.ManagerDao;
import cn.net.wangchenyu.finance.model.Manager;
import cn.net.wangchenyu.finance.model.ReturnMessage;
import cn.net.wangchenyu.finance.session.SessionUser;
import cn.net.wangchenyu.finance.util.RandomCharUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.List;

import static javax.swing.text.html.FormSubmitEvent.MethodType.POST;

/**
 * Created by cheneyveron on 7/18/16.
 */
@RestController
public class LoginController {

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
        List<Manager> managers = managerDao.findTop1ByEmailAndPassword(email,password);
        if(managers.isEmpty()){
            returnMessage.id = 1;
            returnMessage.message = "登录失败,请检查您的email或密码。";
            //顺便把session失效
            httpSession.invalidate();
        }else{
            returnMessage.id = 0;
            Manager manager = managers.get(0);

            //设置session
            httpSession.setAttribute("visit_time", System.currentTimeMillis());
            httpSession.setAttribute("visit_token", RandomCharUtil.getRandomUpperLetterChar(16));
            httpSession.setAttribute("visit_user_name", manager.getName());
            httpSession.setAttribute("visit_user_id", manager.getNo());
            httpSession.setAttribute("visit_user_role", manager.getWorkrole());
            httpSession.setMaxInactiveInterval(1200);//20分钟不活动则会话失效

            SessionUser sessionUser = new SessionUser((long)httpSession.getAttribute("visit_time"),(String)httpSession.getAttribute("visit_token"),(String)httpSession.getAttribute("visit_user_name"),(String)httpSession.getAttribute("visit_user_role"),(int)httpSession.getAttribute("visit_user_id"));
            returnMessage.message = sessionUser;
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
            Manager manager = new Manager(username,role,password,email,RandomCharUtil.getRandomUpperLetterChar(16));
            managerDao.save(manager);
            //设置session
            httpSession.setAttribute("visit_time", System.currentTimeMillis());
            httpSession.setAttribute("visit_token", RandomCharUtil.getRandomUpperLetterChar(16));
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

    @RequestMapping("/testpost")
    public Object testPost(String id){
        return id;
    }

    @RequestMapping("/getsession")
    public Object getSession(){
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.message = (String) httpSession.getAttribute("visit_user_role");
        return returnMessage;
    }

}
