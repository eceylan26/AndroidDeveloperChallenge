package com.ersinceylan.androidchallenge.model;

/**
 * Gson kütüpnahesi yardımıyla JSON'dan Class'a map yapma işlemi için kullanılan sınıf
 * ProductDetails Json bilgilerini tutar
 */
public class ProductDetail {

    private String orderDetail;
    private String summaryPrice;

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
