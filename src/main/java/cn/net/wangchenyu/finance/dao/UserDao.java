package com.vacation.java.user.daos;

import com.vacation.java.user.models.User;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
/**
 * Created by luxin on 2016/7/16.
 */
public interface UserDao extends CrudRepository <User,Integer>{
    List<User> findByNoOrName(String no, String name);
    List<User> deleteByNo(String no);
}
