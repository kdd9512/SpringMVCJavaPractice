package controller.ApplicationScopeJava;

import controller.ApplicationScopeJava.beans.AppliScopeBean;
import controller.ApplicationScopeJava.beans.AppliScopeBean2;
import controller.ApplicationScopeJava.beans.AppliScopeBean3;
import controller.ApplicationScopeJava.beans.AppliScopeBean4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class TestController {

    @Autowired
    AppliScopeBean appBean;

    @Resource(name = "appBean2")
    AppliScopeBean2 appBean2;

    // appBean3 과 appBean4 는 @Component 와 @ComponentScan 을 이용한 Bean 주입.
    @Autowired
    AppliScopeBean3 appBean3;

    @Resource(name = "appBean4")
    AppliScopeBean4 appBean4;

    @GetMapping("t1")
    public String test1(){
        appBean.setData1("application(type)");
        appBean.setData2("scope(type)");

        appBean2.setData3("application(name)");
        appBean2.setData4("scope(name)");

        appBean3.setData5("application(@Component)");
        appBean3.setData6("scope(@Component)");

        appBean4.setData7("application(@Component byName)");
        appBean4.setData8("scope(@Component byName)");

        return "test1";
    }

    @GetMapping("result")
    public String result1(Model md){

        System.out.printf("appBean.data1 : %s\n", appBean.getData1());
        System.out.printf("appBean.data2 : %s\n", appBean.getData2());
        System.out.printf("appBean2.data3 : %s\n", appBean2.getData3());
        System.out.printf("appBean2.data4 : %s\n", appBean2.getData4());
        System.out.printf("appBean3.data5 : %s\n", appBean3.getData5());
        System.out.printf("appBean3.data6 : %s\n", appBean3.getData6());
        System.out.printf("appBean4.data7 : %s\n", appBean4.getData7());
        System.out.printf("appBean4.data8 : %s\n", appBean4.getData8());

        md.addAttribute("appBean",appBean);
        md.addAttribute("appBean2",appBean2);
        md.addAttribute("appBean3",appBean3);
        md.addAttribute("appBean4",appBean4);

        return "result";
    }

}
