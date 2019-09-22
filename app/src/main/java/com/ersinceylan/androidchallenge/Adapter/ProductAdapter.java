package com.ersinceylan.androidchallenge.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.ersinceylan.androidchallenge.R;
import com.ersinceylan.androidchallenge.ViewHolders.ProductChildViewHolder;
import com.ersinceylan.androidchallenge.model.ProductChild;
import com.ersinceylan.androidchallenge.model.ProductParent;
import com.ersinceylan.androidchallenge.ViewHolders.ProductParentViewHolder;
import java.util.List;

public class ProductAdapter extends ExpandableRecyclerAdapter<ProductParentViewHolder, ProductChildViewHolder>
{
    LayoutInflater inflater;

    public ProductAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        inflater = LayoutInflater.from(context);
    }

    @Override
    public ProductParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.activity_product_list_parent,viewGroup,false);
        return new ProductParentViewHolder(view);
    }

    @Override
    public ProductChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view = inflater.inflate(R.layout.activity_product_list_child,viewGroup,false);
        return new ProductChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(ProductParentViewHolder productParentViewHolder, int i, Object o) {
        ProductParent productParent = (ProductParent) o;
        productParentViewHolder.date.setText(productParent.getDate());
        productParentViewHolder.month.setText(productParent.getMonth());
        productParentViewHolder.marketName.setText(productParent.getMarketName());
        productParentViewHolder.orderName.setText(productParent.getOrderName());
        productParentViewHolder.productstate.setText(productParent.getProductState());
        productParentViewHolder.price.setText(productParent.getProductPrice());
        changeStatesColor(productParentViewHolder, productParent);

    }

    @Override
    public void onBindChildViewHolder(ProductChildViewHolder productChildViewHolder, int i, Object o) {
        ProductChild productChild = (ProductChild)o;

        productChildViewHolder.orderDetail.setText(productChild.getName());
        productChildViewHolder.summaryPrice.setText(productChild.getPrice());
    }

    /**
     *
     * Product durumuna göre image ve yazının renginin değişmesini sağlayan fonksiyon
     *
     * @param productParentViewHolder parent product xml bilgilerini tutan sınıfı
     * @param productParent parent product json bilgilerini tutan sınıfı
     */
    private void changeStatesColor(ProductParentViewHolder productParentViewHolder, ProductParent productParent){
        if(productParent.getProductState().equals("Hazırlanıyor")) {
            productParentViewHolder.productstate.setTextColor(inflater.getContext().getResources().getColor(R.color.colorYellow));
            productParentViewHolder.status.setBackground(inflater.getContext().getResources().getDrawable(R.drawable.ic_brightness_1_orange_24dp));
        }else if(productParent.getProductState().equals("Onay Bekliyor")){
            productParentViewHolder.productstate.setTextColor(inflater.getContext().getResources().getColor(R.color.colorRed));
            productParentViewHolder.status.setBackground(inflater.getContext().getResources().getDrawable(R.drawable.ic_brightness_1_red_24dp));
        }else {
            productParentViewHolder.productstate.setTextColor(inflater.getContext().getResources().getColor(R.color.colorGreen));
            productParentViewHolder.status.setBackground(inflater.getContext().getResources().getDrawable(R.drawable.ic_brightness_1_green_24dp));
        }

    }

}
