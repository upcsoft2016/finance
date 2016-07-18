package cn.net.wangchenyu.finance.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cheneyveron on 7/18/16.
 */
@Entity
@Table(name = "fx_ClosingCost")
public class ClosingCost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 11)
    private int jid;
    @Column(length = 11)
    private int cnumber;
    private double crepaircost;
    private double cmaterialcost;
    private String cpromise;
    private String cattention;
    private Date cdate;

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public int getCnumber() {
        return cnumber;
    }

    public void setCnumber(int cnumber) {
        this.cnumber = cnumber;
    }

    public double getCrepaircost() {
        return crepaircost;
    }

    public void setCrepaircost(double crepaircost) {
        this.crepaircost = crepaircost;
    }

    public double getCmaterialcost() {
        return cmaterialcost;
    }

    public void setCmaterialcost(double cmaterialcost) {
        this.cmaterialcost = cmaterialcost;
    }

    public String getCpromise() {
        return cpromise;
    }

    public void setCpromise(String cpromise) {
        this.cpromise = cpromise;
    }

    public String getCattention() {
        return cattention;
    }

    public void setCattention(String cattention) {
        this.cattention = cattention;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }
}
