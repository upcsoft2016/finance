package cn.net.wangchenyu.finance.dao;

import cn.net.wangchenyu.finance.model.LoginRecord;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by cheneyveron on 7/18/16.
 */
public interface LoginRecordDao extends CrudRepository<LoginRecord,Integer> {
    //查找no对应用户编号的最新登录记录
    List<LoginRecord> findTop2ByNoOrderByNoDesc(int no);
    List<LoginRecord> findByNoAndToken(int no,String token);
}
