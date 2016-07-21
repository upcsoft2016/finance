
package cn.net.wangchenyu.finance.dao;

import cn.net.wangchenyu.finance.model.Statement;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by JunFeng on 2016/7/17.
 */
public interface StatementDao extends CrudRepository<Statement,Integer> {
    List<Statement> findByNumber(int number);
}