package controller.ViewResolver;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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


}
