<%--
  Created by IntelliJ IDEA.
  User: fengzhu
  Date: 2021/3/9
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*"%>
<%@ page import="JavaBean.Person" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Connection connection= Person.getConnection();
    Statement statement=connection.createStatement();
    String sql="select * from servletuserregister";
    ResultSet resultSet=statement.executeQuery(sql);
    while(resultSet.next()){
        out.println(resultSet.getString(1));
    }

%>
</body>
</html>
