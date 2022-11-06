<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style> <%@ include file="css/loginStyle.css"%> </style>
  <title>Facebook login</title>
</head>
<body>
<div class="wrapper">
  <div class="item item1">
    <div class="fb">facebook</div>
    <div class="text1">
      <p>Facebook helps you connect and share with the people in your life.</p>
    </div>
  </div>
  <div class="item item2">
    <div style="font-size: 15px; padding-bottom: 9px; color: red">
      <p>${requestScope.errorMessage}</p>
<%--      <c:set var="no_user" value="${requestScope.no_user}"/>--%>
<%--      <h7 id="errorMessage"><c:out value="${message}"/> </h7>--%>
    </div>
    <div class="logInform">
      <form action="LoginServlet" method="post">
        <input type="email" name="email" id="email" placeholder="Email address or phone number" required><br><br>
        <input type="password" name="password" id="password" placeholder="Password" required><br><br>
        <input type="submit" value="Log in" id="login-button"><br><br>
      </form>
      <div class="forget-passwd"><a href="#">Forgotten password?</a></div>
      <a href="signupPage.jsp"><input type="submit" value="Create New Account" id="create"></a>
    </div>
  </div>
</div>
</body>
</html>
