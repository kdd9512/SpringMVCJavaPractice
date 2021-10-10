<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RESULT5</title>
</head>
<body>
<%-- RequestScope 예제 결과출력을 위한 페이지--%>
    <h1>result5</h1>
    <h1>data1 : ${requestScope.beanData.getData1()}</h1>
    <h1>data2 : ${requestScope.beanData.getData2()}</h1>
</body>
</html>
