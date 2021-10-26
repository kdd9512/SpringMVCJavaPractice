package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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
@ComponentScan("controller.Jsr380")
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
}
