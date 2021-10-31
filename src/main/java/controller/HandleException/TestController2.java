package controller.HandleException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class TestController2 {

    @GetMapping("t2")
    public String test2(){

        // NullPointerException 오류 유발을 위한 코드
        ArrayList<String> list = null;
        list.add("string");

        return "test2";
    }

//    @ExceptionHandler(java.lang.NullPointerException.class)
//    public String exceptNullPointer(){
//
//        return "except_pg2";
//    }
}
