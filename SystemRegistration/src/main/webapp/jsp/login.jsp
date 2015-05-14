<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Вход</title>
  <style>
    <%@include file='css/style.css' %>
  </style>
  <script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.2.6/jquery.min.js"></script>
  <script>
    <%@include file='js/iconmove.js' %>
  </script>
</head>
<body>
<div id="wrapper">
  <div class="email-icon-idx"></div>
  <div class="pass-icon-idx"></div>
  <form name="login-form" class="login-form" action="controller" method="post">
    <input type="hidden" name="command" value="login" />
    <div class="header">
    <h1>Вход</h1>
    </div>
    <div class="content">
      <input name="mail" type="text" class="input email" value="E-Mail" onfocus="this.value=''" />
      <input name="pass" type="password" class="input password" value="Password" onfocus="this.value=''" />
    </div>
    <div class="footer">
    <input type="submit" name="log" value="Вход" class="button" />
    <input type="submit" name="reg" value="Регистрация" class="register" />
    </div>
  </form>
</div>
<div class="gradient"></div>
</body>
</html>
