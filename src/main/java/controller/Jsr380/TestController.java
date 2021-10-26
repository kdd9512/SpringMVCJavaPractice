package controller.Jsr380;

import controller.Jsr380.beans.JsrBean2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TestController {

    @GetMapping("input_data")
    public String inputData(JsrBean2 jsrBean2) {

        return "input_data";
    }

    @PostMapping("input_prop")
    public String inputProp(@Valid JsrBean2 jsrBean2,
                            BindingResult result) {
        if (result.hasErrors()) {
            return "input_data";
        }
        return "input_success";
    }
}
