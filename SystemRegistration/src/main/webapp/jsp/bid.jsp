<%--
  Created by IntelliJ IDEA.
  User: Ultrabook
  Date: 12.05.2015
  Time: 13:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <form name="bid-form" class="bid-form" action="controller" method="post">
    <input type="hidden" name="command" value="bid" />
    <div class="header">
      <h1>Форма заявки</h1>
    </div>
    <div class="content">
      <h2>Номер корабля</h2>
      <input name="shipNum" type="text" class="input shipNum" value="" onfocus="this.value=''" />
      <h2>Наименование коробля</h2>
      <input name="shipName" type="text" class="input shipName" value="" onfocus="this.value=''" />
      <h2>Номер груза</h2>
      <input name="cargoNum" type="text" class="input cargoNum" value="" onfocus="this.value=''" />
      <h2>Наименование груза</h2>
      <input name="cargoName" type="text" class="input cargoName" value="" onfocus="this.value=''" />
      <h2>Тип операции</h2>
      <p>
      <h3 align="center">Погрузка</h3> <input name="typeOp" type="radio" class="input_typeOp" value="in" />
      <h3 align="center">Отгрузка</h3> <input name="typeOp" type="radio" class="input_typeOp" value="out" />
      </p>
      <h2>Опасный груз</h2>
      <input name="dangerCargo" type="checkbox" class="input_check" value="danger" />
      <h2>Номер контейнера</h2>
      <input name="containerNum" type="text" class="input containerNum" value="" onfocus="this.value=''" />
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
