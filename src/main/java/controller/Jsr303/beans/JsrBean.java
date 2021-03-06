package controller.Jsr303.beans;

import javax.validation.constraints.*;

public class JsrBean {

    @AssertTrue
    private boolean data1;
    @AssertFalse
    private boolean data2;

    @Min(100)
    @Max(1000)
    private String data3;

    @DecimalMax(value = "1000", inclusive = false)
    @DecimalMin(value = "100", inclusive = false)
    private String data4;

    @Null
    private String data5;

    @NotNull
    private String data6;

    @Digits(integer = 4, fraction = 4)
    private String data7;

    @Size(min = 5, max = 10)
    private String data8;

    // 비밀번호 정규식.(영문자와 숫자 특수기호가 적어도 1개 이상,6자 ~ 12자)
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-z])(?=.*\\W)(?=\\S+$).{6,12}")
    private String data9;


    // 하나의 검사를 통과해야 그 다음 검사를 실행할 수 있기 때문에 이하와 같이 생성자를 하나 만들어준다.
    public JsrBean() {
        this.data1 = true;
        this.data2 = false;
        this.data3 = "100";
        this.data4 = "101";
        this.data5 = null;
        this.data6 = "check2";
        this.data7 = "1111.1111";
        this.data8 = "최소5글자";
    }


    public boolean isData1() {
        return data1;
    }

    public void setData1(boolean data1) {
        this.data1 = data1;
    }

    public boolean isData2() {
        return data2;
    }

    public void setData2(boolean data2) {
        this.data2 = data2;
    }

    public String getData3() {
        return data3;
    }

    public void setData3(String data3) {
        this.data3 = data3;
    }

    public String getData4() {
        return data4;
    }

    public void setData4(String data4) {
        this.data4 = data4;
    }

    public String getData5() {
        return data5;
    }

    public void setData5(String data5) {
        this.data5 = data5;
    }

    public String getData6() {
        return data6;
    }

    public void setData6(String data6) {
        this.data6 = data6;
    }

    public String getData7() {
        return data7;
    }

    public void setData7(String data7) {
        this.data7 = data7;
    }

    public String getData8() {
        return data8;
    }

    public void setData8(String data8) {
        this.data8 = data8;
    }

    public String getData9() {
        return data9;
    }

    public void setData9(String data9) {
        this.data9 = data9;
    }
}
