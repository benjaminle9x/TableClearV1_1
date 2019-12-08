package com.n01216688.testing;

public class restaurantdata {

    private String profile;
    private String name;
    private String phone;
    private String address;



    public restaurantdata() {
    }

    public restaurantdata(String name, String phone, String address, String profile) {
        this.profile = profile;
        this.name = name;
        this.phone = phone;
        this.address = address;
           }


    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}




