# Message

* properties 에 작성한 값을 JSP 에서 사용하고자 한다면,  
  **"MessageSource 객체를 이용하여 properties 파일을 등록"** 하는 것으로  
  properties 파일을 Message 로 등록할 필요가 있다.  
  또한, properties 파일을 Message 로 등록하면, 다국어 처리가 가능해진다.


* 일정 시간마다 한 번씩 갱신되는  
  **"ReloadableResourceBundleMessageSource"**  
  를 같이 사용한다.  
  이를 이용하면 원래 서버가 종료되지 않는 한 변하지 않는 값인 property 를,  
  서버를 내리지 않아도 수정된 내용을 반영시킬 수 있다.


* Message 로 등록된 데이터를 Java 코드에서 사용하려면  
**"MessageSource"** 를 주입받아 사용한다.  
  이 떄, Locale 을 지정하여 다국어 처리가 가능하다.
  

* Locale 은 언어 조건에 따라 적용할 properties 파일을 만들어  
  리소스 번들로 그룹화하고, **"각 언어 조건에 같은 이름, 다른 내용의 property"** 를 두는 것으로  
  브라우저의 언어에 따라 Controller 내에서 주입되었던 locale 클래스가 작동될 수 있도록 할 수 있다.  
  