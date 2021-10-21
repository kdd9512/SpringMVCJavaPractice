# 유효성 검사(validate)

* JSR-303 규격의 유효성 검사 라이브러리와 hibernate 를 이용하여  
  코드의 유효성 검사.
  
  * @Size(min,max) : String 값의 최소(min)/최대(max) 길이를 결정한다.
  * @Max : int 값의 최대치를 결정한다.


* @Valid  
  * Controller 의 메서드에서 주입받는 Bean 에 설정하여 유효성검사를 실시한다.
  * 유효성 검사 결과를 사용하려면 **"BindingResult"** 객체를 주입받아야 한다.  
    이 객체에는 유효성 검사를 실행한 결과 정보가 담기며 사용자 입력값에 문제가 있는지 
    확인할 수 있다.