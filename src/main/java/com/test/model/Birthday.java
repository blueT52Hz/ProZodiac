package com.test.model;

public class Birthday {
    Integer day, month, year;

    public Birthday(Integer day, Integer month, Integer year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    public Birthday(String infor) {
        String[] strings = infor.split("/");
        this.day = Integer.parseInt(strings[0]);
        this.month = Integer.parseInt(strings[1]);
        this.year = Integer.parseInt(strings[2]);
    }
    public void setDay(Integer day) {
        this.day = day;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
    public Integer getDay() {
        return day;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", day, month, year);
    }
//    public static void main(String[] args) {
//        Birthday birthday = new Birthday("01/01/2004");
//        System.out.println(birthday.toString());
//    }
}
