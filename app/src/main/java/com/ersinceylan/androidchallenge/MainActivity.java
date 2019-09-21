package com.ersinceylan.androidchallenge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    /**
     *  Beni hatırla verisinin değerine göre açılacak activity karar verilir.
     *  rememberMe=true ise ProductActivity çalışır
     *  rememberMe=false ise LoginActivity çalışır
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPref = this.getSharedPreferences("sharedPref",Context.MODE_PRIVATE);

        if(sharedPref.getBoolean("rememberMe",false)){
            startActivity(new Intent(this, ProductActivity.class));
        }
        else{
            startActivity(new Intent(this, LoginActivity.class));
        }

        finish();

    }

}
