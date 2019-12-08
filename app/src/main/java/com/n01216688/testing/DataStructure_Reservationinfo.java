package com.n01216688.testing;

public class DataStructure_Reservationinfo {

    private String Name;
    private String Phone;
    private String year;
    private String month;
    private String day;
    private String hour;
    private String min;
    private String howMany;

    public DataStructure_Reservationinfo() {
    }

    public DataStructure_Reservationinfo(String name, String phone, String year, String month, String day, String hour, String min, String howMany) {
        Name = name;
        Phone = phone;
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.min = min;
        this.howMany = howMany;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getHowMany() {
        return howMany;
    }

    public void setHowMany(String howMany) {
        this.howMany = howMany;
    }
}
