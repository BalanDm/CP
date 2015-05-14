<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  <form name="login-form" class="login-form" action="controller" method="post">
    <input type="hidden" name="command" value="registration" />
    <div class="header">
    <h1>Регистрация</h1>
      </div>
    <div class="content">
      <input name="organization" type="text" class="input organization" value="Организация" onfocus="this.value=''" />
      <input name="phone" type="text" class="input phone" value="Телефон" onfocus="this.value=''" />
      <input name="email" type="text" class="input email" value="E-Mail" onfocus="this.value=''" />
      <input name="password" type="password" class="input password" value="Password" onfocus="this.value=''" />
    </div>
    <div class="footer">
     <input type="submit" name="save" value="Готово!" class="button" />
    </div>

  </form>

</div>
<div class="gradient"></div>
</body>
</html>
