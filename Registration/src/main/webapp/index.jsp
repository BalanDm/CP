<%--
  Created by IntelliJ IDEA.
  User: Ultrabook
  Date: 21.04.2015
  Time: 1:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form action="/s" method="post">
  <center>
    <table cellpadding=4 cellspacing=2 border=0>
      <th bgcolor="#CCCCFF" colspan=2>
        <font size=5>REGISTRATION</font>
      </th>
      <tr bgcolor="#c8d8f8">
        <td valign=top>
          Organization*
          <input type="text" name="nameOrganization" value="${setOrganization}" size=15 maxlength=20></td>
        <td  valign=top>
          Phone*
          <input type="text" name="phone" value="${setPhone}" size=15 maxlength=20></td>
      </tr>
      <tr bgcolor="#c8d8f8">
        <td valign=top colspan=2 align=center>
          E-Mail*
          <input type="text" name="email" value="${setEmail}" size=25  maxlength=125>
        </td>
      </tr>
      <tr bgcolor="#c8d8f8">
        <td valign=top>
          Password*
          <input type="password" name="password1" size=10 value=""
                 maxlength=10></td>
        <td  valign=top>
          Confirm Password*
          <input type="password" name="password2" size=10 value=""
                 maxlength=10></td>
      </tr>
      <tr bgcolor="#c8d8f8">
        <td  align=center colspan=2>
          <input type="submit" name="save" value="Submit">
          <input type="reset" name="cancel"
                 value="Reset">
        </td>
      </tr>
      </tr>
      <tr bgcolor="#c8d8f8">
        <td  align=center colspan=2>
          <font color="red">${err}</font>
          <font color="green">${isSave}</font>
        </td>
      </tr>
    </table>
  </center>
</form>
</body>
</html>

