package controller.RedirectForward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestSubController  {

    @GetMapping("t1/sub1")
    public String sub1() {
        return "sub/sub1";
    }

    @GetMapping("t2/sub2")
    public String sub2() {
        return "sub/sub2";
    }
}
