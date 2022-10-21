<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<%-- 커스텀 폼 태그를 이용하기 위한 taglib 을 추가한다. --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>TEST2</h1>
<img src="img/g.gif" style="width: 30%; height: 50%"/>
<div>
    <a href="/">HOME</a>
    <a href="t1">t1 이동.</a>
    <a href="t1/sub1">t1 의 sub 이동</a>
</div>

<%--
    HttpServletRequest 로 전송한 데이터를 출력.
    데이터는 ModelAndView 가 갖고있는 request 에 담겨있다
    그렇기 때문에 데이터는 param.데이터명 이 아니라 requestScope.데이터명 으로 출력한다.
    생략도 가능하나, 경로를 확실히 해 두는 것이 좋다.
--%>
<%--<div>--%>
<%--    <span>${requestScope.data1}년</span>--%>
<%--    <span>${requestScope.data2}일</span>--%>
<%--    <span>김두한은 오랜 지병이었던 고혈압으로 쓰러졌다.</span>--%>
<%--</div>--%>


<%-- Custom Form Tag 예제--%>

<form:form modelAttribute="dataBean" action="result">
    <%-- <input id="user_name" name="user_name"
                type="text" value="AppliScopeBean 에서 입력했던 그 값"/> 의 형태가
         자동으로 만들어진다.
   --%>
    이름 : <form:input path="user_name"/><br/>
    ID : <form:input path="user_id"/><br/>

    <%-- ** 이 방법을 사용하면 페이지 소스 확인 시
         비밀번호가 노출될 우려가 있기 때문에 기본적으로
         password 는 값이 존재하더라도 넘어오지 않는다.
     --%>
<%--    비밀번호 : <form:password path="user_pw"/><br/>--%>

    <%-- 굳이 입력되어 있는걸 필요로 한다면 이하와 같이 코드를 수정한다.
         단 페이지 소스 확인 시, 비밀번호가 노출된다.
    --%>
    비밀번호 : <form:password path="user_pw" showPassword="true"/><br/>
    우편번호 : <form:input path="user_postcode"/><br/>
    주소1 : <form:input path="user_add1"/><br/>
    주소2 : <form:input path="user_add2"/><br/>
    <button type="submit">submit</button>
</form:form>


<%--
     SessionScope
    session 은 session 을 생성했던 브라우저 내에서만 저장된다.
    같은 주소로 새 브라우저를 띄운다고 같은 세션을 이용할 수 없다는 얘기.
--%>
<%--<p>세션영역에 저장 완료..</p>--%>




</body>
</html>
