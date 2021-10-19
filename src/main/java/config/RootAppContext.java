package config;

import controller.ApplicationScope.beans.DataBean;
import controller.ApplicationScopeJava.beans.AppliScopeBean;
import controller.ApplicationScopeJava.beans.AppliScopeBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

// 프로젝트 작업 시, 사용할 Bean 을 정의하는 클래스.
@Configuration
public class RootAppContext {

    // AppliScopeBean 을 @Bean 으로 정의.
//    @Bean

//  @RequestScope 을 갖는 이 Bean 은 새 요청이 발생되었을 때 주입된다.
//    @RequestScope
//    public AppliScopeBean dataBean(){
//
//        return new AppliScopeBean();
//    }

//    @Bean("reqBean2")
//    @RequestScope
//    public DataBean2 dataBean2(){
//        return new DataBean2();
//    }


// SessionScopeBeanJava 예제

    // 이후 TestController 에서 자동주입할 것이므로, Bean 등록.

//    @Bean
//    @SessionScope
//    public DataBean1 dataBean1(){
//        return new DataBean1();
//    }
//
//    // 이름을 통해 주입.
//    @Bean("sessBean2")
//    @SessionScope
//    public DataBean2 dataBean2(){
//        return new DataBean2();
//    }

//    @Bean
//    @ApplicationScope
//    public DataBean databean(){
//        return new DataBean();
//    }

    // 서버가 가동되면 한 번 주입되고 이후에는 주입되지 않음.

    // 타입을 통한 주입
//    @Bean
//    @ApplicationScope
//    public AppliScopeBean appliScopeBean() {
//        return new AppliScopeBean();
//    }

    // 이름을 통한 주입.
//    @Bean("appBean2")
//    @ApplicationScope
//    public AppliScopeBean2 appliScopeBean2() {
//        return new AppliScopeBean2();
//    }

}
