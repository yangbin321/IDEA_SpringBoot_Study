<%--
  Created by IntelliJ IDEA.
  User: yangbin
  Date: 2020/3/1
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<br>

    <!--请求参数的绑定-->
    <!--
    <a href="param/testParam/?username=dahei&password=123321">请求参数的绑定</a>
    -->

    <!--表单,Account中有另外一个类
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username"></br>
        密码：<input type="text" name="password"></br>
        金额：<input type="text" name="money"></br>
        用户的姓名：<input type="text" name="user.uname"></br>
        用户的年龄：<input type="text" name="user.age"></br>
        <input type="submit" value="提交"></br>
    </form>
    -->

<!--把数据封装Account类中，类中存在list和map的集合
    <form action="param/saveAccount" method="post">
        姓名：<input type="text" name="username"></br>
        密码：<input type="text" name="password"></br>
        金额：<input type="text" name="money"></br>

        用户的姓名：<input type="text" name="list[0].uname"></br>
        用户的年龄：<input type="text" name="list[0].age"></br>

        用户的姓名：<input type="text" name="map['one'].uname"></br>
        用户的年龄：<input type="text" name="map['one'].age"></br>
        <input type="submit" value="提交"></br>
    </form>

    -->

<!--自定义转换器
    <form action="param/saveUser" method="post">
        用户的姓名：<input type="text" name="uname"></br>
        用户的年龄：<input type="text" name="age"></br>
        用户的生日：<input type="text" name="date"></br>
        <input type="submit" value="提交"></br>
    </form>
    -->


    <a href="param/testServlet">Serclet原生的API</a>

</body>
</html>
