package controller.FormElement1;

import controller.FormElement1.beans.DataBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("t1")
    public String test1(DataBean bean) {

        bean.setD1("1972");
        bean.setD2("김두한");
        bean.setD3("1121");
        bean.setD4("김두한은 오랜 지병이었던 고혈압으로 쓰러졌다.");

        return "test1";
    }
}
