package cn.net.wangchenyu.finance.partmanage;

import cn.net.wangchenyu.finance.dao.ComponentsDao;
import cn.net.wangchenyu.finance.dao.OutputDao;
import cn.net.wangchenyu.finance.dao.StatementDao;
import cn.net.wangchenyu.finance.model.Components;
import cn.net.wangchenyu.finance.model.Output;
import cn.net.wangchenyu.finance.model.ReturnMessage;
import cn.net.wangchenyu.finance.model.Statement;
import cn.net.wangchenyu.finance.service.AuthService;
import com.sun.corba.se.spi.orbutil.fsm.Input;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by JunFeng on 2016/7/19.
 */
@RestController
public class PartmanageController {
    @Autowired
    private AuthService authService;
    @Autowired
    private ComponentsDao componentsDao;
    @Autowired
    private StatementDao statementDao;
    @Autowired
    private OutputDao outputDao;
    //获取全部数据
    @RequestMapping("/backend/partmanage/getinfo_1")
    public Object getinfo_1(){
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
       /* if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        };*/
        class Partinfo{
            public String name;
            public String Qid;
            public double price;
            public int amount;
            public int wline;
            public String status;
            public String time;

            public Partinfo(String name, String qid, double price, int amount, int wline, String status, String time) {
                this.name = name;
                Qid = qid;
                this.price = price;
                this.amount = amount;
                this.wline = wline;
                this.status = status;
                this.time = time;
            }
        }
        List<Partinfo> partinfos=new ArrayList(){};
        //获取当前时间并规范化为yyyy-MM-hh格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-hh");
        Date date = new Date(System.currentTimeMillis());
        String showDate = formatter.format(date);
//
        Iterable<Components> componentses = componentsDao.findAll();
        for (Components componentse:componentses)
        {
            if(componentse.getDate()!=null)
            {
                showDate = formatter.format(componentse.getDate());
            }else{
                showDate = "0000-00-00";
            }
            if(componentse.getName().equals("junfeng")){
                partinfos.add(new Partinfo("JunFeng",componentse.getQid(),componentse.getPrice(),componentse.getAmount(),componentse.getWline(),componentse.getStatus(),showDate));
            }else{
                partinfos.add(new Partinfo(componentse.getName(),componentse.getQid(),componentse.getPrice(),componentse.getAmount(),componentse.getWline(),componentse.getStatus(),showDate));
            }
        }
        returnMessage.id = 0;
        //直接把message指向customInfo
        returnMessage.message = partinfos;
        //返回
        return returnMessage;
    }

    //显示流水表
    @RequestMapping("/backend/partmanage/getinfo_2")
    public Object getinfo_2(){
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
       /* if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        };*/
        class Partinfo{
            public String name;
            public String Qid;
            public int number;
            public String status;
            public int amount;
            public double price;
            public String time;

            public Partinfo(String name, String qid, int number, String status, int amount,  double price,String time) {
                this.name = name;
                Qid = qid;
                this.number = number;
                this.status = status;
                this.amount = amount;
                this.price = price;
                this.time = time;

            }
        }
        List<Partinfo> partinfos=new ArrayList(){};
        //获取当前时间并规范化为yyyy-MM-hh格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-hh");
        Date date = new Date(System.currentTimeMillis());
        String showDate = formatter.format(date);
//
        Iterable<Statement> statements =statementDao.findAll();
        for (Statement statement:statements)
        {
            if(statement.getDate()!=null)
            {
                showDate = formatter.format(statement.getDate());
            }else{
                showDate = "0000-00-00";
            }
            if(statement.getName().equals("junfeng")){
                partinfos.add(new Partinfo("JunFeng",statement.getQid(),statement.getNumber(),statement.getStatus(),statement.getAmount(),statement.getPrice(),showDate));
            }else{
                partinfos.add(new Partinfo(statement.getName(),statement.getQid(),statement.getNumber(),statement.getStatus(),statement.getAmount(),statement.getPrice(),showDate));
            }
        }
        returnMessage.id = 0;
        //直接把message指向customInfo
        returnMessage.message = partinfos;
        //返回
        return returnMessage;
    }

    //显示出库单
    @RequestMapping("/backend/partmanage/getinfo_3")
    public Object getinfo_3(){
        //定义returnMessage
        ReturnMessage returnMessage = new ReturnMessage();
        //是否是已验证用户
       /* if(!authService.isAuthenticated()){
            returnMessage.id = 1;
            returnMessage.message = "请先登录!";
            return returnMessage;
        };*/
        class Partinfo{
            public String name;
            public String Qid;
            public int number;
            public int amount;

            public Partinfo(String name, String qid, int number, int amount) {
                this.name = name;
                Qid = qid;
                this.number = number;
                this.amount = amount;
            }
        }
        List<Partinfo> partinfos=new ArrayList(){};
        //获取当前时间并规范化为yyyy-MM-hh格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-hh");
        Date date = new Date(System.currentTimeMillis());
        String showDate = formatter.format(date);
//
        Iterable<Output> outputs =outputDao.findAll();
        for (Output output:outputs)
        {

            if(output.getName().equals("junfeng")){
                partinfos.add(new Partinfo("JunFeng",output.getQid(),output.getNumber(),output.getAmount()));
            }else{
                partinfos.add(new Partinfo(output.getName(),output.getQid(),output.getNumber(),output.getAmount()));
            }
        }
        returnMessage.id = 0;
        //直接把message指向customInfo
        returnMessage.message = partinfos;
        //返回
        return returnMessage;
    }


    //入库。
    @RequestMapping("/backend/partmanage/instore")
    public Object instore(Components components){
        ReturnMessage returnMessage=new ReturnMessage();
        returnMessage.id=0;
        returnMessage.message="入库成功";
        //将信息插入仓库
        String a=new String("未知");
        Date date = new Date(System.currentTimeMillis());
        if(componentsDao.findByName(components.name).isEmpty())
        {
            if (components.getAmount() > components.getWline()) {
                a = "正常";
            } else if (components.getAmount() == components.getWline()) {
                a = "临界";
            } else if (components.getAmount() == 0) {
                a = "缺货";
            } else {
                a = "警戒";
            }
            Components components1 = new Components(components.name, components.Qid, components.price, components.amount, components.wline, a, date);
            componentsDao.save(components1);

        }else {

            int b=componentsDao.findByName(components.name).get(0).getAmount();
            componentsDao.findByName(components.name).get(0).setAmount(b+components.amount);
            if (componentsDao.findByName(components.name).get(0).amount> components.getWline()) {
                a = "正常";
            } else if (componentsDao.findByName(components.name).get(0).amount == components.getWline()) {
                a = "临界";
            } else if (components.getAmount() == 0) {
                a = "缺货";
            } else {
                a = "警戒";
            }
            componentsDao.findByName(components.name).get(0).setStatus(a);
        }
        //将入库信息插入流水表
                Statement statement=new Statement(components.name,components.Qid,0,date,components.price,components.amount,"入库");
        statementDao.save(statement);
        return  returnMessage;
            }
    //出库
    @RequestMapping("/backend/partmanage/outstore")
    public Object output() {
        ReturnMessage returnMessage = new ReturnMessage();
        Date date = new Date(System.currentTimeMillis());
        //先将出库单提取出来
        Iterable<Output> output1 = outputDao.findAll();
        for (Output output : output1) {
            //减少库存
            if (componentsDao.findByName(output.getName()).isEmpty()) {

                returnMessage.message = "出库失败";
                } else
            {
                if(componentsDao.findByName(output.getName()).get(0).amount>=output.amount) {
                int b = componentsDao.findByName((output.getName())).get(0).amount;
                componentsDao.findByName(output.getName()).get(0).setAmount(b - output.amount);
                    returnMessage.message="出库成功";
                    //入库信息写入流水表
                    double price = componentsDao.findByName(output.getName()).get(0).getPrice()*3;
                    Statement statement = new Statement(output.name, output.Qid, output.number, date, price, output.amount, "出库");
                    statementDao.save(statement);
                    //删除出库单
                    outputDao.delete(output);
                                   } else returnMessage.message="出库失败,库存不足";

            }
            return returnMessage;
           // break;
        }
        return returnMessage;
    }
    @RequestMapping("/backend/inserto")
    public Object intserto(Output output){
        outputDao.save(output);
        return output;
    }
}

       // Statement statement=new Statement();


