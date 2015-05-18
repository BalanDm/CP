<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page pageEncoding="UTF-8"%>

<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Регистрация</title>
  <style>
    <%@include file='css/style.css' %>
  </style>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
  <script>
    <%@include file='js/iconmovereg.js' %>
  </script>
</head>
<body>
<div id="wrapper">
  <div class="user-icon"></div>
  <div class="pass-icon"></div>
  <div class="phone-icon"></div>
  <div class="email-icon"></div>
  <form name="login-form" class="login-form" action="controller" method="POST">
    <input type="hidden" name="command" value="registration" />
    <div class="header">
    <h1>Регистрация</h1>
      </div>
    <div class="content">
      <input placeholder="Организация на Англ." pattern="[a-zA-Z0-9-_\.]{1,20}$" name="organization" type="text" class="input organization" value="Организация" onfocus="this.value=''" required/>
      <input placeholder="Кол-во цифр < 15" pattern="[0-9]{,15}" name="phone" type="text" class="input phone" value="Телефон" onfocus="this.value=''" required/>
      <input placeholder="E-mail" type="email" name="mail" type="text" class="input email" value="E-mail" onfocus="this.value=''" required/>
      <input placeholder="password" name="pass" type="password" class="input password"  value="password" onfocus="this.value=''"required/>
    </div>
    <div class="footer">
     <input type="submit" name="save" value="Готово!" class="button" />
      <input type="submit" name="back" value="Назад" class="button" formnovalidate/>
    </div>

  </form>

</div>
<div class="gradient"></div>
</body>
</html>
