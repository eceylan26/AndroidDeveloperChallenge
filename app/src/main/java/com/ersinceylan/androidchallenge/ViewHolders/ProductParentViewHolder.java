package com.ersinceylan.androidchallenge.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bignerdranch.expandablerecyclerview.ViewHolder.ParentViewHolder;
import com.ersinceylan.androidchallenge.R;
import com.ersinceylan.androidchallenge.model.ProductDetail;

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

    public void setMTextViews(int date, int month, String orderName, String marketName, float productPrice, String productState, ProductDetail productDetail) {
        this.date.setText(date);
        this.month.setText(month);
        this.orderName.setText(orderName);
        this.marketName.setText(marketName);
        this.price.setText(Float.toString(productPrice));
        this.productstate.setText(productState);
    }




}