package controller.HandleException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class TestController {

    @GetMapping("t1")
    public String test1(Model md){
//        int [] arr1 = {10,20,30};

        // ArrayIndexOutOfBounds 에러 유발을 위한 코드.
//        md.addAttribute("array1", arr1[3]);

        ArrayList<String> list = null;
        list.add("string");

        return "test1";
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public String exceptOutOfBound(){

        return "except_pg1";
    }
}
