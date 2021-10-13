package controller.SessionScope;

import controller.SessionScope.beans.DataBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class TestController {


    @GetMapping("t1")
    // session 영역은 HttpServletRequest 로부터 추출한다. request 객체로부터 session 을 추출한다.
//    public String test1(HttpServletRequest req){

    //  상술한 HttpServletRequest 을 주입하여 session 을 사용할할 수도있지만, HttpSession 을 직접 주입할 수도 있다.
    public String test1(HttpSession sess){
//        HttpSession sess = req.getSession();

        sess.setAttribute("data1", "string1");

        return "test1";
    }

    @GetMapping("result")

    //  HttpServletRequest 을 이용하여 request 객체로부터 session 을 추출해 올 수도 있지만,
    //  아래처럼 HttpSession 을 직접 주입할 수도 있다.
    //  public String result1(HttpServletRequest req) {

    public String result1 (HttpSession sess) {
//        HttpSession sess = req.getSession();

        // 위에서 session 의 이름을 data1 으로 지정했으므로 getAttribute 할 때, data1 로 불러온다.
        String data1 = (String) sess.getAttribute("data1");

        System.out.printf("data1 : %s\n", data1);

        return "result";
    }

    // redirect 방식
    // browser 가 바뀌는 것이 아니라면 객체 내 데이터를 사용할 수 있다.
    @GetMapping("t2")
    public String test2(HttpSession sess){
        sess.setAttribute("data1", "string2");

        return "redirect:result";
    }

    // forward 방식
    // browser 가 바뀌는 것이 아니라면 객체 내 데이터를 사용할 수 있다.
    @GetMapping("t3")
    public String test3(HttpSession sess){
        sess.setAttribute("data1", "string3");

        return "forward:result";
    }


//  HttpSession 을 이용하여 데이터를 입력하고 session 을 만드는 방식이다.
    @GetMapping("t4")
    public String test4(HttpSession sess){
        DataBean bean1 = new DataBean();
        bean1.setData1("string4");
        bean1.setData2("string5");

        sess.setAttribute("bean1",bean1);
        return "test4";
    }


// SessionAttribute 은 session 에서 값을 추출할 수는 있어도 session 자체를 만들수는 없다
// 이하의 방식으로 bean 에 값을 입력하고 session 을 만들려고 하면 bean1 이라는 session 을 찾을 수 없다는 오류가 발생함.
// ** SessionAttribute 와 SessionAttribute"s" 는 다른 annotation 이므로 주의.
//    @GetMapping("t4")
//    public String test4(@SessionAttribute("bean1") DataBean bean1) {
//
//        bean1.setData1("string4");
//        bean1.setData2("string5");
//
//        return "test4";
//    }


//    이 방법은 HttpSession 을 이용하여 직접 추출하는 방식.
//    @GetMapping("result2")
//    public String result2(HttpSession sess) {

//        직접추출 방식 동작을 위한 부분은 이것만으로도 충분하다.
//        sess.getAttribute("bean1");

//        DataBean bean1 = (DataBean) sess.getAttribute("bean1");
//        System.out.printf("bean1.data1 : %s\n", bean1.getData1());
//        System.out.printf("bean1.data2 : %s\n", bean1.getData2());


    // @SessionAttribute 를 이용하여 request 객체에 주입된 session 을 이용할 수 있다.
    // ** SessionAttribute 와 SessionAttribute"s" 는 다른 annotation 이므로 주의.
    @GetMapping("result2")
    public String result2(@SessionAttribute("bean1") DataBean bean1) {

        System.out.printf("bean1.data1 : %s\n", bean1.getData1());
        System.out.printf("bean1.data2 : %s\n", bean1.getData2());

        return "result2";
    }

}
