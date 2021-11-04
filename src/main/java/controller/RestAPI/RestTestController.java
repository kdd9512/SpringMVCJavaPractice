package controller.RestAPI;

import controller.RestAPI.beans.RestBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

// RestController 는 return 값 그대로 응답결과를 화면에 출력한다.
@RestController
public class RestTestController {

    @GetMapping("t2")
    public ResponseEntity<ArrayList<RestBean>> test2(){
        RestBean bean1 = new RestBean("string1",10,11.11,false);
        RestBean bean2 = new RestBean("string2",20,22.22,true);
        RestBean bean3 = new RestBean("string3",30,33.33,false);

        ArrayList<RestBean> list = new ArrayList<>();
        list.add(bean1);
        list.add(bean2);
        list.add(bean3);

        // 응답결과를 JSON data 로 변환하기 위해 객체로 만든다.
        // ArrayList<RestBean> 을 토대로 객체를 만들것이므로,
        // 제네릭( = <이 안에 들어있는 타입만 받을 수 있게 만드는 것.>)은 ArrayList<RestBean> 로 해야 한다.
        ResponseEntity<ArrayList<RestBean>> entity = new ResponseEntity<>(list, HttpStatus.OK);

        return entity;
    }

}
