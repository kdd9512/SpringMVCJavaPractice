package controller.GetParamObject.beans;

public class DataBean {

    // 변수명은 파라메터의 이름과 일치해야 한다.
    // 이 변수명과 일치하는 데이터 이외의 것이 들어오면
    // 그 데이터는 자동으로 폐기된다.
    private int data1;
    private int data2;
    private int[] data3;

    public DataBean() {
    }

    public DataBean(int data1, int data2, int[] data3) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
    }

    public int getData1() {
        return data1;
    }

    public void setData1(int data1) {
        this.data1 = data1;
    }

    public int getData2() {
        return data2;
    }

    public void setData2(int data2) {
        this.data2 = data2;
    }

    public int[] getData3() {
        return data3;
    }

    public void setData3(int[] data3) {
        this.data3 = data3;
    }
}
