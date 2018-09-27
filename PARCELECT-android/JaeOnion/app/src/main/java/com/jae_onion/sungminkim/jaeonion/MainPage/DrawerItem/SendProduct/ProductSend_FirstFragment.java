package com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.jae_onion.sungminkim.jaeonion.R;

public class ProductSend_FirstFragment extends Fragment{

    View view;

    public ProductSend_FirstFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_productsend, container, false);
        bt_nextClick();



        return view;
    }

    public void bt_nextClick(){
        Button bt_next = (Button) view.findViewById(R.id.nextButton);
        bt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductSendFragmentActivity.FragmentIndex = ProductSendFragmentActivity.Fragment_Second;
                ((ProductSendFragmentActivity) ProductSendFragmentActivity.mainContext).onResume();
            }
        });
    }




}
