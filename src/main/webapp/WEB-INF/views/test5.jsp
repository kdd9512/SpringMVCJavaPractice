<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TEST5</title>
</head>
<body>
    <h1>test5</h1>
    <img src="img/h.jpg"/>
<%--
    ModelAttribute 이용하여 AppliScopeBean 의 이름을 beanData 로 변경하였으므로(@ModelAttribute("beanData")),
    requestScope. 이후에는 beanData.getData1() 라고 입력해야 한다.
--%>
<%--    <p>bean.data1 : ${requestScope.beanData.getData1()}</p>--%>
<%--    <p>bean.data2 : ${requestScope.beanData.getData2()}</p>--%>


<%-- SessionScope 예제 --%>
<p>세션 저장 완료</p>

</body>
</html>
