package cn.net.wangchenyu.finance.dao;

import cn.net.wangchenyu.finance.model.RepairRecord;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by cheneyveron on 7/18/16.
 */
public interface RepairRecordDao extends CrudRepository<RepairRecord,Integer> {
    int countByRepairstatus(String repairstatus);
    List<RepairRecord> findTop20ByRepairstatus(String repairstatus);
    List<RepairRecord> findByRepairpersonnel(int repairpersonnel);
    List<RepairRecord> findByRepairstatus(String repairstatus);
}
