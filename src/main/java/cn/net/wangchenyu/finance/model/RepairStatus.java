package com.repairlist.lists;

import javax.persistence.*;

/**
 * Created by lenovo on 2016/7/17.
 */
@Entity
@Table(name = "fx_Reportstatus")
//报修状态
public class RepairStatus {
    @Id
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
