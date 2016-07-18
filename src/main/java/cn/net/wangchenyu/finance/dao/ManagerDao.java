package com.vacation.java.user.daos;

import com.vacation.java.user.models.Manager;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by luxin on 2016/7/15.
 */
public interface ManagerDao extends CrudRepository<Manager,Integer> {

    List<Manager> findByNo(String no);
    List<Manager> findByName(String name);
}
