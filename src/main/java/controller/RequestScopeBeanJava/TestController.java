package controller.RequestScopeBeanJava;

import controller.RequestScopeBeanJava.beans.DataBean;
import controller.RequestScopeBeanJava.beans.DataBean2;
import controller.RequestScopeBeanJava.beans.DataBean3;
import controller.RequestScopeBeanJava.beans.DataBean4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class TestController {

    // RootAppContext 에서 정의한 Bean 을 자동주입한다. DataBean 타입으로 주입받고 이름을 reqBean1 로 설정.
    // Bean 주입은 요청이 있을 때만 주입된다.
    // 여기서 주의할 점은, @RequestScope 를 사용했기 때문에, 요청이 있을 때 bean 을 주입하겠단 의미이기 때문에,
    // request 에 값이 저장되지 않는다는 점이다.
    // 즉, 내부 요소를 활용하려면 Model 에 따로 담은다음 HttpServletRequest 로 불러와야 한다.

    @Autowired
    DataBean reqBean1;

    // 이름을 지정한 Bean 을 주입하기 위해 @Resource annotation 을 사용한다.
    @Resource(name = "reqBean2")
    DataBean2 reqBean2;

    // @Component 를 이용하여 Bean 주입. 이 방식을 이용하면 RootAppContext 에서 Bean 을 만들 필요가 없다.
    // ServletAppContext 에서 @ComponentScan 까지 해 주어야 하는 것을 잊지 말 것.
    @Autowired
    DataBean3 reqBean3;

    @Resource(name = "reqBean4")
    DataBean4 reqBean4;


    @GetMapping("t1")
    public String test1() {
        reqBean1.setData1("string1");
        reqBean1.setData2("string2");

        reqBean2.setData3("string3");
        reqBean2.setData4("string4");

        reqBean3.setData5("string5");
        reqBean3.setData6("string6");

        reqBean4.setData7("string7");
        reqBean4.setData8("string8");

        return "forward:result";
    }

    @GetMapping("result")
    public String result1(Model model){

        System.out.printf("reqBean1.data1 : %s\n", reqBean1.getData1());
        System.out.printf("reqBean1.data2 : %s\n", reqBean1.getData2());

        System.out.printf("reqBean2.data3 : %s\n", reqBean2.getData3());
        System.out.printf("reqBean2.data4 : %s\n", reqBean2.getData4());

        System.out.printf("reqBean3.data5 : %s\n", reqBean3.getData5());
        System.out.printf("reqBean3.data6 : %s\n", reqBean3.getData6());

        System.out.printf("reqBean4.data7 : %s\n", reqBean4.getData7());
        System.out.printf("reqBean4.data8 : %s\n", reqBean4.getData8());

        // 상술했듯이 새로운 request 가 발생했을 때 Bean 주입만 이루어지기 때문에 (request 영역에는 저장되지 않는다),
        // Model 클래스를 이용하여 값을 저장해야 한다.
        model.addAttribute("reqBean1", reqBean1);
        model.addAttribute("reqBean2", reqBean2);
        model.addAttribute("reqBean3", reqBean3);
        model.addAttribute("reqBean4", reqBean4);

        return "result";
    }


}
