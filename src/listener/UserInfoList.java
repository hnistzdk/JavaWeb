package listener;

import java.util.Vector;

/**
 * @Description
 * @Author zdk
 * @Date 2021/2/21 20:21
 */
public class UserInfoList {
    private static UserInfoList user=new UserInfoList();
    private Vector<String> vector=null;
    public UserInfoList() {
        this.vector= new Vector<>();
    }
    public static UserInfoList getInstance(){
        return user;
    }
    public boolean addUserInfo(String user){
        if(user!=null){
            this.vector.add(user);
            return true;
        }
        else{
            return false;
        }
    }
    public Vector<String> getList(){
        return vector;
    }
    public void removeUserInfo(String user){
        if(user!=null){
            vector.remove(user);
        }
    }
}
