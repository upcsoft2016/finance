package lists;


        import javax.persistence.*;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by lenovo on 2016/7/17.
 */
@Entity
@Table(name="fx_closingcost")
public class ClosingCost {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int jid;           /* 结算ID*/
    private int cnumber;       /* 维修编号*/
    private double crepaircost;  /*维修费用*/
    private double cmaterialcost; /*材料费用*/
    private String cpromise;      /* 维修承诺*/
    private String cattention;   /*注意事项*/
    private Date cdate;        /*结算日期*/

    public int getJid() {
        return jid;
    }

    public int getCnumber() {
        return cnumber;
    }


    public String getCpromise() {
        return cpromise;
    }

    public String getCattention() {
        return cattention;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public void setCnumber(int cnumber) {
        this.cnumber = cnumber;
    }


    public void setCpromise(String cpromise) {
        this.cpromise = cpromise;
    }

    public void setCattention(String cattention) {
        this.cattention = cattention;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }
}
