package com.example.dozen.myrecyclerview.bean;

/**
 * Created by Dozen on 2017/8/24.
 */

public class Orders {
    private String address;
    private String date;
    public Orders () {

    }

    public Orders(String address, String date) {
        this.address = address;
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
