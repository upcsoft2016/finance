package cn.net.wangchenyu.finance.CustomManage;

import cn.net.wangchenyu.finance.dao.UserDao;
import cn.net.wangchenyu.finance.model.ReturnMessage;
import cn.net.wangchenyu.finance.model.User;
import cn.net.wangchenyu.finance.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
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
        class CustomInfo {
            public int no;
            public String idno;
            //注意要用格式化以后的时间
            // 所以类型用String
            public String time;
            public String character;
            public String unit;
            public String fixedphone;
            public String mobilephone;
            public String address;
            public String postcode;
            public String name;
            public String email;

            //Alt+Insert快速创建构造函数
            public CustomInfo(int no, String idno, String time, String character, String unit, String fixedphone, String mobilephone, String address, String postcode, String name, String email) {
                this.no = no;
                this.idno = idno;
                this.time = time;
                this.character = character;
                this.unit = unit;
                this.fixedphone = fixedphone;
                this.mobilephone = mobilephone;
                this.address = address;
                this.postcode = postcode;
                this.name = name;
                this.email = email;
            }
        }

        //获取当前时间并规范化为yyyy-MM-hh格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String todayDate = formatter.format(date);

        //创建一个List存放customInfo
        List<CustomInfo> customInfo = new ArrayList() {};
        Iterable<User> users=userDao.findAll();
        int i=0;
        for(User user:users){
            String showDate=formatter.format(user.getTime());
            if(date.getDay()<=user.getTime().getDay()) i++;
            customInfo.add(new CustomInfo(user.getNo(),user.getIdno(),showDate,
                    user.getUsertype(),user.getWorkunit(),user.getTelephone(),user.getMobilephone(),user.getAddress(),user.getPostcode(),user.getName(),user.getEmail()));
        }//showDate还不可以


        //直接把message指向customInfo
        returnMessage.message = customInfo;
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
        }

        //这里是业务逻辑
        //处理接受的数据
        userDao.save(user);

        //获取当前时间并规范化为yyyy-MM-hh格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String shownDate = formatter.format(date);

        returnMessage.id=0;
        returnMessage.message="添加成功";
        //返回
        return returnMessage;
    }
}


