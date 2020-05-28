<%--
  Created by IntelliJ IDEA.
  User: yangbin
  Date: 2020/3/2
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC第二天</title>

    <script src="js/jquery-3.3.1.js"></script>

    <script>
        //页面加载,绑定单击事件
        $(function() {
            $("#btn").click(function () {
                // alert("hello btn");
                //发送ajax请求
                $.ajax({
                   // 编写json格式，设置属性和值
                    url:"user/testAjax",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"hehe",""passsword":"123","age":"20"}',
                    dataType:"json",
                    type:"post",
                    success:function (data) {
                        //data服务器相应的json数据，进行解析
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age);
                    }
                });
            });

        });

    </script>

</head>
<body>
    <a href="user/testString">testString</a><br>

    <a href="user/testVoid">testVoid</a><br>

    <a href="user/testModelAndView">testModelAndView</a><br>

    <button id="btn">发送ajax请求</button><br>

</body>
</html>
