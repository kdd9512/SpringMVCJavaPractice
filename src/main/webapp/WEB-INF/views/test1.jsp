<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test1</title>
</head>
<body>
<h1>TEST1</h1>
<img src="img/f.jpg"/>
<div>
    <a href="/">HOME</a>
    <a href="t1/sub1">sub 이동</a>
    <a href="t2">t2 이동.</a>
</div>
<%-- 파라메터로 넘어오는 데이터를 출력하고자 할 때는, param.데이터명 --%>
<div>
    <span>${param.data1}년</span>
    <span>${param.data2}일</span>
    <span>김두한은 오랜 지병이었던 고혈압으로 쓰러졌다.</span>
</div>
</body>
</html>
