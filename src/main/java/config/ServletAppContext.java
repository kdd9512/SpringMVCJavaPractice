package config;

import interceptor.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.*;

// Spring MVC 프로젝트에 관련된 설정을 하는 클래스.
@Configuration
// Controller 어노테이션이 세팅되어 있는 클래스를 Controller 로 등록한다.
@EnableWebMvc

// Scan 할 패키지 지정
//@ComponentScan("controller.GetReqAndPostReq")
//@ComponentScan("controller.HttpServletRequestTest")
//@ComponentScan("controller.GetParamObject")
//@ComponentScan("controller.ViewResolver")
//@ComponentScan("controller.CommandObj")
//@ComponentScan("controller.CustomFormTag")
//@ComponentScan("controller.FormElement1")
//@ComponentScan("controller.FormElement2")
//@ComponentScan("controller.RedirectForward")
//@ComponentScan("controller.RequestScope")

//@ComponentScan("controller.RequestScopeBeanJava")
//@ComponentScan("controller.RequestScopeBeanJava.beans")

//@ComponentScan("controller.SessionScope")

//@ComponentScan("controller.SessionScopeBeanJava")
//@ComponentScan("controller.SessionScopeBeanJava.beans")

//@ComponentScan("controller.ApplicationScope")

//@ComponentScan("controller.ApplicationScopeJava")
//@ComponentScan("controller.ApplicationScopeJava.beans")

//@ComponentScan("controller.Cookie")

//@ComponentScan("controller.Properties")
//@ComponentScan("controller.MessageJava")
//@ComponentScan("controller.Validate")
//@ComponentScan("controller.ValidationMsg")
//@ComponentScan("controller.Jsr303")
//@ComponentScan("controller.Jsr380")
//@ComponentScan("controller.CustomValidator")

@ComponentScan("controller.InterceptorJava")
public class
ServletAppContext implements WebMvcConfigurer {

    // Controller 의 메서드가 반환하는 jsp 의 이름 앞/뒤의 경로와 확장자를 붙혀주도록 설정.
    // 이 작업을 통해 경로상에서 반복되는 부분을 입력하지 않아도 된다.
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        WebMvcConfigurer.super.configureViewResolvers(registry);
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    // 정적 파일의 경로를 매핑.
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        WebMvcConfigurer.super.addResourceHandlers(registry);
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }


    // Properties 파일을 Message 로 등록.
    @Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();

        // MessageJava 예제.
        // 경로를 작성한다. 단, 확장자인 .properties 는 제외한다.

        // res.setBasename("/WEB-INF/properties/msgprop1");
//        res.setBasenames("/WEB-INF/properties/msgprop1",
//                         "/WEB-INF/properties/msgprop2");

//        ValidationMsg / JsrAnnotation 예제. 이하의 properties 를 사용한다.
        res.setBasename("/WEB-INF/properties/err_msg");

        return res;
    }

    // Interceptor 등록.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);

        TestInterceptor1 inter1 = new TestInterceptor1();
        TestInterceptor2 inter2 = new TestInterceptor2();
        TestInterceptor3 inter3 = new TestInterceptor3();
        TestInterceptor4 inter4 = new TestInterceptor4();
        TestInterceptor5 inter5 = new TestInterceptor5();
        TestInterceptor6 inter6 = new TestInterceptor6();

        InterceptorRegistration reg1 = registry.addInterceptor(inter1);
        InterceptorRegistration reg2 = registry.addInterceptor(inter2);
        InterceptorRegistration reg3 = registry.addInterceptor(inter3);
        InterceptorRegistration reg4 = registry.addInterceptor(inter4);
        InterceptorRegistration reg5 = registry.addInterceptor(inter5);
        InterceptorRegistration reg6 = registry.addInterceptor(inter6);

        // 관심사 등록.
        reg1.addPathPatterns("/t1");
        reg2.addPathPatterns("/t1");
        reg3.addPathPatterns("/t2");

        // 복수의 관심사 등록.
//        reg4.addPathPatterns("/t1");
//        reg4.addPathPatterns("/t2");
        reg4.addPathPatterns("/t1","/t2");
        reg5.addPathPatterns("/sub1/t3","/sub1/t4");

        // * : any
//        reg6.addPathPatterns("/*");
//        reg6.addPathPatterns("/sub1/*");

        // 모든 주소를 관심사로 등록.
        reg6.addPathPatterns("/**");

        // 제외할 관심사.
        reg6.excludePathPatterns("/");
    }
}
