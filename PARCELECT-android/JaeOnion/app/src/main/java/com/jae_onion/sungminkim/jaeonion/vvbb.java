package com.jae_onion.sungminkim.jaeonion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class vvbb extends AppCompatActivity{
    int a;
    public vvbb(int a){
        this.a = a;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);

        textView.setText(getResources().getString(R.string.app_name));
    }
}
