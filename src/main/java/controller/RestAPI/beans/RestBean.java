package controller.RestAPI.beans;

public class RestBean {
    private String data1;
    private int data2;
    private double data3;
    private boolean data4;

    // code 작성의 편의를 위해 데이터를 받기 위한 생성자 작성.
    public RestBean(String data1, int data2, double data3, boolean data4) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.data4 = data4;
    }

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

    public double getData3() {
        return data3;
    }

    public void setData3(double data3) {
        this.data3 = data3;
    }

    public boolean isData4() {
        return data4;
    }

    public void setData4(boolean data4) {
        this.data4 = data4;
    }
}
