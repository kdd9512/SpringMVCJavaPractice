# Application Scope

* 서버가 가동될 때 부터 서버가 종료되는 시점까지의 범위.  
  * 처음 요청이 발생하고 응답결과가 발생할 때 까지의 범위 : requestScope  
  * 브라우저에서 최초 요청이 발생하고 브라우저가 종료될 때 까지의 범위 : sessionScope


* Application Scope 동안 사용할 수 있는 메모리영역이 만들어지며  
  ServletContext 클래스 타입의 객체로 관리된다.  
  이 객체는 HttpServletRequest 객체로 추출이 가능하고,  
  Controller 에서 주입받을 수도 있다
  
    
* ServletContext 에 저장된 데이터, 객체는 서버가 종료되기 전까지   
  웹브라우저에 관계 없이 동일한 메모리 공간을 사용하게 된다.
