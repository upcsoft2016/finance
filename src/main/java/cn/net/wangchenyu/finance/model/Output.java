package cn.net.wangchenyu.finance.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by JunFeng on 2016/7/16.
 */
@Entity
@Table(name="fx_Output")
public class Output {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   public int Uid;

   public String name;
   public String Qid;
   public int number;
   public int amount;
   public int repairpersonnel;
public  Output(){};
    public Output(String name, String qid, int number, int amount, int repairpersonnel) {
        this.name = name;
        Qid = qid;
        this.number = number;
        this.amount = amount;
        this.repairpersonnel = repairpersonnel;
    }


    public int getRepairpersonnel() {
        return repairpersonnel;
    }

    public void setRepairpersonnel(int repairpersonnel) {
        this.repairpersonnel = repairpersonnel;
    }
 

    public int getUid() {
        return Uid;
    }

    public void setUid(int uid) {
        Uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQid() {
        return Qid;
    }

    public void setQid(String qid) {
        Qid = qid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}


