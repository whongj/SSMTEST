<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/5/14
  Time: 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<%
    String opid = request.getParameter("opid");
%>
<body>
<form action="main.jsp" method="POST">
    姓名: <input type="text" name="name">
    <br />
    年龄: <input type="text" name="url" />

    <input type="submit" value="提交" />
</form>

</body>
</html>
