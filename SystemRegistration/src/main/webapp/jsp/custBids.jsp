
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="customers" class="java.util.ArrayList" scope="request"/>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <style>
    <%@include file='css/jq.css' %>
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
<form name="userTable-form" class="userTable-form" action="controller" method="get">
  <input type="hidden" name="command" value="getAll" />
  <div id="main">
    <h1>Ваши заявки
      <input name="search" type="text" class="input search" value="Поиск" onfocus="this.value=''" />
      <select>
        <option>по короблю</option>
        <option>по дате</option>
        <option>по номеру</option>
      </select>
      <input type="submit" name="refresh" value="Обновить" class="button" />
      </h1>
        <table id="tablesorter-demo" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
          <thead>
          <tr>
            <th>Ф.И. оператора</th>
            <th>Номер заявки</th>
            <th>Номер корабля</th>
            <th>Номер груза</th>
            <th>Номер контейнера</th>
            <th>Опасный груз</th>
            <th>Тип операции</th>
            <th>Дата проведения операции</th>
            <th>Удалить</th>
          </tr>
          </thead>
          <tbody>
          <c:forEach items="${customers}" var="customers">
            <tr>
              <td>${customers.getSurnameOper()} | ${customers.getNameOper()}</td>
              <td>${customers.getNumBid()}</td>
              <td>${customers.getNumShip()}</td>
              <td>${customers.getNumCargo()}</td>
              <td>${customers.getNumContainer()}</td>
              <td>${customers.isDanger()}</td>
              <td>${customers.getTypeOp()}</td>
              <td>${customers.getDateOp()}</td>
              <td><a href="controller?id=${customers.numBid}&command=getAll">Удалить</a></td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
    </div>
</form>
</body>
</html>
