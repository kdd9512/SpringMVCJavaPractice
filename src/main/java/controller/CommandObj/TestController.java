package controller.CommandObj;

import controller.CommandObj.beans.DataBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

    // Command Object. 커맨드 객체.
    // 클라이언트가 전달해 주는 파라미터 데이터를 주입받기 위해 사용하는 객체.
    // 커맨드 객체는 자동으로 HttpServletRequest 에 담겨 jsp 로 전달된다.
    // 이 때, 저장되는 이름은 클래스의 이름으로 결정된다. (단, 맨 앞글자는 소문자로 변환)
    // 아래같은 경우 AppliScopeBean 이 Command Object 이므로, dataBean 이 저장되는 이름이 된다.
    @PostMapping("t1")

    // AppliScopeBean 에 입력된 데이터들을 가져와서 파라메터로 만들겠다는 의미.
    // @ModelAttribute 는 생략이 가능하다. GetParamObject 의 TestController 참고.
    // public String test1(@ModelAttribute AppliScopeBean bean) {

    // 이하와 같이 이름을 임의로 지정해 줄 수도 있다.
    public String test1(@ModelAttribute("t1Value") DataBean bean) {

//        System.out.println("data1 : " + bean.getData1());
//        System.out.println("data2 : " + bean.getData2());

        return "test1";
    }
}
