package controller.RequestScope;

import controller.RequestScope.beans.DataBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @GetMapping("t1")
    public String test1(HttpServletRequest req){
        req.setAttribute("data1", "hell world");

        // redirect 를 하는 순간 재요청을 하게 되는데
        // 그 때 HttpServletRequest 객체가 소멸되었다가 재 생성되기 때문.
        // 데이터를 넘기고 싶다면 forward 를 사용해야 할 것.

//        return "redirect:result";
        return "forward:result";
    }

    @GetMapping("result")
    public String result(HttpServletRequest req){

        String data1 = (String)req.getAttribute("data1");
        // redirect 를 하게되면 data1 은 당연히 null 이 나온다.
        // redirect 를 하는 순간 재요청을 하게 되는데
        // 그 때 HttpServletRequest 객체가 소멸되었다가 재 생성되기 때문.
        // 데이터를 넘기고 싶다면 forward 를 사용해야 할 것.
        // forward 는 재요청하는 것이 아니기 때문.
        System.out.printf("data1 : %s\n", data1);
        return "result";
    }

    @GetMapping("t2")
    public String test2(Model model){
        model.addAttribute("data2","hell");

        return "forward:result2";
    }

    @GetMapping("result2")
//    Model 은 전달되지 않으므로 null 이 나온다
//    public String result2(Model model){

    public String result2(HttpServletRequest req){

        // ** Model 을 주입받아서 addAttribute 하면 request 객체에 저장된다.
        // 여기서 주의할 점은, Model 자체는 전달되지 않기 때문에 Model 의 값을 불러오려면
        // forward 때와 같이 HttpServletRequest 를 이용해야 한다는 점이다.

        // String data2 = (String)model.getAttribute("data2"); Model 은 전달되지 않으므로 null 이 나온다

        String data2 = (String)req.getAttribute("data2");
        System.out.printf("data2 : %s\n", data2);

        return "result2";
    }


    @GetMapping("t3")
    public ModelAndView test3(ModelAndView mv){

        mv.addObject("data3","hell, world!");
        mv.setViewName("forward:result3");

        return mv;
    }

    @GetMapping("result3")
    public String result3(HttpServletRequest req){

        // ** ModelAndView 을 주입받아서 addAttribute 하면 request 객체에 저장된다.
        // 여기서 주의할 점은, ModelAndView 자체는 전달되지 않기 때문에 ModelAndView 의 값을 불러오려면
        // forward 때와 같이 HttpServletRequest 를 이용해야 한다는 점이다.

        String data3 = (String) req.getAttribute("data3");
        System.out.printf("data3 : %s\n", data3);

        return "result3";
    }

    @GetMapping("t4")
    public String test4(Model model){
        DataBean bean = new DataBean();

        bean.setData1("WTH?");
        bean.setData2("WTF?");

        model.addAttribute("bean",bean);

        return "forward:result4";
    }

    @GetMapping("result4")
    public String result4(HttpServletRequest req){

        DataBean bean = (DataBean) req.getAttribute("bean");
        System.out.printf("bean.data1 : %s\n", bean.getData1());
        System.out.printf("bean.data2 : %s\n", bean.getData2());

        return "result4";

    }

    @GetMapping("t5")
    public String test5(@ModelAttribute("beanData") DataBean bean){
        bean.setData1("안되겠소");
        bean.setData2("쏩시다");

//        return "test5";
        return "forward:result5";
    }

    @GetMapping("result5")
    // 이 경우도 null 이 나온다.
    // forward 로 t5 에서 생성했던 bean 객체가 들어오긴 했으나,
    // 여기서 ModelAttribute 로 새로운 bean 객체가 주입되어
    // 기존 bean 에 덮어씌워져 기존 bean 이 삭제되어 버리기 때문이다.

//    public String result5(@ModelAttribute("beanData") DataBean bean){
    public String result5(HttpServletRequest req){

        // 상술한 것과 같은 문제가 생기기 때문에, 기존 bean 의 데이터를 불러오려면
        // bean 생성 시 request 에 저장되었던 값을 불러와야 한다.
        DataBean bean = (DataBean) req.getAttribute("beanData");
        System.out.printf("bean.data1 : %s\n", bean.getData1());
        System.out.printf("bean.data2 : %s\n", bean.getData2());

        return "result5";

    }


}
