package cn.net.wangchenyu.finance.dao;

import cn.net.wangchenyu.finance.model.Output;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JunFeng on 2016/7/16.
 */
public interface OutputDao extends CrudRepository<Output,Integer> {
List<Output> findByName(String name);
}
