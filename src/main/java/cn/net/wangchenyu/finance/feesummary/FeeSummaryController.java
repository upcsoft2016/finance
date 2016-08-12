package cn.net.wangchenyu.finance.feesummary;

import cn.net.wangchenyu.finance.dao.*;
import cn.net.wangchenyu.finance.model.*;
import cn.net.wangchenyu.finance.service.AuthService;
import org.apache.tomcat.util.buf.UDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.xml.ParserContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.util.cldr.CLDRLocaleDataMetaInfo;

import javax.persistence.Column;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by cheneyveron on 7/20/16.
 */
@RestController
public class FeeSummaryController {
    @Autowired
    private RepairRecordDao repairRecordDao;
    @Autowired
    private ClosingCostDao closingCostDao;
    @Autowired
    private RepairListDao repairListDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private StatementDao statementDao;
    @Autowired
    private AuthService authService;
    @Autowired
    private HttpSession httpSession;

    //获取完成维修编号列表
    @RequestMapping("/backend/feesummary/getall")
    public Object getAll(){
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
        if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        };

        String role = (String)httpSession.getAttribute("visit_user_role");
        if(role!=null && role.equals("客服")) {

            List<RepairRecord> repairRecords = repairRecordDao.findByRepairstatus("维修完成");

            if(repairRecords.isEmpty()){
                returnMessage.id = 1;
                returnMessage.message = "当前没有可结算记录";
            }else {

                //保存维修完成未结算的单子
                List<RepairRecord> repairRecords1 = new ArrayList<RepairRecord>();

                for(RepairRecord repairRecord:repairRecords){
                    if(closingCostDao.countByCnumber(repairRecord.getRepairnumber())==0){
                        repairRecords1.add(repairRecord);
                    }
                }
                //格式化
                List<Integer> allCustomIds = new ArrayList<Integer>();
                for (RepairRecord repairRecord : repairRecords1) {
                    allCustomIds.add(repairRecord.getRepairnumber());
                }
                returnMessage.id = 0;
                returnMessage.message = allCustomIds;
            }
        }else{
            returnMessage.id = 1;
            returnMessage.message = "无权操作!";
        }
        return returnMessage;
    }

    //获取具体维修单子的信息
    @RequestMapping("/backend/feesummary/getdetail")
    public Object getDetail(int repairnumber){
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
        if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        };

        //所有备件
        class OutputDetail{
            //备件名
            public String name;
            //备件型号
            public String Qid;
            public int amount;
            //单价
            public double price;

            public OutputDetail() {
            }

            public OutputDetail(String name, String qid, int amount, double price) {
                this.name = name;
                Qid = qid;
                this.amount = amount;
                this.price = price;
            }
        }

        //返回的详情
        class RepairDetail{
            public int Maintenancenumber;
            public Date Repairtime;
            public String Producttype;
            public String IMVorDelta;//机器品牌
            public String Machinemodel;//机器型号
            public String Serialnumber;//系列号
            public String workunit;
            public String name;
            public String Machinefaultpheno;//机器故障现象
            public double materialfee = 0;//材料费
            public List<OutputDetail> outputDetails = new ArrayList<OutputDetail>(){};
        }

        String role = (String)httpSession.getAttribute("visit_user_role");
        if(role.equals("客服")) {
            RepairDetail repairDetail = new RepairDetail();
            //从RepairList读
            RepairList repairList = repairListDao.findOne(repairnumber);
            repairDetail.Maintenancenumber = repairList.Maintenancenumber;
            repairDetail.Machinefaultpheno = repairList.Machinefaultpheno;
            repairDetail.Repairtime = repairList.Repairtime;
            repairDetail.Producttype = repairList.Producttype;
            repairDetail.IMVorDelta = repairList.IMVorDelta;
            repairDetail.Machinemodel = repairList.Machinemodel;
            repairDetail.Serialnumber = repairList.Serialnumber;

            //从User读
            User user = userDao.findOne(repairList.CustomerID);
            repairDetail.name = user.getName();
            repairDetail.workunit = user.getWorkunit();

            //从Statement读
            List<Statement> statements = statementDao.findByNumber(repairnumber);
            for(int i=0;i<statements.size();i++){
                //计算材料费
                repairDetail.materialfee += statements.get(i).getPrice();
                //附加到outputDetails
                repairDetail.outputDetails.add(new OutputDetail(statements.get(i).getName(),statements.get(i).getQid(),statements.get(i).getAmount(),statements.get(i).getPrice()));
            }

            returnMessage.id=0;
            returnMessage.message = repairDetail;
        }else{
            returnMessage.id = 1;
            returnMessage.message = "无权操作!";
        }
        return returnMessage;
    }

    //提交
    @RequestMapping("/backend/feesummary/submit")
    public Object SubMit(
            int cnumber,
            double crepaircost,
            String cmaterialcost,
            String cpromise,
            String cattention,
            Date cdate){
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
        if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        };

        ClosingCost closingCost = new ClosingCost(
                cnumber,
                crepaircost,
                Double.parseDouble(cmaterialcost),
                cpromise,
                cattention,
                cdate);
        String role = (String)httpSession.getAttribute("visit_user_role");
        if(role.equals("客服")) {
            returnMessage.id=0;
            returnMessage.message="提交成功";
            closingCostDao.save(closingCost);
        }else{
            returnMessage.id = 1;
            returnMessage.message = "无权操作!";
        }
        return returnMessage;
    }


}
