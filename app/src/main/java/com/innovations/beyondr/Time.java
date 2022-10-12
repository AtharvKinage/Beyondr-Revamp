package com.innovations.beyondr;

public class Time {
    String time;
    Boolean bool;

    public Time() {
    }

    public Time(String time, Boolean bool) {
        this.time = time;
        this.bool = bool;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Boolean getBool() {
        return bool;
    }

    public void setBool(Boolean bool) {
        this.bool = bool;
    }
}
