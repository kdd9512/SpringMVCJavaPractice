package controller.CustomValidator;

import controller.CustomValidator.beans.CvBeans;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import validator.CvBeansValidator;

import javax.validation.Valid;

@Controller
public class TestController {

    @GetMapping("input_data")
    public String inputData(CvBeans cvBeans){

        return "input_data";
    }

    @PostMapping("input_prop")
    public String inputProp(@Valid CvBeans cvBeans,
                            BindingResult result){

    if (result.hasErrors()) {
        return "input_data";
    }
        return "input_success";
    }

    // Validator 설정.
    // 설정한 Validator 를 컨트롤러에 등록한다.
    // 사용할 Validator 가 하나면 setValidator / 한 개 이상이라면 addValidators
    // binder.addValidators(validators) 로 등록하면 모든 Validator 를 가져온다.
    @InitBinder
    public void initBinder(WebDataBinder binder){
        CvBeansValidator validator = new CvBeansValidator();
//        binder.setValidator(validator); 한 개 등록.
        binder.addValidators(validator);
    }
}
