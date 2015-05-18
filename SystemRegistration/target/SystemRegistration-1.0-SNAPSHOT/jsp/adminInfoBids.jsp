<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="customers" class="java.util.ArrayList" scope="request"/>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <style>
    <%@include file='css/jq.css' %>
    <%@include file='css/style.css' %>
    <%@include file='css/blue/style.css' %>
    <%@include file='css/blue/style2.css' %>
  </style>
  <script>
    <%@include file='js/jquery-latest.js' %>
    <%@include file='js/jquery.tablesorter.js' %>
    <%@include file='js/chili-1.8b.js' %>
    <%@include file='js/docs.js' %>
  </script>
  <script>
    $(function() {
      $("#tablesorter-demo").tablesorter({sortList:[[0,0],[2,1]], widgets: ['zebra']});
      $("#options").tablesorter({sortList: [[0,0]], headers: { 3:{sorter: false}, 4:{sorter: false}}});
    });
  </script>
</head>
<body>
<form name="adminTable-form" class="adminTable-form" action="controller" method="POST">
  <input type="hidden" name="command" value="getAllInfoByAdmin" />
  <c:if test="${empty nameAdmin}">
    <jsp:include page="../index.jsp"/>
    <jsp:forward page="../index.jsp"/>
  </c:if>
  <div id="main" class="main">
    <h1>Ваши заявки
      <input name="search" type="text" class="input search" value="Поиск" onfocus="this.value=''" />
      <select name="searchType">
        <option value="bidNum">по номеру заявки</option>
        <option value="shipNum">по номеру коробля</option>
        <option value="cargoNum">по номеру груза</option>
        <option value="numContainer">по номеру контейнера</option>
        <option value="dateOp">по дате операции</option>
        <option value="client">по клиентам</option>
      </select>
      <input type="submit" name="search" value="Искать" class="button" />
      <input type="submit" name="refresh" value="Обновить" class="button" />
      <input type="submit" name="exit" value="Выход" class="buttonRight" />
      <input type="submit" name="back" value="Назад" class="buttonRight" />
    </h1>
    <table id="tablesorter-demo" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
      <thead>
      <tr>
        <th>Номер заявки</th>
        <th>Организация</th>
        <th>Номер корабля</th>
        <th>Номер груза</th>
        <th>Тип операции</th>
        <th>Номер контейнера</th>
        <th>Опасный груз</th>
        <th>Тип контейнера</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${allBids}" var="allBids">
        <tr>
          <td>${allBids.getNumBid()}</td>
          <td>${allBids.getNameOrganization()}</td>
          <td>${allBids.getNumShip()}</td>
          <td>${allBids.getNumCargo()}</td>
          <td>${allBids.getTypeOp()}</td>
          <td>${allBids.getNumContainer()}</td>
          <td>${allBids.isDanger()}</td>
          <td>${allBids.getTypeContainer()}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</form>
</body>
</html>
