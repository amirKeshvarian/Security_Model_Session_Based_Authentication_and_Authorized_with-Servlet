<%--
  Created by IntelliJ IDEA.
  User: amir
  Date: 8/25/2023
  Time: 5:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <p>${requestScope.msg}</p>
  <br/>
  <br/>
  <form action="/login.do" method="post">
    <input type="text" name="username">
    <input type="password" name="password">
    <input type="submit" value="LOGIN">
  </form>
  </body>
</html>
