<%--
  Created by IntelliJ IDEA.
  User: linzhen
  Date: 18/10/23
  Time: 下午2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>jdbc demo</title>
  </head>
  <body>
  <form action="/Password" method="post">
     名称: <input type="text" name="name"/>
     链接: <input type="text" name="url"/>
    <input type="submit" value="提交">
  </form>
  </body>
</html>
<% request.setCharacterEncoding("UTF-8"); %>
