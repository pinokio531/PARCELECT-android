package com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.jae_onion.sungminkim.jaeonion.InitialActivity.SplashActivity;
import com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.FirstFragment.ProductSend_FirstFragment;
import com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.SecondFragment.ProductSend_SecondFragment;
import com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.ThirdFragment.ProductSend_ThirdFragment;
import com.jae_onion.sungminkim.jaeonion.MethodCompilation;
import com.jae_onion.sungminkim.jaeonion.R;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ProductSendFragmentActivity extends AppCompatActivity {

    public static int FragmentIndex;
    public final static int Fragment_First = 0;
    public final static int Fragment_Second = 1;
    public final static int Fragment_Third = 2;
    public FrameLayout frameLayout;
    public MethodCompilation methodCompilation;

    public static Context mainContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_activity_product_send);

        frameLayout = (FrameLayout) findViewById(R.id.fragment_contents);
        HideKeyboard();

        mainContext = this;
        FragmentIndex = Fragment_First;

    }

    //fragment별 상황에 따라 출력하도록
    @Override
    public void onResume() {
        super.onResume();
        whichFragment(FragmentIndex);
    }

    //fragment별 case
    public void whichFragment(int fragmentIndex){

        Fragment fragment = null;

        switch (fragmentIndex){
            case Fragment_First:
                fragment = ProductSend_FirstFragment.getInstance();
                loadFragment_exception(fragment);
                break;

            case Fragment_Second:
                fragment = ProductSend_SecondFragment.getInstance();
                /*Bundle bundle = new Bundle();
                bundle.putString("test", "gdgd");
                fragment.setArguments(bundle);*/ //번들 연습 액티비티에서 fragment로 값을 바로 줄수 있음
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
                .add(R.id.fragment_contents, fragment)
                .commit();
    }

    //fragment 설정하기, backstack 없애기 귀찮아서 없는거 하나 만듬
    public void loadFragment_exception(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction
                .add(R.id.fragment_contents, fragment)
                .commit();
    }

    public void HideKeyboard(){

        methodCompilation = new MethodCompilation(ProductSendFragmentActivity.this);;

        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                methodCompilation.HideKeyboard(frameLayout);
            }
        });

    }


    @Override
    public void onBackPressed() {

        if(ProductSend_SecondFragment.inflatedView == true){
            ProductSend_SecondFragment.relativeLayout.removeView(ProductSend_SecondFragment.convertView);
            ProductSend_SecondFragment.inflatedView = false;
        }
        else{

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
}
