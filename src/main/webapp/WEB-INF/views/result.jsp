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

<%--<h1>result</h1>--%>
<%-- sessionScope 를 이용하여 session 영역에 접근한다. --%>
<%--<h3>data1 : ${sessionScope.data1}</h3>--%>



<%-- SessionScopeBeanJava 예제 결과출력 --%>

<%--
    ** @SessionScope 는 브라우저에서 최초의 요청이 발생하면 단 한번만 Bean 을 주입시키는 역할만 할 뿐
    데이터를 저장해주지 않으므로, 데이터를 저장하고 싶다면 Model 클래스를 이용하여 데이터를 담아야 한다.
--%>
<h1>result</h1>

<%-- 이하의 코드는 데이터를 출력하지 못한다. --%>
<%--<h2>sessBean1.data1 : ${sessionScope.sessBean1.data1}</h2>--%>
<%--<h2>sessBean1.data2 : ${sessionScope.sessBean1.data2}</h2>--%>
<%--<h2>sessBean2.data3 : ${sessionScope.sessBean2.data3}</h2>--%>
<%--<h2>sessBean2.data4 : ${sessionScope.sessBean2.data4}</h2>--%>


<%-- Model 을 이용하여 데이터를 저장했으므로 (데이터는 request 영역에 있을 것.)
     requestScope 를 이용하여 데이터를 불러와야 한다.
--%>
<%--<h2>sessBean1.data1 : ${requestScope.sessBean1.data1}</h2>--%>
<%--<h2>sessBean1.data2 : ${requestScope.sessBean1.data2}</h2>--%>
<%--<h2>sessBean2.data3 : ${requestScope.sessBean2.data3}</h2>--%>
<%--<h2>sessBean2.data4 : ${requestScope.sessBean2.data4}</h2>--%>

<%--<h2>sessBean3.data5 : ${requestScope.sessBean3.data5}</h2>--%>
<%--<h2>sessBean3.data6 : ${requestScope.sessBean3.data6}</h2>--%>
<%--<h2>sessBean4.data7 : ${requestScope.sessBean4.data7}</h2>--%>
<%--<h2>sessBean4.data8 : ${requestScope.sessBean4.data8}</h2>--%>



<%-- ApplicationScope 예제 --%>

<%-- 이 방식은 md 파일에도 쓰여있듯, 브라우저에 관계 없이 데이터가 남는다. --%>
<%--<h2>ApplicationScope.data1 : ${applicationScope.data1}</h2>--%>
<%--<h2>ApplicationScope.data2 : ${applicationScope.bean1.data2}</h2>--%>


<%-- ApplicationScopeJava 예제 --%>

<%--
    applicationScope 는 서버 가동 시, 데이터를 주입하는 역할"만" 하며
    해당 영역에 데이터를 저장하거나 하지 않기 때문에,
    applicationScope 영역에서 Bean 내의 데이터를 찾아도 출력되지 않는다.
    데이터를 저장하고 싶다면 Model 클래스를 이용하여 데이터를 담아서 requestScope 영역에서 찾거나
    이전 applicationScope 예제에서 이용했던 HttpServletRequest 의 ServletContext 를 이용해야 한다.
--%>
<h2>appBean.data1 : ${requestScope.appBean.data1}</h2>
<h2>appBean.data2 : ${requestScope.appBean.data2}</h2>
<h2>appBean2.data3 : ${requestScope.appBean2.data3}</h2>
<h2>appBean2.data4 : ${requestScope.appBean2.data4}</h2>


</body>
</html>
