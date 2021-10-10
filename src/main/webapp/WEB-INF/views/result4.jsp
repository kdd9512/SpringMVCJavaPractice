<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RESULT4</title>
</head>
<body>
<%-- RequestScope 예제 결과출력을 위한 페이지--%>
    <h1>result4</h1>
    <h1>data1 : ${requestScope.bean.getData1()}</h1>
    <h1>data2 : ${requestScope.bean.getData2()}</h1>
</body>
</html>
