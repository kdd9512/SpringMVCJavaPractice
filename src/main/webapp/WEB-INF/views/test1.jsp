<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 커스텀 폼 태그를 이용하기 위한 taglib 을 추가한다. --%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
<%--<form:form modelAttribute="dataBean" action="result">--%>

<%--
2. form:hidden - hidden 타입의 input 태그를 생성한다.
주로 사용자에게 입력받지 않아도 되는 혹은, 반드시 들어가야 하나 사용자가 손을 대선 안되는 값을 보내야 할 때 쓰일 것이다.

* path : 설정한 문자열은 id 와 name 속성으로 지정되며, model 값을 추출해  value 에 주입한다.
--%>
<%--    <form:hidden path="d1"/>--%>

<%--
3. form:input - text 타입의 input 태그를 생성한다.
일반적으로 사용되는 input 란을 생성할 때 사용될 것이다.

* path : 설정한 문자열은 id 와 name 속성으로 지정되며, model 값을 추출해  value 에 주입한다.
 --%>
<%--    <form:input path="d2"/>--%>

<%--
 4. form:password - password 타입의 input 태그를 생성.

 * path : 설정한 문자열은 id 와 name 속성으로 지정되며, model 값을 추출해  value 에 주입한다.
 * showPassword : password 타입의 input 태그를 CustomForm 으로 생성하면 bean 에 값이 담겨 있더라도
                  소스코드 상에 비밀번호가 노출되어 보안상으로 위험하기 때문에 일반적으로 값이 담기지 않는데,
                  해당 속성에 true 값을 넣어주면 이 제약을 해제하여 비밀번호가 입력되어 있게끔 설정할 수 있다.
 --%>
<%--    <form:password path="d3"/>--%>
<%--    <form:password path="d3" showPassword="true"/>--%>

<%--
5. form:textarea - textarea 타입의 input 태그를 생성한다. text 를 입력할 수 있는 input 보다 큰 창을 생성한다.

 * path : 설정한 문자열은 id 와 name 속성으로 지정되며, model 값을 추출해  value 에 주입한다.
--%>
<%--    <form:textarea path="d4"/>--%>


<%--
6. form:button - submit 타입의 버튼을 생성한다.

* disabled : true 값을 넣는 것으로 버튼을 비활성화한다.
--%>
<%--    <form:button>submit</form:button>--%>


<%--</form:form>--%>



<%-- Custom Form Tag 예제 3 --%>

<%--
    1. form:select - select 태그를 생성한다.

    * path : 설정한 문자열은 id 와 name 속성으로 지정되며, model 의 값을 추출하여 option 태그에서
             같은 value 값을 가진 option 태그를 찾아 선택된 상태로 태그를 생성한다.

    2. form:option/options  - select 안에서 사용될 option 태그를 하나 혹은 그 이상의 개수 생성한다.

    * items : option 태그들을 생성할 때 필요한 데이터가 담긴 list 나 배열.
--%>
<%--<hr/>--%>
<%--<form:form action="result" modelAttribute="dataBean">--%>
<%--    <form:select path="d1">--%>
<%--        <form:option value="무뇌봉동무">무뇌봉</form:option>--%>
<%--        <form:option value="임선규동무">임선규</form:option>--%>
<%--        <form:option value="황철동무">황철</form:option>--%>
<%--    </form:select>--%>
<%--    <hr/>--%>
<%--
    value 값과 select 태그에 선택지로 나타날 문자열이 같은 경우
    기준이 될 path 를 AppliScopeBean 의 private 변수를 부르고,
    item 에서는 Controller 내에서 정의한 Array 를 불러 처리한다.
    예제에서는 이렇게 직접 Array 를 임의로 제작해서 설정하나,
    실제 업무에서는 MyBatis 로 주입받는 data 의 Array 값을 그대로 받아, 좌표만 설정하는 것이 기본이다.
--%>
<%--    <form:select path="d2">--%>
<%--        <form:options items="${requestScope.dataList}"/>--%>
<%--    </form:select>--%>
<%--    <hr/>--%>
<%--    <form:select path="d3">--%>
<%--        <form:options items="${requestScope.dataList2}"/>--%>
<%--    </form:select>--%>
<%--    <hr/>--%>

    <%--
        value 값과 select 태그에 선택지로 나타날 문자열이 다른 경우.

        itemLabel : 태그 사이에 사용할 문자. 즉, select 태그에서 선택지로 표시되는 값.
        itemValue : 태그 사이에 사용할 값. 즉, select 태그에서 선택지가 실제로 갖는 값.
     --%>
<%--    <form:select path="d4">--%>
<%--        <form:options items="${requestScope.dataList3}"--%>
<%--                      itemLabel="key" itemValue="value"/>--%>
<%--    </form:select>--%>
    
<%-- 
    form:checkbox - checkbox 태그를 만든다.

    String[] chkList 내부의 내용은  공산당, 안할거야  이므로,
    이하의 checkbox 에도 같은 value 가 체크되어 있을 것이다.
 --%>
<%--    <hr/>--%>
<%--    <form:checkbox path="d5" value="공산당"/>공산당--%>
<%--    <form:checkbox path="d5" value="할거야"/>할거야--%>
<%--    <form:checkbox path="d5" value="안할거야"/>안할거야--%>
<%--    <hr/>--%>
<%--
    checkboxes 버전. 사용법은 상술한 select 와 같다.
    path 에는 참고할 변수의 이름을 입력하고 items 는 ${requestScope.Array 명} 을 넣어주면 된다.
    String [] dataList 에는 String[] chkList 와 일치하는 값이 없으므로 아무것도 체크되지 않을 것이다.
 --%>
<%--    <form:checkboxes path="d6" items="${requestScope.dataList}"/>--%>
<%--    <hr/>--%>
<%--
    ArrayList 역시 같은 방법으로 사용한다.
 --%>
<%--    <form:checkboxes path="d7" items="${requestScope.dataList2}"/>--%>
<%--    <hr/>--%>
<%--
    value 값과 checkbox 태그에 선택지로 나타날 문자열이 다른 경우. 역시 사용방법은 상술했던 방법과 같다.

    itemLabel : 태그 사이에 사용할 문자. 즉, select 태그에서 선택지로 표시되는 값.
    itemValue : 태그 사이에 사용할 값. 즉, select 태그에서 선택지가 실제로 갖는 값.
 --%>
<%--    <form:checkboxes path="d8" items="${requestScope.dataList3}"--%>
<%--                     itemLabel="key" itemValue="value"/>--%>
<%--</form:form>--%>


<%-- RedirectForward --%>

<%-- redirect
     서버가 클라이언트에 요청할 주소를 응답결과로 전달하는 것.
     클라이언트의 응답결과로 받은 요청주소를 직접 요청하게 된다.
     주소창의 주소는 변경되며, redirect 는 새 요청이 발생하는 것이므로
     HttpServletRequest 객체는 소멸 후 재생성되며 HttpSession 객체는 그대로 유지된다.

     아래와 같이 요청한 것은 t1 이지만, redirect 로는 sub1.jsp 를 요청하도록 되어있다.
     즉, 새 주소를 재요청하는 것. (t1 -> redirect:t1/sub1 -> sub/sub1.jsp)
--%>

<%--
     SessionScope
    session 은 session 을 생성했던 브라우저 내에서만 저장된다.
    같은 주소로 새 브라우저를 띄운다고 같은 세션을 이용할 수 없다는 얘기.
--%>
<%--<p>세션영역에 저장 완료..</p>--%>



<%--
    Properties & Message
    properties 에 작성한 값을 JSP 에서 사용하고자 한다면, MessageSource 객체를 이용하여 properties 파일을
    등록 하는 것으로 properties 파일을 Message 로 등록할 필요가 있다.
    이를 JSP 내에서 활용하려면 custom tag 가 필요한데, 이하의 taglib 을 추가한다.
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
--%>
<h2>prop1.data1 : <spring:message code="prop1.data1"/></h2>
<h2>prop1.data2 : <spring:message code="prop1.data2"/></h2>
<%--
    해당 property 는 일종의 양식이므로 양식에 들어갈 arguments 가 필요하다.
    이하와 같이 TestController 에서 정의했던 arguments 를 추가한다.
--%>
<h2>prop2.data4 : <spring:message code="prop2.data4" arguments="${args}"/></h2>
<h2>prop.localData : <spring:message code="prop.localData"/></h2>


</body>
</html>
