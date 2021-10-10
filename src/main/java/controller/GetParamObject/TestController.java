package controller.GetParamObject;

import controller.GetParamObject.beans.DataBean2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class TestController {

    // ** @PathVariable 때와는 다르게 자료유형이 자동으로 parsing 되지 않고,
    // 오직 문자열로만 받는다. String 을 Integer 로 주입받을 수 없다는 얘기.
    @GetMapping("t1")
    public String test1(
            @RequestParam Map<String, String> map,
            @RequestParam List<String> data3) {
        String data1 = map.get("data1");
        String data2 = map.get("data2");
        String data3List = map.get("data3");

        // 같은 이름의 데이터가 복수 개 주입될 경우, 가장 처음 주입된 데이터만 보존된다.
        // 때문에, 동일 명으로 전달되는 파라미터가 2개 이상일 경우,
        // List 로 주입받아야 데이터가 손실되지 않는다.
        System.out.println("data1 : " + data1);
        System.out.println("data2 : " + data2);
        System.out.println("data3 : " + data3List);

        for (String str : data3) {
            System.out.println("data3List : " + str);
        }

        return "result";
    }

    @GetMapping("t2")




    // @ModelAttribute( = 커맨드 객체(Command Object))
    //  public String test2(@ModelAttribute DataBean bean1) {

    // 1. 원하는 데이터만 받을 수 있다.
    //    public String test2(@ModelAttribute DataBean2 bean2) {

    // 2. @ModelAttribute annotation 은 생략해도 무관하다.
    public String test2(DataBean2 bean2) {
        System.out.println("data1 :" + bean2.getData1());
        System.out.println("data2 :" + bean2.getData2());

//        for (int num : bean1.getData3()) {
//            System.out.println("data3 :" + num);
//        }

        return "result";
    }
}
