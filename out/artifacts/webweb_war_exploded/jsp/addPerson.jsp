<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %><%--
  Created by IntelliJ IDEA.
  User: fengzhu
  Date: 2021/3/2
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="person" class="JavaBean.Person"></jsp:useBean>
<jsp:setProperty name="person" property="*"></jsp:setProperty>

<html>
<head>
    <title>添加界面</title>
</head>
<body>
<%
    String driver="com.mysql.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/servlettest?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC";
    String user="root";
    String password="root";
    Class.forName(driver);
    Connection con=DriverManager.getConnection(url, user, password);
    String sql="insert into servletuserregister(username,password,sex,question,answer,email)"
            +"values(?,?,?,?,?,?)";
    PreparedStatement ps=con.prepareStatement(sql);
    ps.setString(1, person.getUsername());
    ps.setString(2, person.getPassword());
    ps.setString(3, person.getSex());
    ps.setString(4, person.getQuestion());
    ps.setString(5, person.getAnswer());
    ps.setString(6, person.getEmail());
    int row=ps.executeUpdate();
    if(row>0){
        out.println("成功添加了"+row+"条数据！");
    }
    ps.close();con.close();
%>
<br>
<a href="personinformation.jsp">返回</a>
</body>
</html>
