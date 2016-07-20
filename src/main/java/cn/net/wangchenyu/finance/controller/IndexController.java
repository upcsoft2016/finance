package cn.net.wangchenyu.finance.controller;

import cn.net.wangchenyu.finance.model.ReturnMessage;
import cn.net.wangchenyu.finance.service.AuthService;
import cn.net.wangchenyu.finance.util.RandomCharUtil;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * Created by cheneyveron on 7/18/16.
 */
@RestController
public class IndexController {

    @Autowired
    private AuthService authService;

    @RequestMapping("/")
    public Object index(HttpServletResponse response,int id) throws IOException {
        authService.isAuthenticated();
        response.sendRedirect("/456");
        return "123";
    }

    @RequestMapping("/getime")
    public Object getTime(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        return formatter.format(date);
    }

    @RequestMapping("/getname")
    public Object getName(){
        ReturnMessage returnMessage = new ReturnMessage();
        returnMessage.id = 0;
        returnMessage.message = "CCCD";
        return returnMessage;
    }
}