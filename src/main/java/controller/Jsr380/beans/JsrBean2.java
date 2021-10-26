package controller.Jsr380.beans;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class JsrBean2 {
    @NotEmpty()
    private String data1;

    @NotBlank
    private String data2;

    public JsrBean2() {
        this.data1 = "ㄱㄴㄷㄹ";
        this.data2 = "ㄱㄴㄷㄹ";
    }

    public String getData1() {
        return data1;
    }

    public void setData1(String data1) {
        this.data1 = data1;
    }

    public String getData2() {
        return data2;
    }

    public void setData2(String data2) {
        this.data2 = data2;
    }
}
