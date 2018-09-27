package com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.jae_onion.sungminkim.jaeonion.R;

public class ProductSend_ThirdFragment extends Fragment{

    public ProductSend_ThirdFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_productsend_third, container, false);

        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.bt_payComplete);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        return view;
    }
}
