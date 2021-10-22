package controller.ValidationMsg;

import controller.ValidationMsg.beans.ValidateBean2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TestController {

    @GetMapping("input_data")
    // 여기서 사용하지는 않으나, ValidateBean2 을 반드시 넣어줘야 한다.
    // input_data 는 Bean 이 저장되지 않은 상태에서 input_data 를 띄우려고 하면
    // 초기값이 없어서 오류가 발생하기 때문.
    public String inputData(ValidateBean2 validateBean2){

        return "input_data";
    }


    @PostMapping("input_prop")
    public String inputProp(@Valid ValidateBean2 validateBean2,
                            BindingResult result){

        if (result.hasErrors()){
            return "input_data";
        }
        return "input_success";
    }
}
