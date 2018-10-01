package com.jae_onion.sungminkim.jaeonion.InitialActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jae_onion.sungminkim.jaeonion.R;

public class AgreeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agree);

        startMain();
        textColorUseHtml();

    }

    //html tag 연습
    public void textColorUseHtml(){
        TextView textView = (TextView) findViewById(R.id.serviceAgree);
        String contents = textView.getText().toString();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(contents);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(R.color.greencolor)), 0, 6, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        textView.setText(spannableStringBuilder);
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
