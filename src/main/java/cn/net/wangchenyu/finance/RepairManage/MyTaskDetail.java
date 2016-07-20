package cn.net.wangchenyu.finance.RepairManage;

/**
 * Created by cheneyveron on 7/20/16.
 */
public class MyTaskDetail {
    public int repairnumber;
    public String inspectionrecord;
    public String repairrecord;
    public String repairinspection;
    public String workload;
    public String repairdevice;
    public int repairstatus;
    public MyTaskDetail(int repairnumber, String inspectionrecord, String repairrecord, String repairinspection, String workload, String repairdevice, int repairstatus) {
        this.repairnumber = repairnumber;
        this.inspectionrecord = inspectionrecord;
        this.repairrecord = repairrecord;
        this.repairinspection = repairinspection;
        this.workload = workload;
        this.repairdevice = repairdevice;
        this.repairstatus = repairstatus;
    }
}