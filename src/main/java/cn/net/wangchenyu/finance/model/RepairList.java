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

    public RepairList(int maintenancenumber, int customerID, String producttype, String IMVorDelta, String machinemodel, String serialnumber, String lackparts, String machinefaultpheno, String faulttype, String appearanceinsp, String bootpassword, String importinformation, String HDD, String memory, String PCcard, String acadapter, String battery, String externaldrives, String floppydrive, String others, Date repairtime, float estimateprice, String repairstatus) {
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

    public RepairList() {
    }

    public int getMaintenancenumber() {
        return Maintenancenumber;
    }

    public void setMaintenancenumber(int maintenancenumber) {
        Maintenancenumber = maintenancenumber;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getProducttype() {
        return Producttype;
    }

    public void setProducttype(String producttype) {
        Producttype = producttype;
    }

    public String getIMVorDelta() {
        return IMVorDelta;
    }

    public void setIMVorDelta(String IMVorDelta) {
        this.IMVorDelta = IMVorDelta;
    }

    public String getMachinemodel() {
        return Machinemodel;
    }

    public void setMachinemodel(String machinemodel) {
        Machinemodel = machinemodel;
    }

    public String getSerialnumber() {
        return Serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        Serialnumber = serialnumber;
    }

    public String getLackparts() {
        return Lackparts;
    }

    public void setLackparts(String lackparts) {
        Lackparts = lackparts;
    }

    public String getMachinefaultpheno() {
        return Machinefaultpheno;
    }

    public void setMachinefaultpheno(String machinefaultpheno) {
        Machinefaultpheno = machinefaultpheno;
    }

    public String getFaulttype() {
        return Faulttype;
    }

    public void setFaulttype(String faulttype) {
        Faulttype = faulttype;
    }

    public String getAppearanceinsp() {
        return Appearanceinsp;
    }

    public void setAppearanceinsp(String appearanceinsp) {
        Appearanceinsp = appearanceinsp;
    }

    public String getBootpassword() {
        return Bootpassword;
    }

    public void setBootpassword(String bootpassword) {
        Bootpassword = bootpassword;
    }

    public String getImportinformation() {
        return Importinformation;
    }

    public void setImportinformation(String importinformation) {
        Importinformation = importinformation;
    }

    public String getHDD() {
        return HDD;
    }

    public void setHDD(String HDD) {
        this.HDD = HDD;
    }

    public String getMemory() {
        return Memory;
    }

    public void setMemory(String memory) {
        Memory = memory;
    }

    public String getPCcard() {
        return PCcard;
    }

    public void setPCcard(String PCcard) {
        this.PCcard = PCcard;
    }

    public String getAcadapter() {
        return Acadapter;
    }

    public void setAcadapter(String acadapter) {
        Acadapter = acadapter;
    }

    public String getBattery() {
        return Battery;
    }

    public void setBattery(String battery) {
        Battery = battery;
    }

    public String getExternaldrives() {
        return Externaldrives;
    }

    public void setExternaldrives(String externaldrives) {
        Externaldrives = externaldrives;
    }

    public String getFloppydrive() {
        return Floppydrive;
    }

    public void setFloppydrive(String floppydrive) {
        Floppydrive = floppydrive;
    }

    public String getOthers() {
        return Others;
    }

    public void setOthers(String others) {
        Others = others;
    }

    public Date getRepairtime() {
        return Repairtime;
    }

    public void setRepairtime(Date repairtime) {
        Repairtime = repairtime;
    }

    public float getEstimateprice() {
        return Estimateprice;
    }

    public void setEstimateprice(float estimateprice) {
        Estimateprice = estimateprice;
    }

    public String getRepairstatus() {
        return Repairstatus;
    }

    public void setRepairstatus(String repairstatus) {
        Repairstatus = repairstatus;
    }
}