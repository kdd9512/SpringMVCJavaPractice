<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- Bean 의 이름이 ValidateBean 이므로 jsp 상에서 찾을 때에는 validateBean 으로 찾아야 한다.--%>
    <h1>success</h1>
<%--    <h2>data1 : ${validateBean.data1}</h2>--%>
<%--    <h2>data2 : ${validateBean.data2}</h2>--%>

<%-- ValidationMsg 예제 --%>
    <h2>data1 : ${validateBean2.data1}</h2>
    <h2>data2 : ${validateBean2.data2}</h2>

</body>
</html>
