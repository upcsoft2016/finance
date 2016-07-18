package cn.net.wangchenyu.test2.dao;

import cn.net.wangchenyu.test2.model.Statement;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by JunFeng on 2016/7/17.
 */
public interface StatementDao extends CrudRepository<Statement,Integer> {
}
