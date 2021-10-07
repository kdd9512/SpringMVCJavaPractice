package controller.FormElement1;

import controller.FormElement1.beans.DataBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("t1")
    public String test1(DataBean bean) {


        return "test1";
    }
}
