<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RESULT</title>
</head>
<body>
<%-- requestScopeBeanJava 예제 결과출력 --%>
<%--    <h1>result</h1>--%>
<%--    <h2>reqBean1.data1 : ${requestScope.reqBean1.data1}</h2>--%>
<%--    <h2>reqBean1.data2 : ${requestScope.reqBean1.data2}</h2>--%>

<%--    <h2>reqBean2.data3 : ${requestScope.reqBean2.data3}</h2>--%>
<%--    <h2>reqBean2.data4 : ${requestScope.reqBean2.data4}</h2>--%>

<%--    <h2>reqBean3.data5 : ${requestScope.reqBean3.data5}</h2>--%>
<%--    <h2>reqBean3.data6 : ${requestScope.reqBean3.data6}</h2>--%>

<%--    <h2>reqBean4.data7 : ${requestScope.reqBean4.data7}</h2>--%>
<%--    <h2>reqBean4.data8 : ${requestScope.reqBean4.data8}</h2>--%>


<%-- SessionScope 예제 결과출력 --%>

<h1>result</h1>
<%-- sessionScope 를 이용하여 session 영역에 접근한다. --%>
<h3>data1 : ${sessionScope.data1}</h3>

</body>
</html>
