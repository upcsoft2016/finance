package cn.net.wangchenyu.finance.CustomManage;

import cn.net.wangchenyu.finance.model.User;
import cn.net.wangchenyu.finance.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by cheneyveron on 7/19/16.
 */
@RestController
public class CustomManageController {

    @Autowired
    private AuthService authService;

    //找回密码
    @RequestMapping("/backend/user/revert")
    public Object Revert(String name,String email) {
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
    public Object RevertToken(String token,String pass) {
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();

        //这里是业务逻辑
        returnMessage.id = 0;
        returnMessage.message = "重置成功!";


        //返回
        return returnMessage;
    }



    //获取所有信息
    @RequestMapping("/backend/custommanage/getinfo")
    public Object RevertToken() {
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
        if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        };


        //这里是业务逻辑
        //返回的数据
        class CustomInfo{
            public int no;
            public String idno;
            //注意要用格式化以后的时间
            // 所以类型用String
            public String time;
            public int character;
            public String unit;
            public String fixedphone;
            public String mobilephone;
            public String address;
            public String postcode;
            public String name;
            public String email;

            //Alt+Insert快速创建构造函数
            public CustomInfo(int no, String idno, String time, int character, String unit, String fixedphone, String mobilephone, String address, String postcode, String name, String email) {
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
        //创建一个List存放customInfo
        List<CustomInfo> customInfo = new ArrayList(){};


        //获取当前时间并规范化为yyyy-MM-hh格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-hh");
        Date date = new Date(System.currentTimeMillis());
        String shownDate = formatter.format(date);

        //为当前List添加两条数据
        customInfo.add(new CustomInfo(0000001,"3266564554215525421",shownDate,0,"中国石油大学","025152586542","135625312585","银河系太阳系地球村","65234","小王","cheneyveron@live.cn"));
        customInfo.add(new CustomInfo(0000002,"3266564554215525422",shownDate,0,"中国石油大学","025152586542","135625312585","银河系太阳系地球村","65234","小王","cheneyveron@live.cn"));

        returnMessage.id = 0;
        //直接把message指向customInfo
        returnMessage.message = customInfo;


        //返回
        return returnMessage;
    }

    //添加 修改 客户信息
    @RequestMapping("/backend/custommanage/add")
    public Object add(User user) {
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
        if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        };


        //这里是业务逻辑
        //处理接受的数据

        //获取当前时间并规范化为yyyy-MM-hh格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-hh");
        Date date = new Date();
        String shownDate = formatter.format(date);

        //返回
        return returnMessage;
    }

}
