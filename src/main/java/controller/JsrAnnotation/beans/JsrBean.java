package controller.JsrAnnotation.beans;

import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;

public class JsrBean {

    @AssertTrue
    private boolean data1;
    @AssertFalse
    private boolean data2;

    // data1 의 검사가 끝나야지만 data2 의 검사를 실행할 수 있기 때문에 생성자를 하나 만들어준다.
    public JsrBean() {
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
}
