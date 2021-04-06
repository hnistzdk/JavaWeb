<%--
  Created by IntelliJ IDEA.
  User: fengzhu
  Date: 2021/3/2
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人信息</title>
</head>
<body>
<form action="addPerson.jsp" method="post" onsubmit="return check(this)">
    <table align="center" width="450">
        <tr>
            <td align="center" colspan="2">
                <h2>添加人员信息</h2>
                <hr>
            </td>
        </tr>
        <tr>
            <td align="right">用户名：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td align="right">密码：</td>
            <td><input type="text" name="password"></td>
        </tr>
        <tr>
            <td align="right">性别：</td>
            <td><input type="text" name="sex"></td>
        </tr>
        <tr>
            <td align="right">密保问题：</td>
            <td><input type="text" name="question"></td>
        </tr>
        <tr>
            <td align="right">密保答案：</td>
            <td><input type="text" name="answer"></td>
        </tr>
        <tr>
            <td align="right">邮箱：</td>
            <td><input type="text" name="email"></td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="添加">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
