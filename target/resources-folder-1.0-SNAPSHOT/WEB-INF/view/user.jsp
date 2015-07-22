<%--
  Created by IntelliJ IDEA.
  User: liaoting
  Date: 2015-07-22
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>user</title>
</head>
<body>
  username: <input type="text" name="username" value="${user.userName}"/>
  password: <input type="text" name="password" value="${user.passWord}"/>
  firstname: <input type="text" name="firstname" value="${user.firstName}"/>
  lastname: <input type="text" name="lastname" value="${user.lastName}"/>

</body>
</html>
