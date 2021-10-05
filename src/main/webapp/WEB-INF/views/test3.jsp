<%--
  Created by IntelliJ IDEA.
  User: KDD
  Date: 2021-10-01-0001
  Time: 오후 7:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TEST3</title>
</head>
<body>
    <h1>TEST3</h1>
    <img src="img/h.jpg"/>
</body>


<%--
    Model 역시 HttpServletRequest 와 마찬가지로 request 에 데이터를 담아 전송하기 떄문에
    데이터를 불러올 때에는, requestScope.데이터명 으로 불러온다.
--%>
<div>
    <span>${requestScope.data1}년</span>
    <span>11월 21일</span>
    <span>${requestScope.data2}은 오랜 지병이었던 고혈압으로 쓰러졌다.</span>
</div>

</html>
