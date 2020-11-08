package com.thierryoke.weeklyassignement_one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginsPage extends AppCompatActivity {

    LinearLayout linearLayout;
    EditText et_email, et_password, getEt_passwordConf;
    Button btn_create_account;
    Drawable drawableRight, drawableWrong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logins_page);

        et_email = findViewById(R.id.et_email);
        et_password= findViewById(R.id.et_passwrd);
        drawableWrong = getApplicationContext().getResources().getDrawable(R.drawable.cross);
        drawableRight = getApplicationContext().getResources().getDrawable(R.drawable.tick);


        getEt_passwordConf = findViewById(R.id.et_psswrdconf);
        btn_create_account = findViewById(R.id.btn_next);

        linearLayout = findViewById(R.id.err_msg);

        btn_create_account.setOnClickListener(new View.OnClickListener() {
            String email = et_email.getText().toString().trim();
            String passWord = et_password.getText().toString();
            String passWordConfig = getEt_passwordConf.getText().toString();
            @SuppressLint("UseCompatLoadingForDrawables")
            @Override
            public void onClick(View v) {

                viewHandler();


            }

            private void viewHandler() {

                if(isEmailValid() && isPasswordvalid() && isPasswrdTheSame()) {
                    et_email.setBackground(getDrawable(R.drawable.costomise_good_edittex));
                    et_password.setBackground(getDrawable(R.drawable.costomise_good_edittex));
                    getEt_passwordConf.setBackground(getDrawable(R.drawable.costomise_good_edittex));

                    et_email.setCompoundDrawablesRelativeWithIntrinsicBounds(null,  null, drawableRight, null);
                    et_password.setCompoundDrawablesRelativeWithIntrinsicBounds(null,  null, drawableRight, null);
                    getEt_passwordConf.setCompoundDrawablesRelativeWithIntrinsicBounds(null,  null, drawableRight, null);

                    Intent intent = new Intent(LoginsPage.this, NextPage.class);
                    startActivity(intent);

                }

                if(!isPasswrdTheSame() || !isEmailValid() )
                {
                    if(isEmailValid()) {

                        et_email.setBackground(getDrawable(R.drawable.costomise_good_edittex));
                        et_email.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawableRight, null);

                        linearLayout.setVisibility(View.VISIBLE);
                        et_password.setBackground(getDrawable(R.drawable.customize_editext));
                        getEt_passwordConf.setBackground(getDrawable(R.drawable.customize_editext));

                        et_password.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawableWrong, null);
                        getEt_passwordConf.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawableWrong, null);
                    }
                    else {
                        linearLayout.setVisibility(View.VISIBLE);

                        et_email.setBackground(getDrawable(R.drawable.customize_editext));
                        et_password.setBackground(getDrawable(R.drawable.customize_editext));
                        getEt_passwordConf.setBackground(getDrawable(R.drawable.customize_editext));

                        et_email.setCompoundDrawablesRelativeWithIntrinsicBounds(null,  null, drawableWrong, null);
                        et_password.setCompoundDrawablesRelativeWithIntrinsicBounds(null,  null, drawableWrong, null);
                        getEt_passwordConf.setCompoundDrawablesRelativeWithIntrinsicBounds(null,  null, drawableWrong, null);

                    }
                }

                if(isPasswrdTheSame() && isPasswordvalid())
                {
                    if(!isEmailValid()) {
                        et_email.setBackground(getDrawable(R.drawable.customize_editext));
                        et_email.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawableWrong, null);

                        linearLayout.setVisibility(View.INVISIBLE);
                        Toast.makeText(LoginsPage.this, "The Email Entered Is Invalid!!!", Toast.LENGTH_LONG).show();
                        et_password.setBackground(getDrawable(R.drawable.costomise_good_edittex));
                        getEt_passwordConf.setBackground(getDrawable(R.drawable.costomise_good_edittex));

                        et_password.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawableRight, null);
                        getEt_passwordConf.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawableRight, null);
                    }

                }


            }

            private boolean isPasswrdTheSame() {

                boolean flag = false;
                if(!passWord.isEmpty() && !passWordConfig.isEmpty() && passWord.equals(passWordConfig))
                {
                    flag = true;
                }

                return flag;
            }

            private boolean isPasswordvalid() {

                return true;

            }

            private boolean isEmailValid() {

                boolean flag = false;
                if(Patterns.EMAIL_ADDRESS.matcher(et_email.getText().toString()).matches()){

                    return true;
                }
                return flag;

            }
        });

        ImageButton imageButton = findViewById(R.id.nv_tool);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginsPage.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}