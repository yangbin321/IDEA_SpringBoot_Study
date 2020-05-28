<%--
  Created by IntelliJ IDEA.
  User: yangbin
  Date: 2020/3/2
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <!--常用注解-->
        <a href="anno/testRequestParam?name=哈哈">RequestParam</a>

        <br>
        <form action="anno/testRequestBody" method="post">
            用户的姓名：<input type="text" name="username"></br>
            用户的年龄：<input type="text" name="age"></br>
            <input type="submit" value="提交"></br>
        </form>

        <br>

        <a href="anno/testPathVariable/10">PathVariable</a>

        <br>
        <form action="anno/testModelAttribute" method="post">
            用户的姓名：<input type="text" name="uname"></br>
            用户的年龄：<input type="text" name="age"></br>
            <input type="submit" value="提交"></br>
        </form>
<br>
<br>
        <a href="anno/testSessionAttribute">SessionAttribute</a>
        <a href="anno/getSessionAttribute">SessionAttribute</a>
        <a href="anno/deleteSessionAttribute">SessionAttribute</a>


</body>
</html>
