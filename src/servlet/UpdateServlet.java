package servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * @Description
 * @Author zdk
 * @Date 2021/3/3 20:20
 */
@WebServlet(name = "UpdateServlet",urlPatterns = "/UpdateServelt")
public class UpdateServlet extends HttpServlet {
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
        String username=req.getParameter("username");
        String email=req.getParameter("email");
        try {
            String sql="update servletuserregister set email=? where username=?";
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2,username);
            ps.executeUpdate();
            ps.close();
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        resp.sendRedirect("FindServlet");
    }
}
