package com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.jae_onion.sungminkim.jaeonion.R;

public class ProductSendFragmentActivity extends AppCompatActivity {

    public static int FragmentIndex = 0;
    public final static int Fragment_First = 0;
    public final static int Fragment_Second = 1;
    public final static int Fragment_Third = 2;

    public static Context mainContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity_product_send);

        mainContext = this;


    }

    //fragment별 상황에 따라 출력하도록
    @Override
    protected void onResume() {
        super.onResume();
        whichFragment(FragmentIndex);
    }

    //fragment별 case
    public void whichFragment(int fragmentIndex){

        Fragment fragment = null;

        switch (fragmentIndex){
            case Fragment_First:
                fragment = new ProductSend_FirstFragment();
                loadFragment_exception(fragment);
                break;

            case Fragment_Second:
                fragment = new ProductSend_SecondFragment();
                loadFragment(fragment);
                break;

            case Fragment_Third:
                fragment = new ProductSend_ThirdFragment();
                loadFragment(fragment);
                break;
        }

    }

    //fragment 설정하기
    public void loadFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction
                .addToBackStack(null)
                .replace(R.id.fragment_contents, fragment)
                .commit();
    }

    //fragment 설정하기, backstack 없애기 귀찮아서 없는거 하나 만듬
    public void loadFragment_exception(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction
                .replace(R.id.fragment_contents, fragment)
                .commit();
    }


    @Override
    public void onBackPressed() {

        //backstack 보고 있으면 백버튼시 pop한다
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate();
        }
        //기본 framelayout은 빈 화면 이라서 나갔다 들어오면 빈화면이 출력되므로 강제적으로 설정함
        else{
            super.onBackPressed();
            FragmentIndex = Fragment_First;
        }
    }
}
