package cn.net.wangchenyu.test2.model;

import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by JunFeng on 2016/7/17.
 */
@Entity
@Table(name="fx_statement")
public class Statement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int Uid;

    private String name;
    private String Qid;
    private int number;
    private Date date;
    private double price;
    private int amount;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
