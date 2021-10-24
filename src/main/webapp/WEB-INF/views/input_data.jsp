<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- if문을 사용하기 위한 taglib --%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%-- custom form tag 를 사용하기 위한 taglib --%>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>


<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="for" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>input data</h1>
<%--    <form action="input_prop" method="post">--%>
<%--        data1 : <input type="text" name="data1"><br/>--%>
<%--        <spring:hasBindErrors name="validateBean">--%>
<%--            <c:if test="${errors.hasFieldErrors('data1')}">--%>
<%--                ${errors.getFieldError('data1').defaultMessage}--%>
<%--            </c:if>--%>
<%--        </spring:hasBindErrors><br/>--%>
<%--        data2 : <input type="text" name="data2"><br/>--%>
<%--        <spring:hasBindErrors name="validateBean">--%>
<%--            <c:if test="${errors.hasFieldErrors('data2')}">--%>
<%--                ${errors.getFieldError('data2').defaultMessage}--%>
<%--            </c:if>--%>
<%--        </spring:hasBindErrors><br/>--%>
<%--        <button type="submit">submit</button>--%>
<%--    </form>--%>



<%-- ValidationMsg 예제 --%>
<%--
    err_msg.properties 에 등록한 prop 이름과 codes[0] 이 일치하면
    설정한 메세지를 출력하게끔 한 것.
--%>
<%-- jsp 활용한 버전. --%>
<%--    <form action="input_prop" method="post">--%>
<%--        data1 : <input type="text" name="data1"><br/>--%>
<%--        <spring:hasBindErrors name="validateBean2">--%>
<%--            <c:if test="${errors.hasFieldErrors('data1')}">--%>
<%--                <spring:message code="${errors.getFieldError('data1').codes[0]}"/>--%>
<%--            </c:if>--%>
<%--        </spring:hasBindErrors><br/>--%>
<%--        data2 : <input type="text" name="data2"><br/>--%>
<%--        <spring:hasBindErrors name="validateBean2">--%>
<%--            <c:if test="${errors.hasFieldErrors('data2')}">--%>
<%--                <spring:message code="${errors.getFieldError('data2').codes[0]}"/>--%>
<%--            </c:if>--%>
<%--        </spring:hasBindErrors><br/>--%>
<%--        <button type="submit">submit</button>--%>
<%--    </form>--%>

<%-- custom form tag 이용하여 작성. 결과는 위와 같다. --%>
<%--        <form:form action="input_prop"--%>
<%--                   modelAttribute="validateBean2" method="post">--%>
<%--            data1 : <form:input path="data1" type="text"/><br/>--%>
<%--                    <form:errors path="data1"/><br/>--%>
<%--            data2 : <form:input path="data2" type="text"/><br/>--%>
<%--                    <form:errors path="data2"/><br/>--%>
<%--            <form:button type="submit">submit</form:button>--%>
<%--        </form:form>--%>

<%-- custom form tag 이용하여 작성. --%>
<form:form action="input_prop"
           modelAttribute="jsrBean" method="post">
        data1 : <form:radiobutton path="data1" value="true"/> true
                <form:radiobutton path="data1" value="false"/> false <br/>
                <form:errors path="data1"/><br/>

        data2 : <form:radiobutton path="data2" value="true"/> true
                <form:radiobutton path="data2" value="false"/> false <br/>
                <form:errors path="data2"/><br/>

        data3 : <form:input path="data3" type="text"
                            placeholder="input number (100~1000)" /><br/>
                <form:errors path="data3"/><br/>

        data4 : <form:input path="data4" type="text"
                            placeholder="input number(100 미만 ~ 1000 초과)" /><br/>
                <form:errors path="data4"/><br/>

        data5 : <form:checkbox path="data5" value="check1"/>checkbox1<br/>
                <form:errors path="data5"/><br/>

        data6 : <form:checkbox path="data6" value="check2"/>checkbox1<br/>
                <form:errors path="data6"/><br/>

        <form:button type="submit">submit</form:button>
</form:form>

</body>
</html>
