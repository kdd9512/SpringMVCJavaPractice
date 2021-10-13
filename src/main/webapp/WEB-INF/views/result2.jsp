<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RESULT2</title>
</head>
<body>
<%-- RequestScope 예제 결과출력 --%>
<%--    <h1>result2</h1>--%>
<%--    <h1>data2 : ${requestScope.data2}</h1>--%>

<%-- RequestScopeBeanJava 예제 결과출력 --%>
<%--    <h1>result2</h1>--%>
<%--    <h2>reqBean1.data1 : ${requestScope.reqBean2.data3}</h2>--%>
<%--    <h2>reqBean1.data2 : ${requestScope.reqBean2.data4}</h2>--%>

<%-- SessionScope 예제 --%>
<h1>result2</h1>
<h2>bean1.data1 : ${sessionScope.bean1.data1}</h2>
<h2>bean1.data2 : ${sessionScope.bean1.data2}</h2>

</body>
</html>
