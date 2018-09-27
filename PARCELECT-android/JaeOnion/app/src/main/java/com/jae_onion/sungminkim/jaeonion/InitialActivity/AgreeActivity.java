package com.jae_onion.sungminkim.jaeonion.InitialActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.jae_onion.sungminkim.jaeonion.R;

public class AgreeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agree);

        startMain();

    }

    public void startMain(){
        FrameLayout bt_start = (FrameLayout) findViewById(R.id.bt_start);

        bt_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AgreeActivity.this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                JoinActivity.joinActivity.finish();
                finish();
            }
        });

    }
}
