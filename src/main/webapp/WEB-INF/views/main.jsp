<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Hell, World!</h1>
<img src="img/e.jpg">
<div>
    <%-- GET 방식 --%>
    <a href="t1">t1 이동.</a>
    <a href="t2">t2 이동.</a>
    <a href="t3">t3 get</a>
    <%-- GET/POST 둘 다 받을 수 있는 test5 메서드를 이용한다.--%>
    <a href="t4">t4 get/post hybrid</a>

    <%-- POST 방식 --%>
    <form action="t3" method="post">
        <button type="submit">post1 post</button>
    </form>

    <%-- GET/POST 둘 다 받을 수 있는 test5 메서드를 이용한다.--%>
    <form action="t4" method="post">
        <button type="submit">get/post hybrid</button>
    </form>
</div>
</body>
</html>
