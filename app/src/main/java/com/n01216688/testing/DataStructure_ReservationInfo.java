package com.n01216688.testing;

public class DataStructure_ReservationInfo {

    private String cus_name;
    private String cus_number;
    private String cus_date;
    private String cus_time;
    private String cus_size;
    private String cus_table;
    private String res_name;

    public DataStructure_ReservationInfo(){

    }

    public DataStructure_ReservationInfo(String cus_name, String cus_number, String cus_date, String cus_time, String cus_size, String cus_table, String res_name) {
        this.cus_name = cus_name;
        this.cus_number = cus_number;
        this.cus_date = cus_date;
        this.cus_time = cus_time;
        this.cus_size = cus_size;
        this.cus_table = cus_table;
        this.res_name = res_name;
    }

    public void setRes_name(String res_name) {
        this.res_name = res_name;
    }

    public String getRes_name() { return res_name;}

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_number() {
        return cus_number;
    }

    public void setCus_number(String cus_number) {
        this.cus_number = cus_number;
    }

    public String getCus_date() {
        return cus_date;
    }

    public void setCus_date(String cus_date) {
        this.cus_date = cus_date;
    }

    public String getCus_time() {
        return cus_time;
    }

    public void setCus_time(String cus_time) {
        this.cus_time = cus_time;
    }

    public String getCus_size() {
        return cus_size;
    }

    public void setCus_size(String cus_size) {
        this.cus_size = cus_size;
    }

    public String getCus_table() {
        return cus_table;
    }

    public void setCus_table(String cus_table) {
        this.cus_table = cus_table;
    }
}
