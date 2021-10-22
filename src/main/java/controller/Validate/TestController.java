package controller.Validate;

import controller.Validate.beans.ValidateBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TestController {

    @GetMapping("input_data")
    public String inputData(){

        return "input_data";
    }

    @PostMapping("input_prop")
    // Bean 의 이름이 ValidateBean 이므로 jsp 상에서 찾을 때에는 validateBean 으로 찾아야 한다.

    // @Valid : Controller 의 메서드에서 주입받는 Bean 에 설정하여 유효성검사를 실시한다.
    // 검사에 통과하면 값을 넘기고, 그렇지 않다면 400 에러(잘못된 요청) 를 발생시킨다.
    public String inputProp(@Valid ValidateBean validateBean,
                            BindingResult result){

//        System.out.printf("data1 : %s\n", validateBean.getData1());
//        System.out.printf("data2 : %d\n", validateBean.getData2());

//        System.out.printf("BindingResult : %s\n", result);

        // 유효성 검사에서 위반된 부분이 있다면 이하를 실행.
        if (result.hasErrors()) {
            for (ObjectError obj : result.getAllErrors()) {
                System.out.printf("Message : %s\n",obj.getDefaultMessage());
                System.out.printf("code : %s\n", obj.getCode());
                System.out.printf("Object name : %s\n", obj.getObjectName());

                String [] codes = obj.getCodes();
                for (String c1 : codes) {
                    System.out.println(c1);
                }

                if (codes[0].equals("Size.validateBean.data1")) {
                    System.out.println("data1 은 2~10 글자를 담아야 합니다.");
                } else if (codes[0].equals("Max.validateBean.data2")) {
                    System.out.println("data2 는 1000 이하의 값을 담아야 합니다.");
                }

                System.out.println("----------------------------------------------------------");
            }
            return "input_data";
        }

        return "input_success";
    }

}
