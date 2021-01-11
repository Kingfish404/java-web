<%@ page contentType="text/html; charset=UTF-8"  %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<%= new String("hello,world") %>
${String("hello")}
<%
    // 这里可以放java代码
%>
    <h2>你好，世界!</h2>
</body>
</html>