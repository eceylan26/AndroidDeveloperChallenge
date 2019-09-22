package com.ersinceylan.androidchallenge.ViewHolders;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.ersinceylan.androidchallenge.R;
import com.ersinceylan.androidchallenge.model.ProductDetail;

public class ProductChildViewHolder extends ChildViewHolder {

    public TextView orderDetail;
    public TextView summaryPrice;

    public ProductChildViewHolder(View itemView) {
        super(itemView);
        orderDetail = itemView.findViewById(R.id.orderDetail);
        summaryPrice = itemView.findViewById(R.id.summaryPrice);
    }

    public void setChild(ProductDetail productDetail) {
        this.orderDetail.setText(productDetail.getOrderDetail());
        this.summaryPrice.setText(productDetail.getSummaryPrice());

    }
}