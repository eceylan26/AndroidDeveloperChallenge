package com.ersinceylan.androidchallenge;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

/**
 *  UI üzerindeki elemanları daha kolay Javada kullanabilmek için eklenmiştir.
 */
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Ersin CEYLAN
 */
public class LoginActivity extends AppCompatActivity {

    /**
     *  UI elemanlarının XML'den enjekte etmek için tanımlanır
     */
    @BindView(R.id.username) EditText username;
    @BindView(R.id.password) TextView password;
    @BindView(R.id.rememberme) Switch rememberMe;
    @BindView(R.id.login_button) Button loginButton;
    @BindView(R.id.error_text) TextView errorMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        ButterKnife.bind(this);

    }

    @OnClick(R.id.login_button)
    public void submit() {

        // Beni hatırla özelliğini tutmak için
        SharedPreferences sharedPref = this.getSharedPreferences("sharedPref",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();

        /**
         *  Kullanıcı adı ve şifre doğruysa ProductActivity Çalıştırılır ve Beni hatırla özelliğinin
         *  durumu SharedPreference'a kaydedilir.
         *  Kullanıcı adı ve şifre yanlış ise error hatası basılır ve EditTextler temizlenir.
         */
        if(checkCredential()){
            editor.putBoolean("rememberMe",stateRememberMe());
            editor.apply();
            startActivity(new Intent(this, ProductActivity.class));
            finish();

        }
        else {
            errorMessage.setText("*Hatalı Kullanıcı Adı ve Şifre");
            username.setText("");
            password.setText("");
            errorMessage.setVisibility(View.VISIBLE);
        }

    }

    /**
     * Kullanici adi ve sifre kontrolu yapar
     *
     * @return kullanıcı adi ve sifre dogruysa true değilse false
     *
     */
    private boolean checkCredential() {
        final String trueUsername="kariyer";
        final String truePassword="2019ADev";

        if(trueUsername.equals(username.getText().toString()) &&
                truePassword.equals(password.getText().toString())){
            return true;
        }
        else
            return false;
    }

    /**
     *
     * Beni hatırla özelliğinin durumunu döndürür
     *
     * @return Ozellik acildiysa true degilse false
     */
    private boolean stateRememberMe(){
        if(rememberMe.isChecked()){
            return true;
        }
        else
            return false;
    }

}
