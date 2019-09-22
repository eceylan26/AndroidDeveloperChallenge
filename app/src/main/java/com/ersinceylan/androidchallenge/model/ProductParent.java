package com.ersinceylan.androidchallenge.model;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import java.util.List;

/**
 * Rycyclerview içinde bulunan parent cardview'ta gösterilecek bilgilerin tutulduğu sınıf
 */
public class ProductParent implements ParentObject {

    private String date;
    private String month;
    private String orderName;
    private String marketName;
    private String productPrice;
    private String productState;
    private List<Object> mchild;

    public ProductParent(String date, String month, String orderName, String marketName, String productPrice, String productState) {
        this.date = date;
        this.month = month;
        this.orderName = orderName;
        this.marketName = marketName;
        this.productPrice = productPrice;
        this.productState = productState;
        this.mchild = mchild;
    }

    public ProductParent(){}

    public String getDate() {
        return date;
    }

    public String getMonth() {
        return month;
    }

    public String getOrderName() {
        return orderName;
    }

    public String getMarketName() {
        return marketName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public String getProductState() {
        return productState;
    }

    public List<Object> getMchild() {
        return mchild;
    }

    public void setMchild(List<Object> mchild) {
        this.mchild = mchild;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setMarketName(String marketName) {
        this.marketName = marketName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductState(String productState) {
        this.productState = productState;
    }

    @Override
    public List<Object> getChildObjectList() {
        return mchild;
    }

    @Override
    public void setChildObjectList(List<Object> list) {
        mchild=list;
    }
}
