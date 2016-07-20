package cn.net.wangchenyu.finance.model;

import javax.persistence.*;

/**
 * Created by luxin on 2016/7/15.
 */
@Entity
@Table(name="fx_Manager")
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int no;
    private String name;
    private String workrole;
    private String password;
    private String phone;
    private String email;
    private String salt;

    public Manager(){}

    public Manager(String name,String workrole,String password,String email,String salt){
        this.workrole=workrole;
        this.password=password;
        this.email=email;
        this.salt=salt;
    }

    public int getNo() {
        return no;
    }

    public String getName() {
        return name;
    }

    public String getWorkrole() {
        return workrole;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getSalt() {
        return salt;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWorkrole(String workrole) {
        this.workrole = workrole;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
