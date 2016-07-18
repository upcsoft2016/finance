package cn.net.wangchenyu.finance.dao;

import cn.net.wangchenyu.finance.model.Components;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JunFeng on 2016/7/16.
 */
public interface ComponentsDao extends CrudRepository<Components,Integer> {
    List<Components> findByName(String name);

}