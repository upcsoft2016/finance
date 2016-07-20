package cn.net.wangchenyu.finance.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by JunFeng on 2016/7/16.
 */
@Entity
@Table(name="fx_Components")
public class Components {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int Uid;
    public String name;
    public String Qid;
    public int amount;
    public double price;
    public int wline;
    public String status;
    public Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getWline() {
        return wline;
    }

    public void setWline(int wline) {
        this.wline = wline;
    }

}

