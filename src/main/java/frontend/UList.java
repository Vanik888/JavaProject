package frontend;


import java.util.HashMap;
import java.util.Map;
/**
 * Created with IntelliJ IDEA.
 * User: vanik
 * Date: 04.10.13
 * Time: 9:50
 * To change this template use File | Settings | File Templates.
 */
public class UList {
    private String login1="user1";
    private String password1="user1";
    private Long userid1= new Long(1);

    private String login2="user2";
    private String password2="user2";
    private Long userid2= new Long(2);

    private Map<String, String> logPass = new HashMap<>();
    private Map<String, Object> logId = new HashMap<>();

//    private Boolean haveSession= false;


    public UList() {
        this.logPass.put(login1,password1);
        this.logId.put(login1,userid1);

        this.logPass.put(login2,password2);
        this.logId.put(login2,userid2);
    }

    public Map<String, String> getLogPass() {
        return logPass;
    }

    public Map<String, Object> getLogId() {
        return logId;
    }

//    public String getLogin() {
//        return this.login1;
//    }
//    public String getPassword() {
//        return this.password1;
//    }
//    public Long getUserid() {
//        return this.userid1;
//    }
//    public Boolean getHaveSession(){
//        return haveSession;
//    }
//    public void setHaveSession(){
//        haveSession = true;
//    }
}
