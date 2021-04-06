<%--
  Created by IntelliJ IDEA.
  User: fengzhu
  Date: 2021/3/8
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userCheck</title>
</head>
<body>
<form action="post" name="form1">
    用户名：<input type="text" name="username" id="username" size="32">
    <input type="button" name="check" id="check" onclick="checkUser(form1.username)">
    密码：<input type="password" name="pwd1" id="pwd1" size="35">
    确认密码：<input type="password" name="pwd2" id="pwd2" size="35">
    E-mail：<input type="text" name="email" id="email" size="45">
</form>
</body>
</html>
