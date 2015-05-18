<%--
  Created by IntelliJ IDEA.
  User: Ultrabook
  Date: 12.05.2015
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page pageEncoding="UTF-8"%>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Регистрация заявки</title>
  <style>
    <%@include file='css/style.css' %>
  </style>
</head>
<body>
<div id="wrapper">
  <form name="bid-form" class="bid-form" action="controller" method="POST">
    <input type="hidden" name="command" value="bid" />
    <c:if test="${empty nameClient}">
      <jsp:include page="../index.jsp"/>
      <jsp:forward page="../index.jsp"/>
    </c:if>
    <div class="main">
      <input type="submit" name="home" value="На главную" class="buttonRight" formnovalidate/>
      <input type="submit" name="exit" value="Выход" class="buttonRight" formnovalidate/></div>
    <div class="header">
      <h1>Форма заявки</h1>
    </div>
    <div class="content">
      <h2>Номер корабля</h2>
      <input pattern="[a-zA-Z0-9-_\.]{1,20}$" name="shipNum" type="text" class="input shipNum" value="" onfocus="this.value=''" required/>
      <h2>Наименование коробля</h2>
      <input pattern="[a-zA-Z0-9-_\.]{1,20}$" name="shipName" type="text" class="input shipName" value="" onfocus="this.value=''" required/>
      <h2>Номер груза</h2>
      <input pattern="[a-zA-Z0-9-_\.]{1,20}$" name="cargoNum" type="text" class="input cargoNum" value="" onfocus="this.value=''" required/>
      <h2>Тип операции</h2>
      <p>
      <h3 align="center">Погрузка</h3> <input name="typeOp" type="radio" class="input_typeOp" value="in" checked required/>
      <h3 align="center">Отгрузка</h3> <input name="typeOp" type="radio" class="input_typeOp" value="out" required/>
      </p>
      <h2>Опасный груз</h2>
      <input name="dangerCargo" type="checkbox" class="input_check" value="danger" />
      <h2>Номер контейнера</h2>
      <input pattern="[a-zA-Z0-9-_\.]{1,20}$" name="containerNum" type="text" class="input containerNum" value="" onfocus="this.value=''" required/>
      <h2>Тип контейнера</h2>
      <select name="containerType">
        <option value="20DC">20DC</option>
        <option value="40DC">40DC</option>
        <option value="40HC">40HC</option>
        <option value="45HC">45HC</option>
      </select>
    </div>
    <div class="footer">
      <input type="submit" name="reg" value="Зарегистрировать" class="button" />
    </div>
  </form>
</div>
<div class="gradient"></div>
</body>
</html>
