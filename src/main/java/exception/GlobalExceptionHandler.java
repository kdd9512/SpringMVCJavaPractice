package exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{

    @ExceptionHandler(java.lang.NullPointerException.class)
    public String exceptionNullPointerGlobal(){

        return "except_pg2";
    }
}
