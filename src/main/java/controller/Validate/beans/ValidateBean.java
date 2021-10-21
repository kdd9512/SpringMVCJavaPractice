package controller.Validate.beans;

import javax.validation.constraints.Max;
import javax.validation.constraints.Size;

public class ValidateBean {

    // 유효성 검사에서 사용할 조건을 만든다.
    // String 값의 최소길이와 최대길이를 지정한다.
    @Size(min = 2, max = 10)
    private String data1;

    // 유효성 검사에서 사용할 조건을 만든다.
    // int 값의 최대치를 지정한다.
    @Max(1000)
    private int data2;

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public int getData2() {
        return data2;
    }

    public void setData2(int data2) {
        this.data2 = data2;
    }
}
