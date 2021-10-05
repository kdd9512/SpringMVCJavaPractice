<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>TEST2</h1>
<img src="img/g.gif" style="width: 30%; height: 50%"/>
<div>
    <a href="/">HOME</a>
    <a href="t1">t1 이동.</a>
    <a href="t1/sub1">t1 의 sub 이동</a>
</div>

<%--
    HttpServletRequest 로 전송한 데이터를 출력.
    데이터는 ModelAndView 가 갖고있는 request 에 담겨있다
    그렇기 때문에 데이터는 param.데이터명 이 아니라 requestScope.데이터명 으로 출력한다.
    생략도 가능하나, 경로를 확실히 해 두는 것이 좋다.
--%>
<div>
    <span>${requestScope.data1}년</span>
    <span>${requestScope.data2}일</span>
    <span>김두한은 오랜 지병이었던 고혈압으로 쓰러졌다.</span>
</div>
</body>
</html>
