package com.ersinceylan.androidchallenge.model;

public class Product
{
    private int date;
    private int month;
    private String oderName;
    private String marketName;
    private String orderDetail;
    private float productPrice;
    private String productState;
    private String summaryPrice;

    public Product(int date, int month, String oderName, String marketName, String orderDetail, float productPrice, String productState, String summaryPrice) {
        this.date = date;
        this.month = month;
        this.oderName = oderName;
        this.marketName = marketName;
        this.orderDetail = orderDetail;
        this.productPrice = productPrice;
        this.productState = productState;
        this.summaryPrice = summaryPrice;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getOderName() {
        return oderName;
    }

    public void setOderName(String oderName) {
        this.oderName = oderName;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    public String getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(String orderDetail) {
        this.orderDetail = orderDetail;
    }

    public String getSummaryPrice() {
        return summaryPrice;
    }

    public void setSummaryPrice(String summaryPrice) {
        this.summaryPrice = summaryPrice;
    }


}
