<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RESULT3</title>
</head>
<body>
<%-- RequestScope 예제 결과출력을 위한 페이지--%>
<%--    <h1>result3</h1>--%>
<%--    <h1>data3 : ${requestScope.data3}</h1>--%>

<%-- SessionScope 예제 --%>
<h1>result2</h1>
<h2>bean2.data1 : ${sessionScope.bean2.data1}</h2>
<h2>bean2.data2 : ${sessionScope.bean2.data2}</h2>

</body>
</html>
