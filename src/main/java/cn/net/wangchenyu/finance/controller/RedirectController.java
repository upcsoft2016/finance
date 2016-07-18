package cn.net.wangchenyu.finance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by cheneyveron on 7/18/16.
 */
@Controller
public class RedirectController {

    @RequestMapping("/redirect")
    public static String RedirectToLogin(){
        return "redirect:/login";
    }
    public static String RedirectToLock(){
        return "redirect:/lock";
    }
}
