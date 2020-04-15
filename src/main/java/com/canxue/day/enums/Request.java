package com.canxue.day.enums;

/**
 * @Author Lishuntao
 * @Date 2019/11/18
 */
public class Request {
    private float day;
    private String resaon;

    public Request(float day, String resaon) {
        this.day = day;
        this.resaon = resaon;
    }

    public float getDay() {
        return day;
    }

    public void setDay(float day) {
        this.day = day;
    }

    public String getResaon() {
        return resaon;
    }

    public void setResaon(String resaon) {
        this.resaon = resaon;
    }
}
