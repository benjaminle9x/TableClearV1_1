package com.n01216688.testing;

public class DataStructure_Restaurantinfo {

    private String restaurant_name;
    private String restaurant_phone;
    private String restaurant_address;

    public DataStructure_Restaurantinfo() {

    }

    public DataStructure_Restaurantinfo(String name, String phone, String address) {
        this.restaurant_name = name;
        this.restaurant_phone = phone;
        this.restaurant_address = address;
    }

    public String getName() {
        return restaurant_name;
    }

    public void setName(String name) {
        this.restaurant_name = name;
    }

    public String getPhone() {
        return restaurant_phone;
    }

    public void setPhone(String phone) {
        this.restaurant_phone = phone;
    }

    public String getAddress() {
        return restaurant_address;
    }

    public void setAddress(String address) {
        this.restaurant_address = address;
    }
}




