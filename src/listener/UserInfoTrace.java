package listener;

import jakarta.servlet.http.HttpSessionBindingListener;
import jakarta.servlet.http.HttpSessionEvent;
import listener.UserInfoList;

/**
 * @Description
 * @Author zdk
 * @Date 2021/2/21 20:25
 */
public class UserInfoTrace implements HttpSessionBindingListener {
    private String user;
    private UserInfoList container =UserInfoList.getInstance();
    public UserInfoTrace(){
        user="";
    }
    //设置在线监听人员
    public void setUser(String user){
        this.user=user;
    }
    //获取在线监听
    public String getUser(){
        return this.user;
    }
    public void valueBound(HttpSessionEvent arg0){
        System.out.println("上线"+this.user);
    }
    public void valueUnbound(HttpSessionEvent arg0){
        System.out.println("下线"+this.user);
        if(user!=null){
            container.removeUserInfo(user);
        }
    }
}
