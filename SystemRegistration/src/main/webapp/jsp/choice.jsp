<%--
  Created by IntelliJ IDEA.
  User: Ultrabook
  Date: 11.05.2015
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page pageEncoding="UTF-8"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Выбор действия</title>
  <style>
    <%@include file='css/style.css' %>
  </style>
</head>
<body>
<div id="wrapper">
  <form name="choice-form" class="choice-form" action="controller" method="POST">
    <input type="hidden" name="command" value="choice" />
    <c:if test="${empty nameClient}">
      <jsp:include page="../index.jsp"/>
      <jsp:forward page="../index.jsp"/>
    </c:if>
    <div class="main"> <input type="submit" name="exit" value="Выход" class="buttonRight" /></div>
    <div class="header">
      <input type="submit" name="view" value="Просмотреть заявки" class="button" />
    </div>
    <div class="footer">
      <input type="submit" name="add" value="Оформить заявку" class="button" />
    </div>
  </form>
</div>
<div class="gradient"></div>
</body>
</html>