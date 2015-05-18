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
  <input type="hidden" name="command" value="getAllByAdmin" />
  <c:if test="${empty nameAdmin}">
    <jsp:forward page="../index.jsp"/>
  </c:if>
  <div id="main" class="main">
    <h1>Ваши заявки
      <input name="search" type="text" class="input search" value="Поиск" onfocus="this.value=''" />
      <select name="searchType">
        <option value="bidNum">по номеру заявки</option>
        <option value="shipNum">по номеру коробля</option>
        <option value="cargoNum">по номеру груза</option>
        <option value="dateOp">по дате операции</option>
        <option value="client">по клиентам</option>
      </select>
      <input type="submit" name="searchOk" value="Искать" class="button" />
      <input type="submit" name="refresh" value="Обновить" class="button" />
      <input type="submit" name="exit" value="Выход" class="buttonRight" />
      <input type="submit" name="info" value="Доп. информация" class="buttonRight" />
    </h1>
    <table id="tablesorter-demo" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
      <thead>
      <tr>
        <th>Номер заявки</th>
        <th>Организация</th>
        <th>Контактный тел.</th>
        <th>Mail</th>
        <th>Номер коробля</th>
        <th>Наименование коробля</th>
        <th>Номер груза</th>
        <th>Тип операции</th>
        <th>Дата операции</th>
        <th>Отклонить</th>
        <th>Одобрить</th>
        <th>Удалить</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${allBids}" var="allBids">
        <tr>
          <td>${allBids.getNumBid()}</td>
          <td>${allBids.getNameOrganization()}</td>
          <td>${allBids.getPhone()}</td>
          <td>${allBids.getEmail()}</td>
          <td>${allBids.getNumShip()}</td>
          <td>${allBids.getNameShip()}</td>
          <td>${allBids.getNumCargo()}</td>
          <td>${allBids.getTypeOp()}</td>
          <td>${allBids.getDateOp()}</td>
          <td><a href="controller?id=${allBids.numBid}&command=getAllByAdmin">Отклонить</a></td>
          <td><a href="controller?idUpdate=${allBids.numBid}&command=getAllByAdmin&#openModal">Одобрить</a></td>
          <td><a href="controller?idDelete=${allBids.numBid}&command=getAllByAdmin">Удалить</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
  <div id="openModal" class="modalDialog">
    <div>
      <a href="controller?close=1&command=getAllByAdmin&#close" title="Закрыть" class="close" formnovalidate>X</a>
      <h2>Введя дату вы одобрете заявку</h2>
      <h2>Номер заявки: ${bidOk}</h2>
      <br>
      <table  border="0" cellpadding="0" cellspacing="1">
         <tr>
            <td>Число(dd):</td>
            <td><input pattern="(0[1-9]|1[0-9]|2[0-9]|3[01])" name="day" type="text" class="input day" value=""/></td>
         </tr>
        <tr>
          <td>Месяц(mm):</td>
          <td><input pattern="(0[1-9]|1[012])" name="month" type="text" class="input month" value=""/></td>
        </tr>
        <tr>
          <td>Год(yyyy):</td>
          <td><input pattern="[0-9]{4}" name="year" type="text" class="input year" value=""/> </td>
        </tr>
      </table>
      <br>
      <input type="submit" name="goodBid" value="Одобрить" class="button" />
    </div>
  </div>
</form>
</body>
</html>

