package controller.ApplicationScope;

import controller.ApplicationScope.beans.DataBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    // ServletContext 는 자동주입이 가능하다.
    // 여기서 자동주입을 해 놓으면 이하 Bean 에서 매번 새로 부를 필요가 없어진다.
    @Autowired
    ServletContext app;

    @Autowired
    DataBean bean1;


    @GetMapping("t1")
//    public String test1(HttpServletRequest req){
//      ServletContext app = req.getServletContext();

    public String test1() {
        app.setAttribute("data1", "string1");

        bean1.setData2("string2");
        app.setAttribute("bean1",bean1);
        return "test1";
    }


    @GetMapping("result")
//    public String result1(HttpServletRequest req){
//        ServletContext app = req.getServletContext();

    public String result1() {
        String data1 = (String) app.getAttribute("data1");
        DataBean bean1 = (DataBean) app.getAttribute("bean1");


        System.out.printf("data1 : %s\n", data1);

        System.out.printf("bean1 : %s\n",(String) bean1.getData2());

        return "result";
    }


}
