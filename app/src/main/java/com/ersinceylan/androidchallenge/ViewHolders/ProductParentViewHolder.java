package com.ersinceylan.androidchallenge.ViewHolders;

import android.view.View;
import android.widget.TextView;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.ersinceylan.androidchallenge.R;

/**
 * Recyclerview da bulunan parent componentlerin init edildiği yer
 */
public class ProductParentViewHolder extends ParentViewHolder {

    public TextView date;
    public TextView month;
    public TextView marketName;
    public TextView orderName;
    public TextView productstate;
    public TextView price;
    public View status;

    public ProductParentViewHolder(View itemView) {
        super(itemView);
        date = itemView.findViewById(R.id.date);
        month = itemView.findViewById(R.id.month);
        marketName = itemView.findViewById(R.id.marketName);
        orderName = itemView.findViewById(R.id.orderName);
        productstate = itemView.findViewById(R.id.productState);
        price = itemView.findViewById(R.id.productPrice);
        status = itemView.findViewById(R.id.status);
    }

}