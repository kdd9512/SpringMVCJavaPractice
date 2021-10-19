package controller.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// 원래는 webapp/WEB-INF 에 위치해야 하는데 왜 resources 로 잡아야 인식하는건지 모르겠다...
// 실제 properties 는 webapp/WEB-INF 에서 쓰는데도 불구하고...


// PropertySource 는 한 개 추가할 때 사용.
// PropertySources 는 복수 개 추가할 때 사용.

// 물론 복수의 properties 를 아래와 같이 하나 하나 추가해도 동작은 하나 엄청나게 번거롭다.
//@PropertySource("/WEB-INF/properties/data1.properties")
//@PropertySource("/WEB-INF/properties/data2.properties")

// 이런 식으로 value 를 이용하여 경로만 작성해줘도 정상작동한다.
//@PropertySource(value = {
//        "/WEB-INF/properties/data1.properties",
//        "/WEB-INF/properties/data2.properties"
//})

// PropertySources 를 이용한다면 아래와 같이 사용한다.
@PropertySources({
        @PropertySource("/WEB-INF/properties/data1.properties"),
        @PropertySource("/WEB-INF/properties/data2.properties")
})
public class TestController {

    // properties 파일 내부 데이터를 가지고 온다.
    // properties 내의 데이터 이름과 일치시켜야 한다.
    @Value("${prop1.data1}")
    private int data1;

    @Value("${prop1.data2}")
    private String data2;

    @Value("${prop2.data3}")
    private int data3;

    @Value("${prop2.data4}")
    private String data4;

    @Value("${prop3.data5}")
    private int data5;

    @Value("${prop3.data6}")
    private String data6;

    @Value("${prop4.data7}")
    private int data7;

    @Value("${prop4.data8}")
    private String data8;


    @GetMapping("t1")
    public String test1() {

        System.out.printf("prop1.data1 : %d\n", data1);
        System.out.printf("prop1.data2 : %s\n", data2);
        System.out.printf("prop2.data3 : %d\n", data3);
        System.out.printf("prop2.data4 : %s\n", data4);
        System.out.printf("prop3.data5 : %s\n", data5);
        System.out.printf("prop3.data6 : %s\n", data6);
        System.out.printf("prop4.data7 : %s\n", data7);
        System.out.printf("prop5.data8 : %s\n", data8);

        return "test1";
    }
}
