package com.jae_onion.sungminkim.jaeonion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

public class MypageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage);

        buttonFunction();

    }

    public void buttonFunction(){
        FrameLayout bt_token = (FrameLayout) findViewById(R.id.bt_token);
        FrameLayout bt_record = (FrameLayout) findViewById(R.id.bt_record);
        FrameLayout bt_send = (FrameLayout) findViewById(R.id.bt_send);
        FrameLayout bt_receive = (FrameLayout) findViewById(R.id.bt_receive);
        FrameLayout bt_search = (FrameLayout) findViewById(R.id.bt_search);
        FrameLayout bt_qna = (FrameLayout) findViewById(R.id.bt_qna);
        FrameLayout bt_faq = (FrameLayout) findViewById(R.id.bt_faq);

        bt_token.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_receive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_qna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        bt_faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
