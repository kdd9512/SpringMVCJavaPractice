# Properties


* 애플리케이션을 개발할 때 프로그램 실행 중 절대 변하지 않는 값이 있는데 
  (ex : 회원가입 양식 등),   
  Spring MVC 는 이러한 값들을 properties 파일에 작성하고 이를 가져다 
  사용할 수 있도록 하고 있다.


* 원래 문자는 아스키코드로 자동 변환되어 저장되기 때문에 바로 읽기가 곤란하므로,  
  **상단 메뉴바 파일** -> **설정(Preferences)** -> **에디터(Editor)** ->   
  **파일 인코딩(File Encodings)** 에서,
  **"명확한 Native 에서 ASCII 로의 전환(Transparent native-to-ascii conversion)"**
  을 체크하여 문자를 바로 읽을 수 있게 설정한다.


* properties 에 작성한 값을 JSP 에서 사용하고자 한다면,  
  **properties 파일을 Message 로 등록할 필요가 있다.**  
  자세한 내용은 MessageJava / Xml 예제 참고.

