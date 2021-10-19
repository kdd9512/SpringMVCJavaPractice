package controller.MessageJava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class TestController {

    // MessageSource 를 주입받는다.

    @Autowired
    ReloadableResourceBundleMessageSource res;

    @GetMapping("t1")
    public String test1(Model model, Locale locale){

        String data1 = res.getMessage("prop1.data1",null,null);
        String data2 = res.getMessage("prop1.data2",null,null);

        // msgprop1 의 데이터 props2.data4 의 {} 부분에 세팅할 값 배열을 작성.
        // args = arguments
        Object [] args = {99, "김노인"};
        String data4 = res.getMessage("prop2.data4", args,null);

        String localData = res.getMessage("prop.localData", null, locale);


        System.out.printf("prop1.data1 : %s\n", data1);
        System.out.printf("prop1.data2 : %s\n", data2);
        System.out.printf("prop2.data4 : %s\n", data4);
        System.out.printf("prop.localData : %s\n", localData);

        // args 를 저장하기 위해 Model 객체를 이용한다.
        model.addAttribute("args", args);

        return "test1";
    }
}
