# Cookie

* 사용자 웹 브라우저에 저장되는 데이터  


* 요청이 발생하면 웹 브라우저는 쿠키에 저장된 정보를 서버에 전달.


* 응답 결과가 쿠키 정보라면, 웹 브라우저가 쿠키에 저장.


* 사용자 브라우저에 저장되기 때문에, 브라우저가 전달해 줄 때만   
  쿠키 정보를 사용할 수 있음.
  
# Cookie 저장.

* 서버 측 코드로 쿠키에 데이터를 저장하는 방법은 "없다".


* 그러므로, 브라우저로 보낼 응답 결과에 쿠키 저장정보를 담아  
브라우저에 쿠키를 저장해야 한다.
  

* Spring MVC 에서는 Servlet/JSP 에서 사용하는 방법으로   
  처리한다.