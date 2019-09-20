package com.ersinceylan.androidchallenge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    private static final String trueUsername="kariyer";
    private static final String truePassword="2019ADev";

    @BindView(R.id.username) EditText username;
    @BindView(R.id.password) TextView password;
    @BindView(R.id.rememberme) Switch rememberMe;
    @BindView(R.id.login_button) Button loginButton;
    @BindView(R.id.error_text) TextView errorMessage;

    SharedPreferences globalSharedPref;
    SharedPreferences.Editor globalSharedPrefEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        final SharedPreferences sharedPref = this.getPreferences(Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPref.edit();
        globalSharedPref=sharedPref;
        globalSharedPrefEditor=editor;
    }

    @OnClick(R.id.login_button)
    public void submit() {

        if(checkCredential()){
            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show();
            globalSharedPrefEditor.putBoolean("rememberMe",stateRememberMe());
            errorMessage.setText("*Invalid Credential");
            errorMessage.setVisibility(View.VISIBLE);
            startActivity(new Intent(this, ProductActivity.class));

        }

    }

    private boolean checkCredential() {
        if(trueUsername.equals(username.getText().toString()) &&
                truePassword.equals(password.getText().toString())){
            return true;
        }
        else
            return false;
    }

    private boolean stateRememberMe(){
        if(rememberMe.isChecked()){
            return true;
        }
        else
            return false;
    }



}
