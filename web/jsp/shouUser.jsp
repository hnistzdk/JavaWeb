<%--
  Created by IntelliJ IDEA.
  User: fengzhu
  Date: 2021/2/21
  Time: 20:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  session="true" %>
<%@ page import="listener.UserInfoTrace"%>
<%@ page import="listener.UserInfoList"%>
<%@ page import="java.util.*,java.lang.*"%>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<html>
<head>
    <title>user</title>
</head>
<body>
<%
    UserInfoList list=UserInfoList.getInstance();
    UserInfoTrace ut=new UserInfoTrace();
    String name=request.getParameter("user");
    ut.setUser(name);
    HttpSession session1=request.getSession();
    session1.setAttribute("list",ut);
    list.addUserInfo(ut.getUser());
    session1.setMaxInactiveInterval(10);
%>
<textarea rows="8" cols="20">
    <%
        Vector<String> vector=list.getList();
        if(vector!=null&&vector.size()>0){
            for(int i=0;i<vector.size();i++){
                out.println(vector.elementAt(i));
            }
        }
    %>
</textarea>
</body>
</html>
