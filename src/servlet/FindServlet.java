package servlet;

import JavaBean.Person;
import com.mysql.cj.protocol.Resultset;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author zdk
 * @Date 2021/3/2 20:04
 */
@WebServlet(name = "FindServlet",urlPatterns = "/FindServlet")
public class FindServlet extends HttpServlet {
    public static Connection getConnection(){
        Connection con=null;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/servlettest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
        String user="root";
        String password="root";
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url, user, password);
            if(con!=null) {
                System.out.println("数据库连接成功!");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int currPage=1;
        if(req.getParameter("page")!=null){
            currPage=Integer.parseInt(req.getParameter("page"));
        }
        Person person=new Person();
        List<Person> list=person.find(currPage);
        req.setAttribute("list", list);
        int pages;
        int count=person.findCount();
        if(count%Person.PAGE_SIZE==0){
            pages=count/Person.PAGE_SIZE;
        }
        else{
            pages=count/Person.PAGE_SIZE+1;
        }
        StringBuffer sb=new StringBuffer();
        for(int i=1;i<=pages;i++){
            if(i==currPage){
                sb.append("["+i+"]");
            }
            else{
                sb.append("<a href='FindServlet?page="+i+"'>"+i+"<a/>");
            }
            sb.append(" ");
        }
        req.setAttribute("bar", sb.toString());
        req.getRequestDispatcher("jsp/person_list.jsp").forward(req, resp);
    }
}
