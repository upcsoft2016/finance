package cn.net.wangchenyu.finance.dao;

import cn.net.wangchenyu.finance.model.Manager;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by luxin on 2016/7/15.
 */
public interface ManagerDao extends CrudRepository<Manager,Integer> {

    List<Manager> findByNo(String no);
    List<Manager> findByName(String name);
    List<Manager> findTop1ByEmailAndPassword(String name,String password);
    List<Manager> findTop1ByName(String name);
    List<Manager> findByNameOrEmail(String name,String email);
}
