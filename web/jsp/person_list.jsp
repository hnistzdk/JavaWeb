<%@ page import="java.util.List" %>
<%@ page import="JavaBean.Person" %>
<%@ page import="java.util.TreeMap" %><%--
  Created by IntelliJ IDEA.
  User: fengzhu
  Date: 2021/3/2
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询后的人员信息名单</title>
</head>
<body>
    <table align="center" width="450" border="1">
        <tr>
            <td align="center" colspan="5">
                <h2>所有人员信息</h2>
            </td>
        </tr>
        <tr align="center">
            <td><b>用户名：</b></td>
            <td><b>密码：</b></td>
            <td><b>性别：</b></td>
            <td><b>密保问题：</b></td>
            <td><b>密保答案：</b></td>
            <td><b>邮箱：</b></td>
            <td><b>修改：</b></td>
        </tr>
        <%
            //获取人员信息集合
            List<Person> list=(List<Person>) request.getAttribute("list");
            if(list==null||list.size()<1){
                out.println("没有数据");
            }
            else{
                //遍历集合中的数据
                for(Person person :list){
        %>
            <tr align="center">
                <td><%=person.getUsername()%></td>
                <td><%=person.getPassword()%></td>
                <td><%=person.getSex()%></td>
                <td><%=person.getQuestion()%></td>
                <td><%=person.getAnswer()%></td>
                <td><%=person.getEmail()%></td>
                <td>
                    <form action="UpdateServelt" method="post" onsubmit="return check(this)">
                        <input type="hidden" name="username" value="<%=person.getUsername()%>">
                        <input type="text" name="email" size="3">
                        <input type="submit" value="修改">
                    </form>
                </td>
            </tr>
        <%
                }
            }
        %>
        <tr>
            <td align="center" colspan="5">
                <%=request.getAttribute("bar")%>
            </td>
        </tr>
    </table>
</body>
</html>
