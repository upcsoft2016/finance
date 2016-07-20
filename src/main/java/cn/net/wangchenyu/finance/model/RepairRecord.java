package cn.net.wangchenyu.finance.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cheneyveron on 7/18/16.
 */
@Entity
@Table(name = "fx_RepairRecord")
public class RepairRecord {
    @Id
    @Column(length = 11)
    private int repairnumber;
    private String repairpersonnel;
    @Column(length = 1024)
    private String inspectionrecord;
    @Column(length = 1024)
    private String repairrecord;
    private Date repairinspection;
    private String workload;
    private String repairdevice;
    private int repairstatus;

    public void setRepairnumber(int repairnumber) {
        this.repairnumber = repairnumber;
    }

    public void setRepairpersonnel(String repairpersonnel) {
        this.repairpersonnel = repairpersonnel;
    }

    public void setInspectionrecord(String inspectionrecord) {
        this.inspectionrecord = inspectionrecord;
    }

    public void setRepairrecord(String repairrecord) {
        this.repairrecord = repairrecord;
    }

    public void setRepairinspection(Date repairinspection) {
        this.repairinspection = repairinspection;
    }

    public void setWorkload(String workload) {
        this.workload = workload;
    }

    public void setRepairdevice(String repairdevice) {
        this.repairdevice = repairdevice;
    }

    public void setRepairstatus(int repairstatus) {
        this.repairstatus = repairstatus;
    }

    public int getRepairnumber() {

        return repairnumber;
    }

    public String getRepairpersonnel() {
        return repairpersonnel;
    }

    public String getInspectionrecord() {
        return inspectionrecord;
    }

    public String getRepairrecord() {
        return repairrecord;
    }

    public Date getRepairinspection() {
        return repairinspection;
    }

    public String getWorkload() {
        return workload;
    }

    public String getRepairdevice() {
        return repairdevice;
    }

    public int getRepairstatus() {
        return repairstatus;
    }
}
