# Restful API


* **응답결과를 데이터만으로 구성하여 클라이언트로 전달하는 서버**를 의미.  
이 때,  데이터만으로 구성된 응답결과를 **JSON 데이터** 라고 한다.


* 응답 결과는 HTML, CSS, JS 로 생성.


### @RestController

* @RestController 를 이용하여 mapping 하게 되면(GetMapping/PostMapping)   
return 값 자체를 브라우저로 전달하는 응답결과로 생성하여 전송한다.  
  즉, 기존 @Controller 가 return 값으로 JSP 를 전송했던 것과 달리, 
  return 값을 입력되어 있는 그대로 전송함.
  

    ex) 
    
    1. @Controller 의 경우...
    
    @GetMapping("t1")
    public String test1(){

        return "test1";
    }
    ** test1 이라는 jsp 파일에 데이터 주입하고 결과를 return.


    2. @RestController 의 경우...
    
    @GetMapping("t1")
    public String test1(){

        return "test1";
    }
    ** test1 을 그대로 return 한다.
    실제 결과를 받아보면 test1 이라고 덩그러니 쓰여진 페이지를 
    전달받게 된다.


* 이하의 라이브러리를 pom.xml 에 추가한다.


    추가할 라이브러리 : Jackson Databind

    <properties>
         <com.fasterxml.jackson.core-version>2.12.3</com.fasterxml.jackson.core-version>
    </properties>
    
    <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>${com.fasterxml.jackson.core-version}</version>
    </dependency>