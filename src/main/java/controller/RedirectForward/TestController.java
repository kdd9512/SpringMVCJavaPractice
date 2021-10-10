package controller.RedirectForward;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    /**
     * redirect
     * 서버가 클라이언트에 요청할 주소를 응답결과로 전달하는 것.
     * 클라이언트의 응답결과로 받은 요청주소를 직접 요청하게 된다.
     * 주소창의 주소는 변경되며, redirect 는 새 요청이 발생하는 것이므로
     * HttpServletRequest 객체는 소멸 후 재생성되며 HttpSession 객체는 그대로 유지된다.
     *
     * 아래와 같이 요청한 것은 t1 이지만, redirect 로는 sub1.jsp 를 요청하도록 되어있다.
     * 즉, 새 주소를 재요청하는 것. (t1 -> redirect:t1/sub1 -> sub/sub1.jsp)
     */

    @GetMapping("t1")
    public String test1() {
        return "redirect:t1/sub1";
    }


    /**
     * forward
     * 코드의 흐름을 서버상에서만 이동하는 것.
     * 브라우저는 흐름이 이동되었음을 감지할 수 없기 때문에 주소창의 주소는 그대로 유지된다.
     * 또한 redirect 와는 달리, HttpServletRequest 와 HttpSession 은 유지된다.
     *
     * 아래와 같이 요청한 것은 t2 인데 브라우저 상에서 주소는 /t2 인 채로
     * 실제 화면에 비추는 것은 sub2 가 된다.
     * 브라우저에게 요청 신호를 다시 보내는 것이 아니라 서버 내부에서 코드 흐름만 바뀌는 것.
     * (원래 t2 가야할것이 sub2 로 가는 것)
     */

    @GetMapping("t2")
    public String test2() {
        return "forward:t2/sub2";
    }

    @GetMapping("t3")
    public String test3() {
        return "test3";
    }

}
