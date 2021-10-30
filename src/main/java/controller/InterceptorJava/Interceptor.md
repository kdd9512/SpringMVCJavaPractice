# Interceptor?

* 요청주소에 관심을 갖고 요청이 발생하게 되면 요청 주소를 확인하여  
  Controller 의 메서드를 호출하기 전이나 후에 다른 메서드를 호출할 수  
  있도록 가로 채 가는 개념.
  
    * 요청 발생 시 호출되는 메서드의 코드에서 중복되는 부분이 있을 경우  
      Interceptor 를 이용하여 처리.
  
    * 로그인 여부 확인, 등급별 서비스 사용권한 확인 등의 작업에 사용.
    

# Interceptor 구현

* HandlerInterceptor 인터페이스를 구현하거나  
  HandlerInterceptorAdaptor(지원중단 예정) 를 상속받는 클래스를 만들고 이하의 메서드를 구현.
  
  * **preHandle** :  
    Controller 의 메서드가 호출되기 전에 호출된다.  
    

    return 값을 false 로 설정하면 이 메서드 이외에는 호출이 안되고 종료됨. 
    (요청 처리 진행이 중단)

  * **postHandle** :  
    Controller 의 메서드가 호출되고 난 후 view 처리를 하기 전에 호출된다.
  * **afterCompletion** :  
    view 처리까지 완료된 후, 응답결과가 브라우저로 전달되기 전에 호출된다.
    
* 메서드 호출 순서 (ServletAppContext.java 의 addInterceptors 메서드 참고할 것.)
  * preHandler 는 위에서부터 아래로 순차적으로 호출된다.
  * 이외(postHandle / afterCompletion) 는 아래에서부터 위로 호출된다.
  
# Pattern 등록 / 제외

* addPathPatterns
  * 한 개의 주소 등록 : **addPathPatterns("주소");**
  * 복수의 주소 등록 : **addPathPatterns("주소1","주소2"...);**
    
    
    "*" : 이름 하나를 의미하며 글자수/종류 등에 제한 없음.
    "?" : 글자 하나를 의미.
    "**" : 하위 이름까지 포함하여 글자수, 종류 등에 제한 없음.

    즉, 모든 주소 등록은 addPathPatterns("/**")

* excludePathPatterns  
  * 지정한 주소에서 Interceptor 는 동작하지 않는다.