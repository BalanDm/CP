<%--
  Created by IntelliJ IDEA.
  User: SvetaPC
  Date: 02.04.2015
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<html>
  <head>
    <title></title>
  </head>
  <body>
  <form name="index-form" class="index-form" action="controller" method="POST">
    <input type="hidden" name="command" value="index" />
    <jsp:forward page="jsp/login.jsp"/>
  </form>
  </body>
</html>
