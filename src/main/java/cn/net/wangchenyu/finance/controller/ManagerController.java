package cn.net.wangchenyu.finance.controller;

import cn.net.wangchenyu.finance.dao.ManagerDao;
import cn.net.wangchenyu.finance.model.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by luxin on 2016/7/18.
 */
public class ManagerController {
    @Autowired
    private ManagerDao managerDao;
    @RequestMapping("/creatmanager")
    public Object createManager(){
        Manager manager=new Manager(1,"","","","","","");
        return managerDao.save(manager);
    }
    @RequestMapping("/checkmanager")
    public void checkManager(String no,String name) {
        Manager manager = new Manager();
        if (managerDao.findByNo(no) == null || managerDao.findByName(name) == null) {
            System.out.println("注册成功");
            managerDao.save(manager);
        } else if (managerDao.findByNo(no) != null) {
            System.out.println("用户编号已存在，请重新输入");
            // checkManager(no,name);
        } else if (managerDao.findByName(name) != null) {
            System.out.println("用户名已存在，请重新输入");
            // checkManager(no,name);
        }
    }


}
