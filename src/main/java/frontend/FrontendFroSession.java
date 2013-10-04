package frontend;

/**
 * Created with IntelliJ IDEA.
 * User: vanik
 * Date: 28.09.13
 * Time: 23:11
 * To change this template use File | Settings | File Templates.
 */
import frontend.UserList;
import templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;




public class FrontendFroSession extends HttpServlet {
    private String login = "";
    private String password = "";
    private AtomicLong userIdGenerator = new AtomicLong();
    private UserList users = new UserList();


    private UList mUsers = new UList();
//    private Map<String, Object>

//    private struct Users{
//        String login="user1";
//
//    }
    public static String getTime() {
        Date date = new Date();
        date.getTime();
        DateFormat formatter = new SimpleDateFormat("HH.mm.ss");
        return formatter.format(date);
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        Map<String, Object> pageVariables = new HashMap<>();

        if (request.getPathInfo().equals("/authform")){
            HttpSession session = request.getSession();
            Long userId = (Long) session.getAttribute("userId");
            if (userId != null) {
                pageVariables.put("login", session.getAttribute("login"));
                pageVariables.put("userid", mUsers.getLogId().get(session.getAttribute("login")));
                pageVariables.put("userId", userId);
                pageVariables.put("refreshPeriod","2000");
                pageVariables.put("serverTime",getTime());
                response.getWriter().println(PageGenerator.getPage("auth_ok.tml",pageVariables));
                return;
            }
            else {
                response.getWriter().println(PageGenerator.getPage("authform.tml",pageVariables));
                return;
            }
        }

//        if (request.getPathInfo().equals("/authform")){
//            HttpSession session = request.getSession();
//            Long userId = (Long) session.getAttribute("userId");
//            if (userId != null) {
//                pageVariables.put("login",users.getLogin());
//                pageVariables.put("userid", users.getUserid());
//                pageVariables.put("userId", userId);
//                pageVariables.put("refreshPeriod","2000");
//                pageVariables.put("serverTime",getTime());
//                response.getWriter().println(PageGenerator.getPage("auth_ok.tml",pageVariables));
//                return;
//            }
//            else {
//                response.getWriter().println(PageGenerator.getPage("authform.tml",pageVariables));
//                return;
//            }
//        }
    }



    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws ServletException, IOException {
        login = request.getParameter("login");
        password = request.getParameter("password");
        Map<String, Object> pageVariables = new HashMap<>();
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
        HttpSession session= request.getSession();
        Long userId = (Long) session.getAttribute("userId");
        if (password.equals(mUsers.getLogPass().get(login))) {
            if (userId == null){
                userId = userIdGenerator.getAndIncrement();
                session.setAttribute("userId",userId);
                session.setAttribute("login", login);
                pageVariables.put("refreshPeriod","3000");
                pageVariables.put("serverTime",getTime());
                pageVariables.put("login",login);
                pageVariables.put("userid",mUsers.getLogId().get(login));
                pageVariables.put("userId",userId);
                response.getWriter().println(PageGenerator.getPage("auth_ok.tml",pageVariables));
                return;
            }
        } else {
            response.getWriter().println(PageGenerator.getPage("authform.tml",pageVariables));
            return;
        }
    }
//    public void doPost(HttpServletRequest request,
//                       HttpServletResponse response) throws ServletException, IOException {
//        login = request.getParameter("login");
//        password = request.getParameter("password");
//        Map<String, Object> pageVariables = new HashMap<>();
//        response.setContentType("text/html;charset=utf-8");
//        response.setStatus(HttpServletResponse.SC_OK);
//        HttpSession session= request.getSession();
//        Long userId = (Long) session.getAttribute("userId");
//        if (login.equals(users.getLogin()) && password.equals(users.getPassword())) {
//            if (userId == null){
//                userId = userIdGenerator.getAndIncrement();
//                session.setAttribute("userId",userId);
//                pageVariables.put("refreshPeriod","3000");
//                pageVariables.put("serverTime",getTime());
//                pageVariables.put("login",users.getLogin());
//                pageVariables.put("userid",users.getUserid());
//                pageVariables.put("userId",userId);
//                response.getWriter().println(PageGenerator.getPage("auth_ok.tml",pageVariables));
//                return;
//            }
//        } else {
//            response.getWriter().println(PageGenerator.getPage("authform.tml",pageVariables));
//            return;
//        }
//    }

}
