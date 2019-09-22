package com.ersinceylan.androidchallenge.model;


public class ProductChild {

    String orderDetail;
    String  summaryPrice;

    public String getPrice() {
        return summaryPrice;
    }

    public void setPrice(String price) {
        this.summaryPrice = price;
    }

    public ProductChild(String name, String price) {
        this.orderDetail = name;
        this.summaryPrice = price;
    }

    public ProductChild(){}

    public String getName() {
        return orderDetail;
    }

    public void setName(String name) {
        this.orderDetail = name;
    }
}
