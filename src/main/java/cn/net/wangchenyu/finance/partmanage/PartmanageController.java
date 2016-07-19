package cn.net.wangchenyu.finance.partmanage;

import cn.net.wangchenyu.finance.dao.ComponentsDao;
import cn.net.wangchenyu.finance.model.Components;
import cn.net.wangchenyu.finance.model.ReturnMessage;
import cn.net.wangchenyu.finance.service.AuthService;
import com.sun.xml.internal.ws.api.ha.StickyFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    //入库。
    @RequestMapping("backend/partmanage/input")
    public void input(Components components){
        Iterable<Components> componentses=componentsDao.findAll();
        for (Components componentse:componentses) {
            if (components.getName().equals(componentse.getName())) {
                componentse.setAmount(componentse.getAmount() + components.getAmount());
                componentsDao.save(componentse);
            } else {
                componentsDao.save(components);
            }
        }

    }
}
