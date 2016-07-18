package cn.net.wangchenyu.finance.model;

import javax.persistence.*;

/**
 * Created by cheneyveron on 7/18/16.
 */
@Entity
@Table(name = "fx_repairStatus")
public class RepairStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String status;

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {

        return id;
    }

    public String getStatus() {
        return status;
    }
}
