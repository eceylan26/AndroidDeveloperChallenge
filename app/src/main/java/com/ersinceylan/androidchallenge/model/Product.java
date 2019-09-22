package com.ersinceylan.androidchallenge.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Gson kütüpnahesi yardımıyla JSON'dan Class'a map yapma işlemi için kullanılan sınıf
 * Json bilgilerini tutar
 */
public class Product implements Comparable<Product>
{
    private String date;
    private String month;
    private String orderName;
    private String marketName;
    private String productPrice;
    private String productState;
    private ProductDetail productDetail;

    public ProductDetail getProductDetail() {
        return productDetail;
    }

    public void setProductDetail(ProductDetail productDetail) {
        this.productDetail = productDetail;
    }

    public Product(String date, String month, String oderName, String marketName, String productPrice, String productState, ProductDetail productDetail) {
        this.date = date;
        this.month = month;
        this.orderName = oderName;
        this.marketName = marketName;
        this.productPrice = productPrice;
        this.productState = productState;
        this.productDetail = new ProductDetail();
    }

    public Product(){}

    public String getDate() {
        return date;
    }

    public void setDate(int String) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getMarketName() {
        return marketName;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOderName(String oderName) {
        this.orderName = oderName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductState() {
        return productState;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    @Override
    public int compareTo(Product o) {

        if(this.month.compareTo(o.month)==0){
            return this.date.compareTo(o.date);
        }else
            return this.month.compareTo(o.month);
    }

    public String getFormatMonth() throws ParseException {
        SimpleDateFormat monthParse = new SimpleDateFormat("MM");
        SimpleDateFormat monthDisplay = new SimpleDateFormat("MMMM");
        return monthDisplay.format(monthParse.parse(month));
    }

}
