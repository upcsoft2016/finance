package cn.net.wangchenyu.finance.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by cheneyveron on 7/18/16.
 */
@Entity
@Table(name = "fx_loginRecord")
public class LoginRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int loginid;

    private int no;
    private String role;
    private Date time;
    private String token;

    public void setLoginid(int loginid) {
        this.loginid = loginid;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getLoginid() {

        return loginid;
    }

    public int getNo() {
        return no;
    }

    public String getRole() {
        return role;
    }

    public Date getTime() {
        return time;
    }

    public String getToken() {
        return token;
    }
}
