package config;

import controller.RequestScopeBeanJava.beans.DataBean;
import controller.SessionScopeBeanJava.beans.DataBean1;
import controller.SessionScopeBeanJava.beans.DataBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

// 프로젝트 작업 시, 사용할 Bean 을 정의하는 클래스.
@Configuration
public class RootAppContext {

    // DataBean 을 @Bean 으로 정의.
//    @Bean

//  @RequestScope 을 갖는 이 Bean 은 새 요청이 발생되었을 때 주입된다.
//    @RequestScope
//    public DataBean dataBean(){
//
//        return new DataBean();
//    }

//    @Bean("reqBean2")
//    @RequestScope
//    public DataBean2 dataBean2(){
//        return new DataBean2();
//    }


// SessionScopeBeanJava 예제

    // 이후 TestController 에서 자동주입할 것이므로, Bean 등록.

    @Bean
    @SessionScope
    public DataBean1 dataBean1(){
        return new DataBean1();
    }

    // 이름을 통해 주입.
    @Bean("sessBean2")
    @SessionScope
    public DataBean2 dataBean2(){
        return new DataBean2();
    }





}
