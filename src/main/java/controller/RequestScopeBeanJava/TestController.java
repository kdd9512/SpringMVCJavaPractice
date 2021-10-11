package controller.RequestScopeBeanJava;

import controller.RequestScopeBeanJava.beans.DataBean;
import controller.RequestScopeBeanJava.beans.DataBean2;
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

    @GetMapping("t1")
    public String test1() {
        reqBean1.setData1("string1");
        reqBean1.setData2("string2");

        reqBean2.setData3("string3");
        reqBean2.setData4("string4");

        return "forward:result";
    }

    @GetMapping("result")
    public String result1(Model model){

        System.out.printf("reqBean1.data1 : %s\n", reqBean1.getData1());
        System.out.printf("reqBean1.data2 : %s\n", reqBean1.getData2());

        System.out.printf("reqBean2.data3 : %s\n", reqBean2.getData3());
        System.out.printf("reqBean2.data4 : %s\n", reqBean2.getData4());

        model.addAttribute("reqBean1", reqBean1);
        model.addAttribute("reqBean2", reqBean2);

        return "result";
    }


    @GetMapping("t2")
    public String test2(){
        reqBean2.setData3("string3");
        reqBean2.setData4("string4");

        return "forward:result2";
    }

    @GetMapping("result2")
    public String result2(Model model){
        System.out.printf("reqBean2.data3 : %s\n", reqBean2.getData3());
        System.out.printf("reqBean2.data4 : %s\n", reqBean2.getData4());

        model.addAttribute("reqBean2", reqBean2);

        return "result2";
    }

}
