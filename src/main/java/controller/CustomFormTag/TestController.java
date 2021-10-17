package controller.CustomFormTag;

import controller.CustomFormTag.beans.DataBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TestController {

    @GetMapping("/t1")
    public String test1(DataBean bean){

        bean.setUser_name("심영");
        bean.setUser_id("19721121");
        bean.setUser_pw("19721121");
        bean.setUser_postcode("1972");
        bean.setUser_add1("주소1");
        bean.setUser_add2("주소2");

        return "test1";
    }

    @GetMapping("/t2")
    public String test2(DataBean bean){

        bean.setUser_name("김두한");
        bean.setUser_id("19721121");
        bean.setUser_pw("19721121");
        bean.setUser_postcode("1972");
        bean.setUser_add1("주소1");
        bean.setUser_add2("주소2");

        return "test2";
    }

    @GetMapping("/t3")
    public String test3(@ModelAttribute("testBean") DataBean bean){

        bean.setUser_name("의사양반");
        bean.setUser_id("19721121");
        bean.setUser_pw("19721121");
        bean.setUser_postcode("1972");
        bean.setUser_add1("주소1");
        bean.setUser_add2("주소2");

        return "test3";
    }

    @GetMapping("/t4")
    public String test4(Model md) {
        // AppliScopeBean 을 불러온다
        DataBean bean = new DataBean();

        // Model 객체에 값을 담는다.
        bean.setUser_name("상하이조");
        bean.setUser_id("19721121");
        bean.setUser_pw("19721121");
        bean.setUser_postcode("1972");
        bean.setUser_add1("주소1");
        bean.setUser_add2("주소2");

        // 위에서 Model 로 설정한 값들을 AppliScopeBean 에 담는다.
        // 여기서 설정한 이름은 Custom Form Tag 를 이용할 때, modelAttribute 에 입력해야 정상작동한다
        md.addAttribute("userModel", bean);

        return "test4";
    }

}
