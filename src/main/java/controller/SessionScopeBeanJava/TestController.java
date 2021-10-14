package controller.SessionScopeBeanJava;

import controller.SessionScopeBeanJava.beans.DataBean1;
import controller.SessionScopeBeanJava.beans.DataBean2;
import controller.SessionScopeBeanJava.beans.DataBean3;
import controller.SessionScopeBeanJava.beans.DataBean4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class TestController {

    // 브라우저에서 최초의 요청이 발생하면 단 한번만 주입된다.
    @Autowired
    DataBean1 sessBean1;

    @Resource(name = "sessBean2")
    DataBean2 sessBean2;

    @Autowired
    DataBean3 sessBean3;

    @Resource(name = "sessBean4")
    DataBean4 sessBean4;


    @GetMapping("t1")
    public String test1(){
        sessBean1.setData1("string1");
        sessBean1.setData2("string2");
        sessBean2.setData3("string3");
        sessBean2.setData4("string4");

        sessBean3.setData5("string5");
        sessBean3.setData6("string6");
        sessBean4.setData7("string7");
        sessBean4.setData8("string8");

        return "test1";
    }

    @GetMapping("result")
    public String result1(Model model){

        System.out.printf("sessBean1.data1 : %s\n", sessBean1.getData1());
        System.out.printf("sessBean1.data2 : %s\n", sessBean1.getData2());
        System.out.printf("sessBean2.data3 : %s\n", sessBean2.getData3());
        System.out.printf("sessBean2.data4 : %s\n", sessBean2.getData4());
        System.out.printf("sessBean3.data5 : %s\n", sessBean3.getData5());
        System.out.printf("sessBean3.data6 : %s\n", sessBean3.getData6());
        System.out.printf("sessBean4.data7 : %s\n", sessBean4.getData7());
        System.out.printf("sessBean4.data8 : %s\n", sessBean4.getData8());

        // sessionScope 에 값을 저장하기 위해 Model 클래스 이용.
        model.addAttribute("sessBean1", sessBean1);
        model.addAttribute("sessBean2", sessBean2);
        model.addAttribute("sessBean3", sessBean3);
        model.addAttribute("sessBean4", sessBean4);

        return "result";
    }

}
