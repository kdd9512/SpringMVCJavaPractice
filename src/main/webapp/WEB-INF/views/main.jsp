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
<%--<hr/>--%>
<%-- 데이터전송이 없는 요청. --%>
<%--<a href="t1">t1 요청</a>--%>
<%--<hr/>--%>
<%--
    parameter 를 이용하여 데이터를 전송
--%>
<%--<a href="t1?data1=1972&data2=1121">t1 요청(파라메터 전송)</a>--%>
<%--<hr/>--%>
<%--
    HttpServletRequest 이용하여 데이터를 전송.
--%>
<%--<a href="t2">t2 요청(HttpServletRequest 이용)</a>--%>
<%--<hr/>--%>
<%--
    Model 이용.
--%>
<%--<a href="t3">t3 요청(Model 이용)</a>--%>
<%--<hr/>--%>
<%--
    ModelAndView 이용하여 데이터를 직접 이용.
 --%>
<%--<a href="t4">t4 요청(ModelAndView 이용)</a>--%>



<%-- Command Object --%>

<%--<form action="t1" method="post">--%>
<%--    <p>data1</p>--%>
<%--    <input type="text" name="data1" placeholder="data1 value" />--%>
<%--    <p>data2</p>--%>
<%--    <input type="text" name="data2" placeholder="data2 value"/>--%>
<%--    <button type="submit">t1 정보 제출</button>--%>
<%--</form>--%>



<%-- CustomFormTag 1 --%>

<%--<br/>--%>
<%--<a href="t1">t1 CustomFormTag 1</a><br/>--%>
<%--<a href="t2">t2 CustomFormTag 1</a><br/>--%>
<%--<a href="t3">t3 CustomFormTag 1</a><br/>--%>
<%--<a href="t4">t4 CustomFormTag 1</a><br/>--%>


<%-- CustomFormTag 2 --%>

<%--<ul>--%>
<%--    <li>--%>
<%--        <a href="t1">t1 CustomFormTag 2</a>--%>
<%--    </li>--%>
<%--</ul>--%>


<%-- CustomFormTag 3 --%>

<%--<hr/>--%>
<%--<a href="t1">t1 CustomFormTag 3</a>--%>


<%-- RedirectForward --%>

<%-- redirect
     서버가 클라이언트에 요청할 주소를 응답결과로 전달하는 것.
     클라이언트의 응답결과로 받은 요청주소를 직접 요청하게 된다.
     주소창의 주소는 변경되며, redirect 는 새 요청이 발생하는 것이므로
     HttpServletRequest 객체는 소멸 후 재생성되며 HttpSession 객체는 그대로 유지된다.

     아래와 같이 요청한 것은 t1 이지만, redirect 로는 sub1.jsp 를 요청하도록 되어있다.
     즉, 새 주소를 재요청하는 것. (t1 -> redirect:t1/sub1 -> sub/sub1.jsp)
     패키지 내의 TestController 참고
--%>

<%-- forward
     코드의 흐름을 서버상에서만 이동하는 것.
     브라우저는 흐름이 이동되었음을 감지할 수 없기 때문에 주소창의 주소는 그대로 유지된다.
     또한 redirect 와는 달리, HttpServletRequest 와 HttpSession 은 유지된다.

     아래와 같이 요청한 것은 t2 인데 브라우저 상에서 주소는 /t2 인 채로
     실제 화면에 비추는 것은 sub2 가 된다.
     브라우저에게 요청 신호를 다시 보내는 것이 아니라 서버 내부에서 코드 흐름만 바뀌는 것.
     (원래 t2 가야할것이 sub2 로 가는 것)
     패키지 내의 TestController 참고
--%>

<%--<br/>--%>
<%--<a href="t1">t1 Redirect</a>--%>
<%--<a href="t2">t2 Forward</a>--%>



<%--  RequestScope --%>
<%--<br/>--%>
<%--<a href="t1">t1 RequestScope(HttpServletRequest 이용 redirect / forward)</a>--%>
<%--<br/>--%>
<%--<a href="t2">t2 RequestScope(Model 클래스 이용)</a>--%>
<%--<br/>--%>
<%--<a href="t3">t3 RequestScope(ModelAndView 클래스 이용)</a>--%>
<%--<br/>--%>
<%--<a href="t4">t4 RequestScope(bean 객체 이용)</a>--%>
<%--<br/>--%>
<%--<a href="t5">t5 RequestScope(ModelAttribute 이용)</a>--%>



<%-- @RequestScope annotation JAVA --%>

<%--<br/>--%>
<%--<a href="t1">t1 @RequestScope JAVA</a>--%>



<%-- SessionScope --%>

<%--<br/>--%>
<%--<a href="t1">t1 SessionScope (HttpSession)</a>--%>
<%--<br/>--%>
<%--<a href="t2">t2 SessionScope (redirect) </a>--%>
<%--<br/>--%>
<%--<a href="t3">t3 SessionScope (forward) </a>--%>
<%--<br/>--%>
<%--<a href="result">result SessionScope </a>--%>
<%--<hr/>--%>
<%--<br/>--%>
<%--<a href="t4">t4 SessionScope (@SessionAttribute)</a>--%>
<%--<br/>--%>
<%--<a href="result2">result2 SessionScope (@SessionAttribute)</a>--%>
<%--<hr/>--%>
<%--<br/>--%>
<%--<a href="t5">t5 SessionScope (@SessionAttributes)</a>--%>
<%--<br/>--%>
<%--<a href="result3">result2 SessionScope (@SessionAttributes)</a>--%>



<%-- SessionScopeJava --%>
<%--<br/>--%>
<%--<a href="t1">t1 SessionScopeJava </a><br/>--%>
<%--<a href="result">result SessionScopeJava</a><br/>--%>



<%-- ApplicationScope --%>
<%--<br/>--%>
<%--<a href="t1">t1 ApplicationScope</a><br/>--%>
<%--<a href="result">result ApplicationScope</a>--%>



<%-- ApplicationScopeJava --%>
<%--<br/>--%>
<%--<a href="t1">t1 ApplicationScopeJava</a><br/>--%>
<%--<a href="result">result ApplicationScopeJava</a>--%>



<%-- Cookie --%>
<%--<br/>--%>
<%--<a href="save_cookie">Cookie 저장</a><br/>--%>
<%--<a href="load_cookie">Cookie 저장결과 (spring 미사용)</a><br/>--%>
<%--<a href="load_cookie2">Cookie 저장결과 (spring 적용)</a><br/>--%>



<%-- Properties --%>
<%--<br/>--%>
<%--<a href="t1">Properties t1</a><br/>--%>



<%-- MessageJava --%>
<%--<br/>--%>
<%--<a href="t1">MessageJava t1</a><br/>--%>



<%-- Validate & ValidateMsg --%>
<%--<br/>--%>
<%--<a href="input_data">(ValidateMsg)input data</a><br/>--%>



<%-- JSR-303 --%>
<%--<br/>--%>
<%--<a href="input_data">(JSR-303) input data</a><br/>--%>



<%-- JSR-380 --%>
<%--<br/>--%>
<%--<a href="input_data">(JSR-380) input data</a><br/>--%>



<%-- CustomValidator --%>
<%--<br/>--%>
<%--<a href="input_data">(CustomValidator) input data </a>--%>



<%-- Interceptor --%>
<%--<br/>--%>
<%--<a href="t1">(Interceptor) t1</a><br/>--%>
<%--<a href="t2">(Interceptor) t2</a><br/>--%>

<%--<a href="sub1/t3">(Interceptor) sub1/t3</a><br/>--%>
<%--<a href="sub1/t4">(Interceptor) sub1/t4</a><br/>--%>


<%-- HandleException --%>
<%--<br/>--%>
<%--<a href="t1">(HomeController) t1</a><br/>--%>
<%--<a href="t2">(HomeController) t2</a><br/>--%>


<%--MyBatisJava--%>
<br/>
<a href="input_data">(MyBatisJava) input_data </a><br/>
<a href="read_data">(MyBatisJava) read_data </a><br/>

</body>
</html>
