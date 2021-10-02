package controller.GetReqAndPostReq;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

    @RequestMapping(value = "/t1", method = RequestMethod.GET)
    public String test1() {
        return "test1";
    }

    @RequestMapping(value = "/t2", method = RequestMethod.GET)
    public String test2() {
        return "test2";
    }

    // POST 방식을 사용하기 위한 매핑
    // 이 방식은 주로 어떤 양식에 데이터를 담아야 할 때(ex: 회원가입 등) 사용된다.
//    @RequestMapping(value = "/t3", method = RequestMethod.POST)
//    public String test3() { return "test3"; }

    // 같은 페이지라도 다른 방식으로 불러올 수 있다.
//    @RequestMapping(value = "/t3", method = RequestMethod.GET)
//    public String test4() { return "test4"; }

    // @RequestMapping(value = "/t3", method = RequestMethod.GET) 의 축약형
    @GetMapping("/t3")
    public String test3() {
        return "test3";
    }
    // @RequestMapping(value = "/t3", method = RequestMethod.POST) 의 축약형.
    @PostMapping("/t3")
    public String test4() {
        return "test4";
    }

    // 두 요청방식을 동시에 받을 수도 있다. 단 이 경우는 축약형을 사용하게 되면
    // 한 쪽의 return 값으로 다른 쪽을 호출해야 하기 때문에 불필요한 코드가 늘어나고 관리가 불편해지므로,
    // ** 두 요청방식을 사용할 경우에는 @RequestMapping 을 사용한다.
    @RequestMapping(value = "/t4", method = {RequestMethod.GET, RequestMethod.POST})
    public String test5() {
        return "test4";
    }
}
