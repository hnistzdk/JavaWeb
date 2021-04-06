package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @Description
 * @Author zdk
 * @Date 2021/3/1 18:23
 */
//利用注释便可无需在web.XML文件里添加servlet的映射
    //连接数据库报错是因为没有导入数据库连接的jar包
@WebServlet(name = "SaveServlet",urlPatterns = "/SaveServlet")
public class SaveServlet extends HttpServlet {
    private Connection con=null;
    @Override
    public void init(ServletConfig config) throws ServletException {
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
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String sex=req.getParameter("sex");
        String question=req.getParameter("question");
        String answer=req.getParameter("answer");
        String email=req.getParameter("email");
        if(con!=null){
            try {
                String sql="insert into servletuserregister(username,password,sex,question,answer,email)"
                        +"values(?,?,?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, sex);
                ps.setString(4, question);
                ps.setString(5, answer);
                ps.setString(6, email);
                ps.executeUpdate();
                PrintWriter out= resp.getWriter();
                out.println("</h1>");
                out.flush();
                out.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        else{
            resp.sendError(500, "数据库连接错误");
        }
    }
}
