package com.vacation.java.user.controllers;

import com.vacation.java.user.daos.WorkRoleDao;
import com.vacation.java.user.models.WorkRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by luxin on 2016/7/18.
 */
public class WorkRoleController {
    @Autowired
    private WorkRoleDao workRoleDao;
    @RequestMapping("/workrole")
    public Object cworkRole(String workrole){
        WorkRole work=new WorkRole();
        work.setWorkrole("workrole");
        return workRoleDao.save(work);
    }
}
