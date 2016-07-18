package cn.net.wangchenyu.finance.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cheneyveron on 7/18/16.
 */
@Entity
@Table(name = "Testtime")
public class TestTime {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date time;

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getId() {

        return id;
    }

    public Date getTime() {
        return time;
    }
}
