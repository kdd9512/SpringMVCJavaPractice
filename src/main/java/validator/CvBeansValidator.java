package validator;

import controller.CustomValidator.beans.CvBeans;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CvBeansValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return CvBeans.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        //
        ValidationUtils.rejectIfEmpty(errors,"data2","error2");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"data3","error3");

        CvBeans bean = (CvBeans) o;

        String data2 = bean.getData2();
        String data3 = bean.getData3();

        if (data2.length() > 10) {
            errors.rejectValue("data2", "rejectVal1");
        }

        if (!data3.contains("@")) {
            errors.rejectValue("data3", "rejectVal2");
        }
    }
}
