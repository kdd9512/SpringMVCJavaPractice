# 예외처리

* 예외상황이 발생했을 시, error 메세지 대신 사용자가 알기 쉽도록  
처리하여 메세지 등으로 출력하는 것.
  * **@ExceptionHandler**  :  
    Controller 에서 이 annotation 을 이용하여 메서드를 정의,  
    해당 메서드가 반환하는 JSP 정보를 통해 응답결과 화면을 만들고  
    브라우저에 전달한다.  
    이 때, 사용하는 JSP 를 오류 페이지용으로 만들어야 한다.  
    @ExceptionHandler 는 Controller 마다 만들어야 한다.


    예시 :  
    // 처리할 오류를 괄호 안에 입력하고...
    @ExceptionHandler(java.lang.NullPointerException.class)  
    public String exceptionNullPointerGlobal(){

        // 어떻게 처리할지를 결정한다. 
        // 이 예시의 경우 이하의 페이지를 return 하게 설정했다.
        return "except_pg2";
    }
    

* Global ExceptionHandler
  
  * Controller 마다 발생 가능한 예외가 있다면 ExceptionHandler 를  
    한 번만 정의하여 사용할 수 있다.
    
  * Controller 에 정의한 ExceptionHandler 중 해당하는 오류가 없다면  
    Global ExceptionHandler 에서 해당하는 예외를 찾아 처리하게 된다.
    
  1. Class 생성 후, @ControllerAdvice annotation 이용,  
     클래스에 RuntimeException 을 상속(extends) 시킨 후   
     Class 내부에 @ExceptionHandler 를 만들어 Global 로 처리할  
     ExceptionHandler 메서드 작성.
     
  2. ServletAppContext.java 에 해당 Controller 가 담긴 폴더를  
     @ComponentScan 으로 추가.
     