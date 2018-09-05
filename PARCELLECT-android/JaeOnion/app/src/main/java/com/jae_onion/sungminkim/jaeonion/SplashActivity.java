package com.jae_onion.sungminkim.jaeonion;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class SplashActivity extends AppCompatActivity {

    private LinearLayout background;
    private MethodCompilation methodCompilation;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Login();
        JoinUser();
        HideKeyboard();

    }



    public void JoinUser(){
        TextView newJoin = (TextView) findViewById(R.id.bt_newUser);
        newJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SplashActivity.this, JoinActivity.class));
            }
        });
    }



    public void Login(){

        TextView bt_login = (TextView) findViewById(R.id.Login_bt);

        bt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText edit_id = (EditText) findViewById(R.id.Login_PW);
                EditText edit_pw = (EditText) findViewById(R.id.Longin_ID);

                String user_ID = edit_id.getText().toString();
                String user_PW = edit_pw.getText().toString();

                UserReference(0);

            }
        });
    }



    public void UserReference(int i){

        switch (i){

            case 0:
                startActivity(new Intent(SplashActivity.this, AgreeActivity.class));
                break;

            case 1:
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                break;

            case 2:
                Toast.makeText(this, "아이디 또는 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
                break;
        }

        finish();
    }

    public void HideKeyboard(){

        methodCompilation = new MethodCompilation(SplashActivity.this);
        background = (LinearLayout) findViewById(R.id.SplashBackground);

        background.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                methodCompilation.HideKeyboard(background);
            }
        });

    }
}
