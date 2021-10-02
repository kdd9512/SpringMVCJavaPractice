package controller.HttpServletRequestTest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    // 브라우저가 요청하는 정보들을 HttpServletRequest 또는 WebRequest 로 주입받을 수 있다.
    // GET 방식과 POST 방식에서 사용방식은 완전히 똑같다.

    @GetMapping("/t1") // GET 방식
    public String test1(HttpServletRequest req) {

        // HttpServletRequest 으로 받아온 파라메터 값을 추출한다.
        String data1 = req.getParameter("data1");
        String data2 = req.getParameter("data2");
        // 한 가지 이름으로 여러 데이터가 들어올 때, getParameterValues 로 한꺼번에 오브젝트로 묶어서 추출한다.
        String[] data3 = req.getParameterValues("data3");

        System.out.println("data1 : " + data1);
        System.out.println("data2 : " + data2);

        for (String str1 : data3) {
            System.out.println("data3 : " + str1);
        }

        return "result";
    }

    @PostMapping("t2") // POST 방식
    public String test2(HttpServletRequest req) {

        // HttpServletRequest 으로 받아온 파라메터 값을 추출한다.
        String data1 = req.getParameter("data1");
        String data2 = req.getParameter("data2");

        // 한 가지 이름으로 여러 데이터가 들어올 때, getParameterValues 로 한꺼번에 오브젝트로 묶어서 추출한다.
        String[] data3 = req.getParameterValues("data3");

        System.out.println("data1 : " + data1);
        System.out.println("data2 : " + data2);

        // 예외처리를 하지 않는다면 data3 값이 null 일 때, 오류가 날 것이다.
        if (data3 != null) {
            for (String str1 : data3) {
                System.out.println("data3 : " + str1);
            }
        }
        return "result";
    }

    @GetMapping("t3")
    public String test3(WebRequest req) {
        // WebRequest 으로 받아온 파라메터 값을 추출한다.
        String data1 = req.getParameter("data1");
        String data2 = req.getParameter("data2");

        // 한 가지 이름으로 여러 데이터가 들어올 때, getParameterValues 로 배열에 묶어 한꺼번에 추출한다.
        String[] data3 = req.getParameterValues("data3");

        System.out.println("data1 : " + data1);
        System.out.println("data2 : " + data2);

        // 예외처리를 하지 않는다면 data3 값이 null 일 때, 오류가 날 것이다.
        if (data3 != null) {
            for (String str1 : data3) {
                System.out.println("data3 : " + str1);
            }
        }

        return "result";
    }

    // PathVariable 방식.
    // 이 방식은 데이터를 t4/데이터명1/데이터명2/... 와 같은 방식으로 넣는다.
    // 이때, 실제 데이터는 데이터명2 부터라고 가정한다면 이하에서 매핑 요청 주소를 /t4/데이터명1/{데이터명2}/... 라고 적는다.
    // 즉, 데이터명인지 경로인지는 {} 여부를 통해 구분한다.
    @GetMapping("/t4/{data1}/{data2}/{data3}/{data3}/{data3}")
    public String test4(
            // 데이터가 복수개면 그 데이터의 숫자만큼 적어준다.
            @PathVariable int data1,
            @PathVariable int data2,
            @PathVariable int[] data3) {

        System.out.println("data1 : " + data1);
        System.out.println("data2 : " + data2);

        // 예외처리를 하지 않는다면 data3 값이 null 일 때, 오류가 날 것이다.
        // 같은 이름으로 복수 개의 데이터가 들어온다면 가장 마지막에 들어온 데이터만을 갖는다.
        if (data3 != null) {
            for (int str1 : data3) {
                System.out.println("data3 : " + str1);
            }
        }
        int sum = data1 + data2;

        // 가능한 경우, 자동으로 형변환 되어 주입된다.
        // 데이터를 입력할 때는 String 이었으나, 실제 값을 받으면 int 로 변환되어 들어옴.
        System.out.println("sum : " + sum);

        return "result";
    }

    @GetMapping("t5")
    public String test5(
            // 이하 data1 과 같이 value 를 이용하여 데이터의 이름을 변경할 수 있다. 보통은 잘 안씀.
            @RequestParam(value = "data1") int v1,
            @RequestParam int data2,
            @RequestParam int[] data3,

            // 넘어오는 파라메터 의 값을 안받는건 문제가 되지 않으나, 파라메터를 넘기지 않는건 문제가 된다.
            // 이 경우, 이하와 같이 required = false 를 설정해 두면 파라메터 내부에 해당 데이터가 없을 경우,
            // 해당 데이터를 자동으로 null 처리 한다.
            @RequestParam(required = false, value = "data4") String v4) {

        System.out.println("data1 = v1 : " + v1);
        System.out.println("data2 : " + data2);
        if (data3 != null) {
            for (int a1 : data3) {
                System.out.println("data3 : " + a1);
            }
        }
        System.out.println("data4 = v4 : " + v4);

        // RequestParam 도 가능한 경우, 자동으로 형변환 되어 주입된다.
        // 데이터를 입력할 때는 String 이었으나, 실제 값을 받으면 int 로 변환되어 들어옴.
        int sum = v1 + data2;
        System.out.println("sum : " + sum);

        return "result";
    }

}
