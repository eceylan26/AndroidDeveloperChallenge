package com.ersinceylan.androidchallenge.ViewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.ersinceylan.androidchallenge.R;

import butterknife.BindView;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.month) EditText productMonth;
    @BindView(R.id.date) EditText productDate;
    @BindView(R.id.marketName) EditText productMarketName;
    @BindView(R.id.orderName) EditText productOrderName;
    @BindView(R.id.productPrice) EditText productPrice;
    @BindView(R.id.productState) EditText productState;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
