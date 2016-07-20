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
    private int Maintenancenumber;//维修编号

    @Column(length = 11)
    private int CustomerID;//客户编号

    private int Producttype;//产品类型
    private String IMVorDelta;//机器品牌
    private String Machinemodel;//机器型号
    private String Serialnumber;//系列号
    private String Lackparts;//缺少零件
    private String Machinefaultpheno;//机器故障现象
    private int Faulttype;//故障类型
    private String Appearanceinsp;//机器外观检查
    private String Bootpassword;//开机口令
    private String Importinformation;//重要资料
    private String HDD;//硬件
    private String Memory;//内存
    private String PCcard;//外置PC卡
    private String Acadapter;//ＡＣ适配器
    private String Battery;//电池
    private String Externaldrives;//外接光驱
    private String Floppydrive;//外接软驱
    private String Others;//其它
    private String Repairtime;//报修时间
    private float Estimateprice;//预估价格
    private int Repairstatus;//报修状态

    //各形参的setter和getter方法
    public RepairList() {
    }
    public void setMaintenancenumber(int maintenancenumber) {
        Maintenancenumber = maintenancenumber;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public void setProducttype(int producttype) {
        Producttype = producttype;
    }

    public void setIMVorDelta(String IMVorDelta) {
        this.IMVorDelta = IMVorDelta;
    }

    public void setMachinemodel(String machinemodel) {
        Machinemodel = machinemodel;
    }

    public void setSerialnumber(String serialnumber) {
        Serialnumber = serialnumber;
    }

    public void setLackparts(String lackparts) {
        Lackparts = lackparts;
    }

    public void setMachinefaultpheno(String machinefaultpheno) {
        Machinefaultpheno = machinefaultpheno;
    }

    public void setFaulttype(int faulttype) {
        Faulttype = faulttype;
    }

    public void setAppearanceinsp(String appearanceinsp) {
        Appearanceinsp = appearanceinsp;
    }

    public void setBootpassword(String bootpassword) {
        Bootpassword = bootpassword;
    }

    public void setImportinformation(String importinformation) {
        Importinformation = importinformation;
    }

    public void setHDD(String HDD) {
        this.HDD = HDD;
    }

    public void setMemory(String memory) {
        Memory = memory;
    }

    public void setPCcard(String PCcard) {
        this.PCcard = PCcard;
    }

    public void setAcadapter(String acadapter) {
        Acadapter = acadapter;
    }

    public void setBattery(String battery) {
        Battery = battery;
    }

    public void setExternaldrives(String externaldrives) {
        Externaldrives = externaldrives;
    }

    public void setFloppydrive(String floppydrive) {
        Floppydrive = floppydrive;
    }

    public void setOthers(String others) {
        Others = others;
    }

    public void setRepairtime(String repairtime) {
        Repairtime = repairtime;
    }

    public void setEstimateprice(float estimateprice) {
        Estimateprice = estimateprice;
    }

    public void setRepairstatus(int repairstatus) {
        Repairstatus = repairstatus;
    }

    public long getMaintenancenumber() {
        return Maintenancenumber;
    }

    public long getCustomerID() {
        return CustomerID;
    }

    public int getProducttype() {
        return Producttype;
    }

    public String getIMVorDelta() {
        return IMVorDelta;
    }

    public String getMachinemodel() {
        return Machinemodel;
    }

    public String getSerialnumber() {
        return Serialnumber;
    }

    public String getLackparts() {
        return Lackparts;
    }

    public String getMachinefaultpheno() {
        return Machinefaultpheno;
    }

    public String getHDD() {
        return HDD;
    }

    public String getMemory() {
        return Memory;
    }

    public String getPCcard() {
        return PCcard;
    }

    public String getAcadapter() {
        return Acadapter;
    }

    public String getBattery() {
        return Battery;
    }

    public String getExternaldrives() {
        return Externaldrives;
    }

    public String getFloppydrive() {
        return Floppydrive;
    }

    public String getOthers() {
        return Others;
    }

    public String getRepairtime() {
        return Repairtime;
    }

    public float getEstimateprice() {
        return Estimateprice;
    }

    public int getRepairstatus() {
        return Repairstatus;
    }

    public int getFaulttype() {

        return Faulttype;
    }

    public String getAppearanceinsp() {
        return Appearanceinsp;
    }

    public String getBootpassword() {
        return Bootpassword;
    }

    public RepairList(int maintenancenumber, int customerID, int producttype, String IMVorDelta, String machinemodel, String serialnumber, String lackparts, String machinefaultpheno, int faulttype, String appearanceinsp, String bootpassword, String importinformation, String HDD, String memory, String PCcard, String acadapter, String battery, String externaldrives, String floppydrive, String others, String repairtime, float estimateprice, int repairstatus) {
        Maintenancenumber = maintenancenumber;
        CustomerID = customerID;
        Producttype = producttype;
        this.IMVorDelta = IMVorDelta;
        Machinemodel = machinemodel;
        Serialnumber = serialnumber;
        Lackparts = lackparts;
        Machinefaultpheno = machinefaultpheno;
        Faulttype = faulttype;
        Appearanceinsp = appearanceinsp;
        Bootpassword = bootpassword;
        Importinformation = importinformation;
        this.HDD = HDD;
        Memory = memory;
        this.PCcard = PCcard;
        Acadapter = acadapter;
        Battery = battery;
        Externaldrives = externaldrives;
        Floppydrive = floppydrive;
        Others = others;
        Repairtime = repairtime;
        Estimateprice = estimateprice;
        Repairstatus = repairstatus;
    }

    public String getImportinformation() {
        return Importinformation;
    }

}