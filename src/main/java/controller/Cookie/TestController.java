package controller.Cookie;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
public class TestController {

    // cookie 를 저장
    @GetMapping("save_cookie")
    public String save_cookie(HttpServletResponse res) {

        // URLEncoder : 한글깨짐 방지를 위한 인코딩/디코딩 처리.
        // 저장된 cookie 는, 개발자도구 어플리케이션 -> cookie 에서 확인 가능함.
        try {
            String data1 = URLEncoder.encode("김두한", "UTF-8");
            String data2 = URLEncoder.encode("심영", "UTF-8");

            Cookie cookie1 = new Cookie("cookie1", data1);
            Cookie cookie2 = new Cookie("cookie2", data2);

            // cookie 의 수명을 설정.
            // 숫자는 왼쪽부터, 365일 24시간 60분 60초
            cookie1.setMaxAge(365 * 24 * 60 * 60);
            cookie2.setMaxAge(365 * 24 * 60 * 60);

            // 응답정보를 담을 response 정보에 쿠키를 담는다.
            res.addCookie(cookie1);
            res.addCookie(cookie2);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "save_cookie";
    }

    // 브라우저가 보낸 cookie 를 추출하여 가져오기

    // 브라우저 내에 저장된 쿠키는 요청한다면 내 의도와는 상관없이 모든 쿠키가 전부 호출되기 때문에
    // 아무 조치를 취하지 않는다면, 원하는 쿠키만 사용하는 것은 사실상 불가능하다.

    // 특정 쿠키 몇 개만 사용하고 싶다면..
    // 1. HttpServletRequest 에 담겨오는 cookie 정보를 먼저 추출하고 배열에 담은 다음,
    // 2. 반복문으로 검사하여 그 배열 내부에서 골라 내야 한다.
    // 3. JSP 내 에서 사용하고 싶다면 Model 에 담아야 한다.
    @GetMapping("load_cookie")
    public String load_cookie(HttpServletRequest req) {
        try {
            // 브라우저 내 쿠키 전체를 담는 배열.
            Cookie[] cookies = req.getCookies();

            // 반복문으로 cookie 검사.
            for (Cookie cookie : cookies) {
                // cookie 디코딩
                String str = URLDecoder.decode(cookie.getValue(), "UTF-8");

                // 조건문으로 filtering
                if (cookie.getName().equals("cookie1")) {
                    System.out.printf("cookie1 : %s\n", str);
                } else if (cookie.getName().equals("cookie2")) {
                    System.out.printf("cookie2 : %s\n", str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "load_cookie";
    }

    // @Cookie annotation 이용.
    @GetMapping("load_cookie2")
    public String load_cookie2(@CookieValue("cookie1") String cookie1,
                               @CookieValue("cookie2") String cookie2) {
        System.out.printf("cookie1 : %s\n", cookie1);
        System.out.printf("cookie2 : %s\n", cookie2);

        return "load_cookie2";
    }

}
