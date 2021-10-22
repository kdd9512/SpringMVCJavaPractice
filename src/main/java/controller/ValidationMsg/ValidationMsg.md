# 에러 메세지 커스터마이즈

* 설정한 메세지가 없다면 JSR-303 에 설정되어 있는 기본 메세지가 사용된다 (default 값).


* 메세지를 커스터마이즈 할 수 없는 annotation 도 존재한다.


1. Properties 를 이용한 메세지 설정
    * 유효성 검사를 통과 못하면 JSP 에 오류 정보가 전달되는데 이 때, **"codes[0]"**   
      으로 값을 가져오면 이하의 양식으로 문자열을 가져올 수 있다.
      
      * **"annotation 이름(=error 종류).bean 이름. properties 이름"**
        
    * ex :  
      Size.dataBean1.data1 = 문자열 길이는 ~글자 입니다  
      Max.dataBean1.data2 = 값을 ~이하로 입력해주세요  
      


      custom tag 를 사용하여 jsp 상에서 출력 :  
      <spring:message code="${errors.getFieldError('data').codes[0]}"/>


2. 