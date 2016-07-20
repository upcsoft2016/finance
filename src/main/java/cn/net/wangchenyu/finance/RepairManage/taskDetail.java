package cn.net.wangchenyu.finance.RepairManage;

/**
 * Created by cheneyveron on 7/20/16.
 */
public class taskDetail{
    public int repairnumber;
    public int personnel;
    public String inspectionrecord;
    public String repairrecord;
    public String repairinspection;
    public String workload;
    public String repairdevice;
    public String repairstatus;
    public taskDetail(int repairnumber, int personnel, String inspectionrecord, String repairrecord, String repairinspection, String workload, String repairdevice, String repairstatus) {
        this.repairnumber = repairnumber;
        this.personnel = personnel;
        this.inspectionrecord = inspectionrecord;
        this.repairrecord = repairrecord;
        this.repairinspection = repairinspection;
        this.workload = workload;
        this.repairdevice = repairdevice;
        this.repairstatus = repairstatus;
    }
}