package lists;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by lenovo on 2016/7/18.
 */
@Entity
@Table(name ="fx_repair_record")
public class RepairRecord {
    @Id
    private int id;     /*维修编号*/
    private String device; /*维修所用器件*/
    private String inspectionrecord;/*检测记录*/
    private String repairinspectiontime;/*维修检测时间*/
    private String repairpersonnel;/*维修人员*/
    private String repairrecord;/*维修记录*/
    private String status;/*维修状态*/
    private String workload;/*工作量*/

    public void setDevice(String device) {
        this.device = device;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setInspectionrecord(String inspectionrecord) {
        this.inspectionrecord = inspectionrecord;
    }

    public void setRepairinspectiontime(String repairinspectiontime) {
        this.repairinspectiontime = repairinspectiontime;
    }

    public void setRepairpersonnel(String repairpersonnel) {
        this.repairpersonnel = repairpersonnel;
    }

    public void setRepairrecord(String repairrecord) {
        this.repairrecord = repairrecord;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setWorkload(String workload) {
        this.workload = workload;
    }

    public String getDevice() {

        return device;
    }

    public int getId() {
        return id;
    }

    public String getInspectionrecord() {
        return inspectionrecord;
    }

    public String getRepairinspectiontime() {
        return repairinspectiontime;
    }

    public String getRepairpersonnel() {
        return repairpersonnel;
    }

    public String getRepairrecord() {
        return repairrecord;
    }

    public String getStatus() {
        return status;
    }

    public String getWorkload() {
        return workload;
    }
}
