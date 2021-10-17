package controller.ApplicationScopeJava;

import controller.ApplicationScopeJava.beans.AppliScopeBean;
import controller.ApplicationScopeJava.beans.AppliScopeBean2;
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

    @GetMapping("t1")
    public String test1(){
        appBean.setData1("application(type)");
        appBean.setData2("scope(type)");

        appBean2.setData3("application(name)");
        appBean2.setData4("scope(name)");

        return "test1";
    }

    @GetMapping("result")
    public String result1(Model md){

        System.out.printf("appBean.data1 : %s\n", appBean.getData1());
        System.out.printf("appBean.data2 : %s\n", appBean.getData2());
        System.out.printf("appBean2.data3 : %s\n", appBean2.getData3());
        System.out.printf("appBean2.data4 : %s\n", appBean2.getData4());

        md.addAttribute("appBean",appBean);
        md.addAttribute("appBean2",appBean2);

        return "result";
    }

}
