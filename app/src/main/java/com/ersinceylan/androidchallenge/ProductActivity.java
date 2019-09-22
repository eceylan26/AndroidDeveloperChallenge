package com.ersinceylan.androidchallenge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.ersinceylan.androidchallenge.Adapter.ProductAdapter;
import com.ersinceylan.androidchallenge.model.Product;
import com.ersinceylan.androidchallenge.model.ProductChild;
import com.ersinceylan.androidchallenge.model.ProductParent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProductActivity extends AppCompatActivity {

    @BindView(R.id.product_recycler) RecyclerView product_recycler;
    @BindView(R.id.orders) Button buttonOrders;
    @BindView(R.id.logout) Button buttonLogout;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        ((ProductAdapter)product_recycler.getAdapter()).onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);

        fetchProductJSON fetchProduct = new fetchProductJSON();
        fetchProduct.execute();

        product_recycler.setLayoutManager(new LinearLayoutManager(this));

        ProductAdapter adapter = null;
        try {
            adapter = new ProductAdapter(this,initData(fetchProduct.products));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        adapter.setParentClickableViewAnimationDefaultDuration();
        adapter.setParentAndIconExpandOnClick(true);

        product_recycler.setAdapter(adapter);

    }

    @OnClick(R.id.logout)
    public void submit() {
        SharedPreferences sharedPref = this.getSharedPreferences("sharedPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.remove("rememberMe");
        editor.putBoolean("rememberMe",false);
        editor.apply();

        startActivity(new Intent(this, LoginActivity.class));
        finish();

    }

    public class fetchProductJSON extends AsyncTask<Void, Void, Product[]> {

        private Product[] products;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Product[] doInBackground(Void... params) {

            try {
                String json = getFromUrl("http://kariyertechchallenge.mockable.io/");

                GsonBuilder builder = new GsonBuilder();
                builder.setPrettyPrinting();
                Gson gson = builder.create();
                products = gson.fromJson(json, Product[].class);
                int a =0;
            } catch (Exception e) {
                e.printStackTrace();
            }

            return products;
        }

        @Override
        protected void onPostExecute(Product[] result) {
            super.onPostExecute(result);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onCancelled(Product[] result) {
            super.onCancelled(result);
        }

    }

    private static String getFromUrl(String urlString) throws Exception {
        BufferedReader reader = null;
        try {
            URL url = new URL(urlString);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));
            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        } finally {
            if (reader != null)
                reader.close();
        }
    }

    private List<ParentObject> initData(Product[] productsArray) throws ParseException {

        List<ParentObject> listParentProducts = new ArrayList<>();

        Arrays.sort(productsArray);
        Product previousProduct=null;

        for (Product var : productsArray) {

            ProductParent productParent = new ProductParent();

            productParent.setMarketName(var.getMarketName());
            productParent.setOrderName(var.getOrderName());
            productParent.setProductPrice(var.getProductPrice() + "TL");
            productParent.setProductState(var.getProductState());

            /**
             * Bu if check aynı ay ve gün ürünlerin tarihlerinin görünmesinin engeller
             */
            if(previousProduct!=null && previousProduct.getMonth().equals(var.getMonth())
                    && previousProduct.getDate().equals(var.getDate())) {
                productParent.setMonth("");
                productParent.setDate("");
            }else {
                productParent.setMonth(var.getFormatMonth());
                productParent.setDate(var.getDate());
            }
            List<Object> childList = new ArrayList<>();
            ProductChild productChild = new ProductChild();

            productChild.setName(var.getProductDetail().getOrderDetail());
            productChild.setPrice(var.getProductDetail().getSummaryPrice() + "TL");

            childList.add(productChild);
            productParent.setChildObjectList(childList);

            listParentProducts.add(productParent);

            previousProduct = var;
        }

        return listParentProducts;

    }




}
