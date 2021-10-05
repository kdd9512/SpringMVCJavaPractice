package controller.ViewResolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    // ModelAndView :
    // 데이터를 관리하는 Model 과 실제 화면상에 나타나는 부분을 관리하는 View 를 합친 것.
    // 사용자가 요청한 data 는 우선 request 영역에 담기게 되는데,내부적으로
    // ModelAndView 라는 객체를 만들어 jsp 의 전체 경로(뷰 네임 = 매핑에서 return 하는 jsp 파일 이름)를
    // 담고, 이 이름을 ViewResolver 가 받아 해당 jsp 파일을 찾고 분석하여 화면에 출력한다.
    @GetMapping("t1")
    public String test1() {
        return "test1";
    }


    @GetMapping("t2")
    public String test2(HttpServletRequest req) {

        // HttpServletRequest 를 이용하여 데이터명과 데이터를 설정한다.
        // 이 데이터는 모두 ModelAndView 에 담겨 ViewResolver 가 이용할 수 있게된다.
        req.setAttribute("data1", 1972);
        req.setAttribute("data2", 1121);

        return "test2";
    }

    // Model 클래스를 이용하여 데이터를 전송한다.
    // 여기서 선언한 데이터들은 전부 request 에 담겨 ModelAndView 로 간 후,
    // ViewResolver 가 이용하게 된다.
    @GetMapping("t3")
    public String test3(Model model){
        model.addAttribute("data1",1972);
        model.addAttribute("data2","김두한");

        return "test3";
    }


    // ModelAndView 클래스를 이용하여 주입된 데이터를 직접 이용할 수 있다.
    // 이 클래스는 view 의 이름까지 관리하기 때문에 이 경우 return 값은
    // 기존의 String 이 아니라
    @GetMapping("t4")
    public ModelAndView test4(ModelAndView mv) {

        // .addObject 이용하여 데이터를 넣는다.
        mv.addObject("data1", 1972);
        mv.addObject("data2", "심영");

        // view 의 이름을 결정하는 부분.
        // .setViewName 을 이용한다.
        mv.setViewName("test4");

        // 위의 정보들을 담은 ModelAndView 를 return 한다.
        return mv;
    }
}
