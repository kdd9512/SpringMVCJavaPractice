package config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.*;

// 이 java 파일은 xml 설정에서 web.xml 이 하던 역할을 수행하는 파일이다.
// SpringMVCPractice 프로젝트 web.xml 파일을 참고하면서 볼 것.
// WebApplicationInitializer 을 이용하는경우, 초기 세팅이 다소 복잡하지만 기능의 추가 및 삭제(확장성)가 용이하다.

//public class SpringConfigClass implements WebApplicationInitializer {
//
//    @Override
//    public void onStartup(ServletContext servletContext) throws ServletException {
//        System.out.println("Start onStartup...");
//
//        // Spring MVC 프로젝트 설정을 위해 작성하는 클래스의 객체를 생성한다.
//        AnnotationConfigWebApplicationContext servletAppContext = new AnnotationConfigWebApplicationContext();
//        servletAppContext.register(ServletAppContext.class);
//
//        // 요청발생시, 요청을 처리하는 서블릿을 DispatcherServlet 으로 설정해준다
//        DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
//        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", dispatcherServlet);
//
//        // 부가설정.
//        servlet.setLoadOnStartup(1);
//        servlet.addMapping("/");
//
//        // Bean 을 정의하는 클래스를 지정.
//        AnnotationConfigWebApplicationContext rootAppContext = new AnnotationConfigWebApplicationContext();
//        rootAppContext.register(RootAppContext.class);
//
//        // 리스너 설정.
//        ContextLoaderListener listener = new ContextLoaderListener(rootAppContext);
//        servletContext.addListener(listener);
//
//        // 파라미터 인코딩 설정.
//        FilterRegistration.Dynamic filter =
//                servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
//        filter.setInitParameter("encoding", "UTF-8");
//        filter.addMappingForServletNames(null,false,"dispatcher");
//
//    }
//}

// AbstractAnnotationConfigDispatcherServletInitializer 을 이용하는 경우

public class SpringConfigClass extends AbstractAnnotationConfigDispatcherServletInitializer {

    // DispatcherServlet 에 매핑할 요청 주소를 세팅한다.
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    // SpringMVC 프로젝트 설정을 위한 클래스 지정.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {ServletAppContext.class};
    }

    // 프로젝트에서 사용할 Bean 을 정의하기 위한 클래스를 지정.
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] {RootAppContext.class};
    }

    // 파라미터 인코딩 필터 설정.
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
        encodingFilter.setEncoding("UTF-8");
        return new Filter[] {encodingFilter};
    }
}
