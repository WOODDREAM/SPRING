<%--
  Created by IntelliJ IDEA.
  User: liaoting
  Date: 2015-07-20
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>提交表单</title>
  </head>
  <body>
    <form action="${ctx}/user/to_login" method="post">
      userName：<input type="text" name="userName"><br>
      passWord： <input type="password" name="passWord"><br>
      firstName：<input type="text" name="firstName"><br/>
      lastName：<input type="text" name="lastName"><br/>
      age：<input type="text" name="age"><br/>
      birthday：<input type="text" name="birthday"><br/>
      <input type="submit" value="提交">
    </form>
  </body>
</html>
