package cn.net.wangchenyu.finance.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by luxin on 2016/7/16.
 */
@Entity
@Table(name="fx_User")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int no;

    private String idno;
    private Date time;
    private int usertype;
    private String workunit;
    private String telephone;
    private String mobilephone;
    private String address;
    private String postcode;
    private String name;
    private String email;

    public User(){}

    public User(int no,String idno,Date time,int usertype,String workunit,String telephone,String mobilephone,String address,String postcode,String name,String email){
        this.no=no;
        this.idno=idno;
        this.time= time;
        this.usertype=usertype;
        this.workunit=workunit;
        this.telephone=telephone;
        this.mobilephone=mobilephone;
        this.address=address;
        this.postcode=postcode;
        this.name=name;
        this.email=email;
    }

    public int getNo() {
        return no;
    }

    public String getIdno() {
        return idno;
    }

    public Date getTime() {
        return time;
    }

    public int getUsertype() {
        return usertype;
    }

    public String getWorkunit() {
        return workunit;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public String getAddress() {
        return address;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setIdno(String idno) {
        this.idno = idno;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public void setUsertype(int usertype) {
        this.usertype = usertype;
    }

    public void setWorkunit(String workunit) {
        this.workunit = workunit;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
