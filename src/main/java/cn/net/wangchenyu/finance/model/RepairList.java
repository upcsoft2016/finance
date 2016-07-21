package cn.net.wangchenyu.finance.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

/**
 * Created by cheneyveron on 7/7/16.
 */
@Entity
@Table(name = "fx_Repairlists")
//报修表
public class RepairList {
    @Id
    @Column(length = 11)
    public int Maintenancenumber;//维修编号

    @Column(length = 11)
    public int CustomerID;//客户编号

    public String Producttype;//产品类型
    public String IMVorDelta;//机器品牌
    public String Machinemodel;//机器型号
    public String Serialnumber;//系列号
    public String Lackparts;//缺少零件
    public String Machinefaultpheno;//机器故障现象
    public String Faulttype;//故障类型
    public String Appearanceinsp;//机器外观检查
    public String Bootpassword;//开机口令
    public String Importinformation;//重要资料
    public String HDD;//硬件
    public String Memory;//内存
    public String PCcard;//外置PC卡
    public String Acadapter;//ＡＣ适配器
    public String Battery;//电池
    public String Externaldrives;//外接光驱
    public String Floppydrive;//外接软驱
    public String Others;//其它
    public Date Repairtime;//报修时间
    public float Estimateprice;//预估价格
    public String Repairstatus;//报修状态
    //各形参的setter和getter方法
    public RepairList() {
    }
}