# CustomValidator

* 기존 hibernate 를 이용한 검사(JSR-303, JSR-380) 이외에  
  추가적으로 유효성을 검사하고자 할 때 이용.

****

# Validator 인터페이스 구현.

****
**src.validator 참고.**

* supports :  
  유효성을 검사할 데이터를 가지고 있는 객체가 유효성 검사가 가능한지를 확인한다.
    * **bean 클래스이름.class.isAssignableFrom(aClass);**


    public boolean supports(Class<?> aClass) {
        return CvBeans.class.isAssignableFrom(aClass);
    }

* validate :  
  유효성 검사를 하는 메서드.

    * ValidationUtils
        * rejectIfEmpty(error 객체, "프로퍼티명", "지정할 에러코드이름") :  
          값이 비어있는지 확인. 공백을 문자로 인식.

        * rejectIfEmptyOrWhitespace(error 객체, "프로퍼티명", "지정할 에러코드이름") :  
          값이 비어있거나 공백으로만 구성되어 있는지 확인.

        * 입력값에 문제가 있다면 error 객체에 오류정보를 저장한다.  
          사용할 오류 메세지는 .properties 파일 내부에서  
          **지정한 에러코드이름.bean 객체명.프로퍼티명** 으로 구성.
          
    * rejectValue("프로퍼티명", "지정할 에러코드이름")  
        * 유효성 조건을 직접 만들 때 사용함.
          
        * if 문으로 유효성 검사를 하고, 위배될 때 rejectValue 에 오류정보를 저장함.
          
        * 입력값에 문제가 있다면 error 객체에 오류정보를 저장한다.  
          사용할 오류 메세지는 .properties 파일 내부에서  
          **지정한 에러코드이름.bean 객체명.프로퍼티명** 으로 구성.
****

# 컨트롤러에 등록.

**CustomValidator 내 TestController 참고.**

* @InitBinder annotation 을 이용하며 이하 code 를 적용.
    * 사용할 Validator 가 하나라면 setValidator  
      한 개 이상이라면, addValidators 를 사용한다.


    @InitBinder
    public void initBinder(WebDataBinder binder){
        CvBeansValidator validator = new CvBeansValidator();
        // binder.setValidator(validator);
        binder.addValidators(validator);
    }
