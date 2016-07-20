package cn.net.wangchenyu.finance.model;

import javax.persistence.*;

/**
 * Created by lenovo on 2016/7/17.
 */
@Entity
@Table(name = "fx_FaultType")
//故障类型
public class FaultType {
    @Id
    private int id;
    private String type;

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}