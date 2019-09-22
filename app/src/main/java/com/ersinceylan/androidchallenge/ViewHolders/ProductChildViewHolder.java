package com.ersinceylan.androidchallenge.ViewHolders;

import android.view.View;
import android.widget.TextView;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.ersinceylan.androidchallenge.R;

/**
 * Recyclerview da bulunan parent componentlerin init edildiği yer
 */
public class ProductChildViewHolder extends ChildViewHolder {

    public TextView orderDetail;
    public TextView summaryPrice;

    public ProductChildViewHolder(View itemView) {
        super(itemView);
        orderDetail = itemView.findViewById(R.id.orderDetail);
        summaryPrice = itemView.findViewById(R.id.summaryPrice);
    }

}