# MyBatis

* JAVA 를 이용하여 DB와 연동하는 프로그램을 만드는 기술을 JDBC 라고  
하는데, MyBatis 는 JDBC 를 보다 쉽게 하기 위해 설계된 라이브러리이다.
  

* 추가해야 할 라이브러리 / Repository 목록.
    * DB 드라이버 jar  
      (이 예제의 경우 MariaDB)
    * spring jdbc
    * dbcp
    * mybatis
    * mybatis-spring
    * **MariaDB JDBC Repository (pom.xml 참고)** 
  

# 기본 세팅


1. DB 접속에 필요한 정보를 가지는 .properties 파일을 작성한다.  
보안상 url/id/비밀번호 를 노출하는건 좋지 않기 때문.

    
    ex) .properties 파일 내용 예시.
    db.drv = 드라이브
    db.url = url
    db.usr = 유저ID 
    db.pwd = 비밀번호


2. Mapper Interface 를 작성한다.  
이 파일 내에는 쿼리문이 들어간다.
   

    ex) Mapper Interface 작성 예시
    public interface MapperInterface {

        @Insert("insert into MVC_test (data1, data2, data3) values (#{data1},#{data2},#{data3})")
        void insert_data(myBatisBean bean);

        @Select("select * from MVC_test")
        List<myBatisBean> select_data();

    }


3. ServletAppContext.java 내에 BasicDataSource 메서드를 작성한다. 
   이 메서드는 접속 정보를 관리하는 객체이다.  
   **(중요) .properties 파일을 읽어올 수 있도록 ServletAppContext 클래스에 "@PropertySource" annotation 을 이용하여  
   .properties 파일의 경로를 반드시 설정해준다.**   


      ex1) PropertySource 설정 예시.
        @PropertySource("/WEB-INF/properties/database.properties")
        public class ServletAppContext implements WebMvcConfigurer { 

            // 프로퍼티의 DB 정보 호출.
            @Value("${db.drv}")
            private String dbDriver;
            
            @Value("${db.url}")
            private String dbUrl;
            
            @Value("${db.usr}")
            private String dbUserID;
            
            @Value("${db.pwd}")
            private String dbPassword;
            
            ... 
        }

      
      ex2) BasicDataSource 예시.
        @Bean
        public BasicDataSource dataSource() {
            BasicDataSource src = new BasicDataSource();
            src.setDriverClassName(dbDriver);
            src.setUrl(dbUrl);
            src.setUsername(dbUserID);
            src.setPassword(dbPassword);

            return src;
        }


4. SqlSessionFactory Bean 을 정의한다.  
이 객체는 query 문과 서버 접속정보를 다루는 역할을 맡는다.


        ex) SqlSessionFactory 예시
        @Bean
        public SqlSessionFactory factory(BasicDataSource src) throws Exception {
            SqlSessionFactoryBean factoryBean  = new SqlSessionFactoryBean();
            factoryBean.setDataSource(src);
            SqlSessionFactory factory = factoryBean.getObject();
    
            return factory;
        }


5. MapperFactoryBean Bean 을 정의한다.  
여기서 주입한 Mapper 안에 있는 query 문을 실행한다.
   

      ex) MapperFactoryBean 예시
      @Bean
      public MapperFactoryBean<MapperInterface> testMapper(SqlSessionFactory factory)
            throws Exception {
        MapperFactoryBean<MapperInterface> factoryBean =
                new MapperFactoryBean<>(MapperInterface.class);

        factoryBean.setSqlSessionFactory(factory);

        return factoryBean;
      }


# 사용하기.


1. 서버에서 받은 data 를 주입할 Bean 생성.
    * **이 때, 서버의 컬럼명과 해당 컬럼의 데이터를 받을 변수의 이름이 완전히 일치해야 한다.**


2. 컨트롤러 내에서 Mapper 를 자동주입.  
    

    ex)
    @Autowired
    Mapper이름 local변수;


3. 매핑 시 자동주입한 Mapper 를 사용.  
   이 때, 해당 Mapper 안에 있는 쿼리문 중  
   원하는 쿼리문을 선택하여 Bean 주입(mapper.insert_data(bean)).


    ex)Controller 예시.
    @Controller
    public class TestController {

        @Autowired
        MapperInterface mapper;
    
        ...


        @PostMapping("input_prop")
        public String inputProp(myBatisBean bean) {
            mapper.insert_data(bean);
    
            return "input_success";
        }
    
        ...

    }
