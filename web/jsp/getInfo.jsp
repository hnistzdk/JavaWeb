<%--
  Created by IntelliJ IDEA.
  User: fengzhu
  Date: 2021/3/7
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java"%>
<%@ page import="java.sql.*" %>
<%@ page import="JavaBean.Person" %>
<jsp:useBean id="person" class="JavaBean.Person" scope="page"></jsp:useBean>
<html>
<head>
    <title>getInfo</title>
</head>
<body>
    <ul>
        <%
            String sql="select * from servletuserregister order by username desc";
            ResultSet rs= Person.getConnection().createStatement().executeQuery(sql);
            if(rs.next()){
                do{
                    out.println("<li>"+rs.getString(1)+"</li>");
                }while(rs.next());
            }else{
                out.println("<li>暂无人员信息</li>");
            }
        %>
    </ul>
</body>
</html>
