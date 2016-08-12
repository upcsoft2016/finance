package cn.net.wangchenyu.finance.dao;

import cn.net.wangchenyu.finance.model.ClosingCost;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by cheneyveron on 7/18/16.
 */
public interface ClosingCostDao extends CrudRepository<ClosingCost,Integer> {
    int countByCnumber(int cnumber);
}
