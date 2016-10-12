package com.skye.any.alipay.bean;

/**
 * Created by Administrator on 2016/10/12.
 */
public class ListGood {
    private String gName;
    private int gPrice;
    private int gNumber;

    public ListGood(String gName, int gPrice, int gNumber) {
        this.gName = gName;
        this.gPrice = gPrice;
        this.gNumber = gNumber;
    }

    public String getgName() {
        return gName;
    }

    public void setgName(String gName) {
        this.gName = gName;
    }

    public int getgPrice() {
        return gPrice;
    }

    public void setgPrice(int gPrice) {
        this.gPrice = gPrice;
    }

    public int getgNumber() {
        return gNumber;
    }

    public void setgNumber(int gNumber) {
        this.gNumber = gNumber;
    }

    @Override
    public String toString() {
        return "ListGood{" +
                "gName='" + gName + '\'' +
                ", gPrice=" + gPrice +
                ", gNumber=" + gNumber +
                '}';
    }
}
