package cn.net.wangchenyu.finance.CustomManage;

import cn.net.wangchenyu.finance.dao.UserDao;
import cn.net.wangchenyu.finance.model.ReturnMessage;
import cn.net.wangchenyu.finance.model.User;
import cn.net.wangchenyu.finance.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by cheneyveron on 7/19/16.
 */
@RestController
public class CustomManageController {

    @Autowired
    private AuthService authService;
    @Autowired
    private HttpSession httpSession;
    @Autowired
    private UserDao userDao;

    //找回密码
    @RequestMapping("/backend/user/revert")
    public Object Revert(String name, String email) {
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();

        //这里是业务逻辑
        returnMessage.id = 0;
        returnMessage.message = "已经发送验证邮件!";


        //返回
        return returnMessage;
    }

    //重置密码
    @RequestMapping("/backend/user/revertToken")
    public Object RevertToken(String token, String pass) {
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();

        //这里是业务逻辑
        returnMessage.id = 0;
        returnMessage.message = "重置成功!";


        //返回
        return returnMessage;
    }

    //获取用户姓名
    @RequestMapping("/add")
    public Object getUser() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String shownDate = formatter.format(date);
        User user=new User(7,"370305199511065048",date,"家庭用户","中国石油大学","86996283","17854227895","山东省淄博市路鑫家","123456","路鑫","2087523121@qq.com");
        return userDao.save(user);
    }


    //获取所有信息
    @RequestMapping("/backend/custommanage/getinfo")
    public Object RevertToken() {
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
        if (!authService.isAuthenticated()) {
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        }
        //这里是业务逻辑
        //返回的数据
        Date date = new Date(System.currentTimeMillis());
        //创建一个List存放users
        Iterable<User> users=userDao.findAll();
        //计算今天的客户数量
        int i=0;
        for(User user:users){
            if(date.getDay()==user.getTime().getDay()) i++;
        }//showDate还不可以

        //直接把message指向users
        returnMessage.message = users;
        returnMessage.todayuser=i;

        //返回
        return returnMessage;
    }

    //添加 修改 客户信息
    @RequestMapping("/backend/custommanage/add")
    public Object add(User user) {
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
        if (!authService.isAuthenticated()) {
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        };

        //这里是业务逻辑
        //处理接受的数据
        String role = (String)httpSession.getAttribute("visit_user_role");
        if(role!=null && role.equals("客服")) {
            userDao.save(user);
            returnMessage.id=0;
            returnMessage.message="操作成功!";
        }else{
            returnMessage.id = 1;
            returnMessage.message = "系统检测到非法行为,我已经报警了。慌不慌?";
        }

        //返回
        return returnMessage;
    }

    //删除客户信息
    @RequestMapping("/backend/custommanage/delete")
    public Object delete(int no){
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
        if (!authService.isAuthenticated()) {
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        };

        //这里是业务逻辑
        //处理接受的数据
        String role = (String)httpSession.getAttribute("visit_user_role");
        if(role!=null && role.equals("客服")) {
            userDao.delete(no);
            returnMessage.id = 0;
            returnMessage.message = "删除成功";
        }else{
            returnMessage.id=1;
            returnMessage.message="删除失败";
        }

        return returnMessage;

    }


}


