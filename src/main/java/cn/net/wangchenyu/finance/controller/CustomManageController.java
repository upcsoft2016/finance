package cn.net.wangchenyu.finance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cheneyveron on 7/19/16.
 */
@RestController
public class CustomManageController {
    @RequestMapping("/custom")
    public Object Custom(HttpServletResponse response) throws IOException {
        response.sendRedirect("/login");
        return "";
    }
}
