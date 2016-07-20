package cn.net.wangchenyu.finance.RepairManage;

/**
 * Created by cheneyveron on 7/20/16.
 */
public class RequiredPart {
    //维修编号
    public int Repairnumber;
    //备件名称
    public String Name;
    //备件型号
    public String Qid;
    //备件数量
    public int amount;

    public RequiredPart(int repairnumber, String name, String qid, int amount) {
        Repairnumber = repairnumber;
        Name = name;
        Qid = qid;
        this.amount = amount;
    }
}
