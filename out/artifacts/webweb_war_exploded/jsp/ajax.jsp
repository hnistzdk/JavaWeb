<%--
  Created by IntelliJ IDEA.
  User: fengzhu
  Date: 2021/3/7
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ajax</title>
    <script src="../js/AjaxRequest.js"></script>
</head>
<body>
    <script language="JavaScript">
      //错误处理方法
      function onerror () {
          alert("您的操作有误！");
        }
      //实例化Ajax对象的方法
      function getProvince () {
        let loader=new net.AjaxRequest("ZoneServlet?action=getProvince&nocache="
          +new Date().getTime(),deal_getProvince,onerror,"GET");
      }
      function deal_getProvince () {
        provinceArr=this.req.responseText.split(",");
        for(i=0;i<provinceArr.length;i++){
          $("#province").options[i]=new Option(provinceArr[i],provinceArr[i]);
        }
        if(provinceArr[0]!=""){
          getCity(provinceArr[0]);
        }
      }

      function getCity () {
        let loader=new net.AjaxRequest("ZoneServlet?action=getCity&parProvince="+selProvince
          +"&nocache=" +new Date().getTime(),deal_getCity,onerror,"GET");
      }
      function deal_getCity () {
        cityArr = this.req.responseText.split(",");
        $("#city").length = 0;
        for (i = 0; i < cityArr.length; i++) {
          $("#city").options[i] = new Option(cityArr[i], cityArr[i]);
        }
      }
      window.onload=function () {
        getProvince();
      }
    </script>

<select name="province" id="province" onchange="getCity(this.value)">
</select>
    -
<select name="city" id="city">
</select>
</body>
</html>
