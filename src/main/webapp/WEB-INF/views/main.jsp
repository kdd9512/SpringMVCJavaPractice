<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Hell, World!</h1>
<img src="img/e.jpg">

<%-- GET /POST 요청방식 예제 --%>
<%--<div>--%>
<%-- GET 방식 --%>
<%--    <a href="t1">t1 이동.</a>--%>
<%--    <a href="t2">t2 이동.</a>--%>
<%--    <a href="t3">t3 get</a>--%>

<%-- GET/POST 둘 다 받을 수 있는 test5 메서드를 이용한다.--%>
<%--    <a href="t4">t4 get/post hybrid</a>--%>

<%-- POST 방식 --%>
<%--    <form action="t3" method="post">--%>
<%--        <button type="submit">post1 post</button>--%>
<%--    </form>--%>

<%-- GET/POST 둘 다 받을 수 있는 test5 메서드를 이용한다.--%>
<%--    <form action="t4" method="post">--%>
<%--        <button type="submit">get/post hybrid</button>--%>
<%--    </form>--%>
<%--</div>--%>

<%-- HttpServletRequest / WebRequest / PathVariable 예제 --%>

<%--HttpServletRequest--%>
<ul>
    <li href="t1?data1=1972&data2=1121">HttpServletRequest get</li>
    <li href="t1?data1=1972&data2=1121&data3=asdf&data3=sdfg">HttpServletRequest get(동명 복수데이터)</li>
</ul>

<form action="t2" method="post">
    <h3>HttpServletRequest post (동명 복수데이터)</h3>
    data1 : <input type="text" name="data1"/>
    <br/>
    data2 : <input type="text" name="data2"/>
    data3 1121 : <input type="checkbox" name="data3" value="1121"/>
    data3 1122 : <input type="checkbox" name="data3" value="1122"/>
    data3 1123 : <input type="checkbox" name="data3" value="1123"/>
    <button type="submit">submit</button>
</form>

<%-- WebRequest --%>
<a href="t3?data1=mynameis&data2=van&data3=deep&data3=dark&data3=fantasy">WebRequest</a>

<%-- PathVariable --%>
<a href="t4/100/200/300/400/500">PathVariable</a>

<%-- RequestParam --%>
<a href="t5?data1=100&data2=200&data3=300&data3=400">RequestParam</a>

</body>
</html>
