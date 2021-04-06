<%--
  Created by IntelliJ IDEA.
  User: fengzhu
  Date: 2021/3/1
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
</head>
<body>
    <form action="SaveServlet" method="post" onsubmit="return reg(this)">
        <table>
            <tr>
                <td align="right" width="30%">用户名:</td>
                <td><input type="text" name="username" class="box"></td>
            </tr>
            <tr>
                <td align="right">密码：</td>
                <td><input type="password" name="password" class="box"></td>
            </tr>
            <tr>
                <td align="right">确认密码：</td>
                <td><input type="password" name="repassword" class="box"></td>
            </tr>
            <tr>
                <td align="right">性别：</td>
                <td>
                    <input type="radio" name="sex" value="男" checked="checked">男
                    <input type="radio" name="sex" value="女">女
                </td>
            </tr>
            <tr>
                <td align="right">密保问题：</td>
                <td><input type="text" name="question" class="box"></td>
            </tr>
            <tr>
                <td align="right">密保答案：</td>
                <td><input type="text" name="answer" class="box"></td>
            </tr>
            <tr>
                <td align="right">邮箱：</td>
                <td><input type="text" name="email" class="box"></td>
            </tr>
            <tr>
                <td colspan="2" align="center" height="40">
                    <input type="submit" value="注册">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
