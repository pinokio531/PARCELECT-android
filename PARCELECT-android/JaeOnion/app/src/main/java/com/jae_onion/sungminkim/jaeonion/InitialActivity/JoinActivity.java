package com.jae_onion.sungminkim.jaeonion.InitialActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

import com.jae_onion.sungminkim.jaeonion.R;

public class JoinActivity extends AppCompatActivity {

    public static Activity joinActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userjoin);
        
        joinActivity = this;

        JoinCompleteButton();

    }

    public void JoinCompleteButton(){
        FrameLayout bt_complete = (FrameLayout) findViewById(R.id.joinComplete);
        bt_complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(JoinActivity.this, AgreeActivity.class));
            }
        });
    }
}
