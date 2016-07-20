package cn.net.wangchenyu.finance.session;

/**
 * Created by cheneyveron on 7/18/16.
 * visit_time:建立session时间
 * visit_token:此次session会话的指纹
 * visit_user_name:用户名
 * visit_user_id:用户编号
 */
public class SessionUser {
    public int visit_time;
    public String visit_token;
    public String visit_user_name;
    public String visit_user_role;
    public int visit_user_id;
    public SessionUser(int visit_time, String visit_token, String visit_user_name, String visit_user_role, int visit_user_id) {
        this.visit_time = visit_time;
        this.visit_token = visit_token;
        this.visit_user_name = visit_user_name;
        this.visit_user_role = visit_user_role;
        this.visit_user_id = visit_user_id;
    }
}
