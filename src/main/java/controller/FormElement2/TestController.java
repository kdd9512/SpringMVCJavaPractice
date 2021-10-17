package controller.FormElement2;

import controller.FormElement2.beans.DataBean;
import controller.FormElement2.beans.KeyValBean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class TestController {

    @GetMapping("t1")
    public String test1(DataBean bean, Model md) {

        bean.setD1("무뇌봉동무");
        bean.setD2("황철동무");
        bean.setD3("임선규동무");
        // 태그의 value 와 실제 select 태그에서 표시되는 값이 다른 경우에도
        // 실제로 선택지가 갖는 값인 value 를 기준으로 해야 정상작동한다.
        // ex) 이 value 의 key 값은 "빨갱이3" 인데, 여기에 빨갱이3 을 입력해도
        // 의도한 대로 작동되지 않으며 해당 문자열을 찾을 수 없어 가장 처음 값인 빨갱이1 이 표시된다.
        bean.setD4("황철동무");

        // form:checkbox 를 위한 array. 이 Array 를 AppliScopeBean 의 변수 d5, d6, d7 에 주입한다.
        String [] chkList = {"공산당", "안할거야"};
        bean.setD5(chkList);
        bean.setD6(chkList);
        bean.setD7(chkList);
        bean.setD8(chkList);


        String [] dataList = {"무뇌봉동무", "임선규동무", "황철동무"};
        md.addAttribute("dataList", dataList);

        ArrayList<String> dataList2 = new ArrayList<>();
        dataList2.add("무뇌봉동무");
        dataList2.add("임선규동무");
        dataList2.add("황철동무");
        md.addAttribute("dataList2", dataList2);

        // value 값과 select 태그에 선택지로 나타날 문자열이 같은 경우 이용할
        // key 와 value 값을 저장하는 KeyValBean 클래스에 값을 넣어준다.

        KeyValBean kvBean1 = new KeyValBean();
        KeyValBean kvBean2 = new KeyValBean();
        KeyValBean kvBean3 = new KeyValBean();

        kvBean1.setKey("빨갱이1");
        kvBean2.setKey("빨갱이2");
        kvBean3.setKey("빨갱이3");

        kvBean1.setValue("무뇌봉동무");
        kvBean2.setValue("임선규동무");
        kvBean3.setValue("황철동무");

        // 위에서 정의한 key / value 값을 전부 ArrayList 에 넣어준다
        ArrayList<KeyValBean> dataList3 = new ArrayList<>();
        dataList3.add(kvBean1);
        dataList3.add(kvBean2);
        dataList3.add(kvBean3);

        md.addAttribute("dataList3", dataList3);

        return "test1";
    }
}
