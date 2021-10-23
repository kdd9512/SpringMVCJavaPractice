package controller.JsrAnnotation;

import controller.JsrAnnotation.beans.JsrBean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TestController {

    @GetMapping("input_data")
    // custom form 태그 고정을 위한 bean 주입. 그렇다고 이 method 에서 사용하지는 않는다.
    public String inputData(JsrBean jsrBean){

        return "input_data";
    }

    @PostMapping("input_prop")
    public String inputProp(@Valid JsrBean jsrBean,
                            BindingResult result){

        if (result.hasErrors()) {
            return "input_data";
        }
        return "input_success";
    }
}
