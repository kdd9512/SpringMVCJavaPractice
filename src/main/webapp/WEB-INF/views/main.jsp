<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h1>Hell, World!</h1>
<img src="img/e.jpg">

<%-- GET /POST 요청방식 예제 --%>
<%--<div>--%>
<%-- GET 방식 --%>
<%--    <a href="t1">t1 이동.</a>--%>
<%--    <a href="t2">t2 이동.</a>--%>
<%--    <a href="t3">t3 get</a>--%>

<%-- GET/POST 둘 다 받을 수 있는 test5 메서드를 이용한다.--%>
<%--    <a href="t4">t4 get/post hybrid</a>--%>

<%-- POST 방식 --%>
<%--    <form action="t3" method="post">--%>
<%--        <button type="submit">post1 post</button>--%>
<%--    </form>--%>

<%-- GET/POST 둘 다 받을 수 있는 test5 메서드를 이용한다.--%>
<%--    <form action="t4" method="post">--%>
<%--        <button type="submit">get/post hybrid</button>--%>
<%--    </form>--%>
<%--</div>--%>

<%-- HttpServletRequest / WebRequest / PathVariable 예제 --%>

<%--HttpServletRequest--%>
<%--<ul>--%>
<%--    <li href="t1?data1=1972&data2=1121">HttpServletRequest get</li>--%>
<%--    <li href="t1?data1=1972&data2=1121&data3=asdf&data3=sdfg">HttpServletRequest get(동명 복수데이터)</li>--%>
<%--</ul>--%>

<%--<form action="t2" method="post">--%>
<%--    <h3>HttpServletRequest post (동명 복수데이터)</h3>--%>
<%--    data1 : <input type="text" name="data1"/>--%>
<%--    <br/>--%>
<%--    data2 : <input type="text" name="data2"/>--%>
<%--    data3 1121 : <input type="checkbox" name="data3" value="1121"/>--%>
<%--    data3 1122 : <input type="checkbox" name="data3" value="1122"/>--%>
<%--    data3 1123 : <input type="checkbox" name="data3" value="1123"/>--%>
<%--    <button type="submit">submit</button>--%>
<%--</form>--%>

<%-- WebRequest --%>
<%--<a href="t3?data1=mynameis&data2=van&data3=deep&data3=dark&data3=fantasy">WebRequest</a>--%>

<%-- PathVariable --%>
<%--<a href="t4/100/200/300/400/500">PathVariable</a>--%>

<%-- RequestParam --%>
<%--<a href="t5?data1=100&data2=200&data3=300&data3=400">RequestParam</a>--%>




<%-- GET Parameter Object --%>
<%--<ul>--%>
<%--
파라메터를 전송한다.
** 데이터가 자동으로 parsing 되지 않는점을 주의.
--%>
<%--    <li>--%>
<%--        <a href="t1?data1=1972&data2=1121">--%>
<%--            t1 param Obj GET</a>--%>
<%--    </li>--%>
<%--
동명의 복수 개의 파라메터를 삽입.
같은 이름의 데이터가 복수 개 주입될 경우, 가장 처음 주입된 데이터만 보존된다.
--%>
<%--    <li>--%>
<%--        <a href="t1?data1=1972&data2=1121&data3=1122&data3=1123">--%>
<%--            t1 param Obj GET(동명복수 데이터 data3)</a>--%>
<%--    </li>--%>
<%--
@ModelAttribute 를 이용하면 @RequestParam 을 이용하여 파라메터를 주입했을 때와는 달리,
** 데이터가 자동으로 형변환 되어 적용된다.
단, Bean을 정의할 필요가 있다(private 변수 / getter / setter).
--%>
<%--    <li>--%>
<%--        <a href="t2?data1=1972&data2=1121&data3=1122&data3=1123">--%>
<%--            ModelAttribute 이용(동명복수 데이터 data3), 자동형변환 적용.</a>--%>
<%--    </li>--%>

<%--</ul>--%>



<%-- ViewResolver --%>
<%--
컨트롤러에서 전달받은 view 의 이름을 토대로 jsp 를 찾아 선택, jsp 데이터를 분석하여
 응답결과를 만들어 전달하는 요소.
 --%>

<%--
SpringMVC 는 HttpServletRequest 객체를 jsp 쪽으로 전달하는데,
ViewResolver 는 이를 이용하여 jsp 작업시 데이터를 이용할 수 있다.
 --%>
<hr/>
<%-- 데이터전송이 없는 요청. --%>
<a href="t1">t1 요청</a>
<hr/>
<%--
    parameter 를 이용하여 데이터를 전송
--%>
<a href="t1?data1=1972&data2=1121">t1 요청(파라메터 전송)</a>
<hr/>
<%--
    HttpServletRequest 이용하여 데이터를 전송.
--%>
<a href="t2">t2 요청(HttpServletRequest 이용)</a>
<hr/>
<%--
    Model 이용.
--%>
<a href="t3">t3 요청(Model 이용)</a>
<hr/>



</body>
</html>