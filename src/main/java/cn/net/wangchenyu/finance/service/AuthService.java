package cn.net.wangchenyu.finance.service;

import cn.net.wangchenyu.finance.dao.LoginRecordDao;
import cn.net.wangchenyu.finance.dao.ManagerDao;
import cn.net.wangchenyu.finance.model.LoginRecord;
import cn.net.wangchenyu.finance.model.Manager;
import cn.net.wangchenyu.finance.session.SessionUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * Created by cheneyveron on 7/18/16.
 * 认证服务
 *
 * isAuthenticated
 * ->传入:HttpServletResponse response
 *
 * ->返回
 * -已登录 && 未过期->true
 * -未登录 -> false
 * -已过期 -> false
 *
 * currentUser
 * -当前session用户
 * -可能登录已过期
 * -为查到则返回null
 *
 *
 * 调试期:isAuthenticated返回总是1
 */
@Service
public class AuthService {

    @Autowired
    private LoginRecordDao loginRecordDao;
    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private HttpSession httpSession;

    public boolean isAuthenticated(){
        if(httpSession.getAttribute("visit_user_id")==null){
            return false;
        }//如果没有session信息,直接重定向到login
        else {//有id信息,查数据库对应的token相符
            List<LoginRecord> loginRecordList = loginRecordDao.findByNoAndToken((int)httpSession.getAttribute("visit_user_id"),(String)httpSession.getAttribute("visit_token"));
            if(loginRecordList.isEmpty())//如果不存在此id,清除session
            {
                httpSession.invalidate();
            }else{
                return true;
            }
        }
        return false;
    }

    public SessionUser currentUser(){
        SessionUser sessionUser = null;
        //如果已有visit_user_id就返回SessionUser对象
        if(httpSession.getAttribute("visit_user_id")!=null){
            sessionUser = new SessionUser((int)httpSession.getAttribute("visit_time"),
                    (String)httpSession.getAttribute("visit_token"),
                    (String)httpSession.getAttribute("visit_user_name"),
                    (String)httpSession.getAttribute("visit_user_role"),
                    (int)httpSession.getAttribute("visit_user_id")
                    );//创建新session对象
        }
        return sessionUser;
    }
}
