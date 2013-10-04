package frontend;

/**
 * Created with IntelliJ IDEA.
 * User: vanik
 * Date: 29.09.13
 * Time: 0:45
 * To change this template use File | Settings | File Templates.
 */
public class UserList {
    private String login="user1";
    private String password="user1";
    private Long userid= new Long(1);
    private Boolean haveSession= false;
    public String getLogin() {
        return this.login;
    }
    public String getPassword() {
        return this.password;
    }
    public Long getUserid() {
        return this.userid;
    }
    public Boolean getHaveSession(){
        return haveSession;
    }
    public void setHaveSession(){
        haveSession = true;
    }
}
