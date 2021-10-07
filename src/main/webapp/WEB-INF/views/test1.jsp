<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 커스텀 폼 태그를 이용하기 위한 taglib 을 추가한다. --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>test1</title>
</head>
<body>
<h1>TEST1</h1>
<img src="img/f.jpg"/>
<div>
    <a href="/">HOME</a>
    <a href="t1/sub1">sub 이동</a>
    <a href="t2">t2 이동.</a>
</div>
<%-- 파라메터로 넘어오는 데이터를 출력하고자 할 때는, param.데이터명 --%>
<%--<div>--%>
<%--    <span>${param.data1}년</span>--%>
<%--    <span>11월 21일</span>--%>
<%--    <span>${param.data2}은 오랜 지병이었던 고혈압으로 쓰러졌다.</span>--%>
<%--</div>--%>

<%-- request 에 담겨오는 경우는 requestScope.데이터명--%>
<%--<div>--%>
    <%--
        Command Object 를 이용할 경우 requestScope.Command Object명.데이터명
    --%>
<%--    <span>${requestScope.dataBean.data1}년</span>--%>
<%--    <span>11월 21일</span>--%>
<%--    <span>${requestScope.dataBean.data2}은 오랜 지병이었던 고혈압으로 쓰러졌다.</span>--%>
<%--    <br/>--%>

<%-- 임의로 지정한 Command Object 의 이름 t1Value 를 이용해야 정상적으로 출력되는 것을 확인할 수 있다. --%>
<%--    <span>${requestScope.t1Value.data1}년</span>--%>
<%--    <span>11월 21일</span>--%>
<%--    <span>${requestScope.t1Value.data2}은 오랜 지병이었던 고혈압으로 쓰러졌다.</span>--%>
<%--</div>--%>


<%-- Custom Form Tag 예제 1 --%>

<%-- Custom Form Tag 를 사용하지 않는 방법. jsp 에서 직접 해당 값을 끌어와서 적는다.
     물론 form 내부에 필요한 요소들을 전부 작성해야 한다.
--%>
<%--<form action="result" method="post">--%>
<%--    이름 : <input type="text" name="user_name" placeholder="이름"--%>
<%--                value="${requestScope.dataBean.user_name}"/><br/>--%>
<%--    id : <input type="text" name="user_id" placeholder="아이디"--%>
<%--                value="${requestScope.dataBean.user_id}"/><br/>--%>
<%--    password : <input type="password" name="user_pw" placeholder="비밀번호"--%>
<%--                      value="${requestScope.dataBean.user_pw}"/><br/>--%>
<%--    우편번호 : <input type="text" name="user_postcode" placeholder="우편번호"--%>
<%--                  value="${requestScope.dataBean.user_postcode}"/><br/>--%>
<%--    주소1 : <input type="text" name="user_add1" placeholder="주소1"--%>
<%--                 value="${requestScope.dataBean.user_add1}"/><br/>--%>
<%--    주소2 : <input type="text" name="user_add2" placeholder="주소2"--%>
<%--                 value="${requestScope.dataBean.user_add2}"/><br/>--%>
<%--    <button type="submit">submit</button>--%>
<%--</form>--%>



<%-- Custom Form Tag 예제 2 --%>

<%--
1. form:form - form 태그를 생성한다.

* modelAttribute : form 태그 내의 입력 요소들에 적용될 value 값을 가진 객체명.
  이 속성의 값은 실제 생성된 form 태그의 id 속성으로 결정된다. 생략 시, command 라는 값이 default 로 주어진다.

* action : 요청할 주소를 설정한다. 생략 시, 현재 페이지가 설정된다.

* method : 요청할 방식을 설정한다. 기본값은 post.
 --%>
<form:form modelAttribute="dataBean" action="result">

<%--
2. form:hidden - hidden 타입의 input 태그를 생성한다.
주로 사용자에게 입력받지 않아도 되는 혹은, 반드시 들어가야 하나 사용자가 손을 대선 안되는 값을 보내야 할 때 쓰일 것이다.

* path : 설정한 문자열은 id 와 name 속성으로 지정되며, model 값을 추출해  value 에 주입한다.
--%>
    <form:hidden path="d1"/>

<%--
3. form:button - submit 타입의 버튼을 생성한다.

* disabled : true 값을 넣는 것으로 버튼을 비활성화한다.
--%>
    <form:button>submit</form:button>


</form:form>


</body>
</html>
