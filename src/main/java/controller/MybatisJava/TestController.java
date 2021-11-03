package controller.MybatisJava;

import controller.MybatisJava.beans.myBatisBean;
import database.MapperInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TestController {

    @Autowired
    MapperInterface mapper;

    @GetMapping("input_data")
    public String inputData(){

        return "input_data";
    }

    @PostMapping("input_prop")
    public String inputProp(myBatisBean bean) {
        mapper.insert_data(bean);

        return "input_success";
    }

    @GetMapping("read_data")
    public String readData(Model md){
        List<myBatisBean> list = mapper.select_data();
        // DB 에서 가져온 데이터로 만든 list 를 Model 에 담는다.
        md.addAttribute("list", list);
        return "read_data";
    }

}
