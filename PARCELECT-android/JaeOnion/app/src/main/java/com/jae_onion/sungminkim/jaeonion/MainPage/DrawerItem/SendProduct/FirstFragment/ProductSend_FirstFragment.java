package com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.FirstFragment;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.ProductSendFragmentActivity;
import com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.ThirdFragment.ProductSend_ThirdFragment;
import com.jae_onion.sungminkim.jaeonion.R;
import com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.StaticString;

public class ProductSend_FirstFragment extends Fragment{

    View view;

    public static String test;

    //싱글톤 객체 만들기 연습
    public static ProductSend_FirstFragment productSend_firstFragment = new ProductSend_FirstFragment();


    public ProductSend_FirstFragment(){

    }

    //싱글톤 객체 만들기
    public static ProductSend_FirstFragment getInstance(){


        return productSend_firstFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.activity_productsend, container, false);
        bt_nextClick();
        setSpinner();

        return view;
    }


    public void bt_nextClick(){
        Button bt_next = (Button) view.findViewById(R.id.nextButton);

        bt_next.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {


                EditText sendUser = (EditText) view.findViewById(R.id.sendUserNameEdit);
                EditText receiveUser = (EditText) view.findViewById(R.id.receiveUserNameEdit);
                EditText sendAddress = (EditText) view.findViewById(R.id.sendUserAddress2Edit);
                EditText receiveAddress = (EditText) view.findViewById(R.id.receiveUserAddress2Edit);
                EditText productName = (EditText) view.findViewById(R.id.product_name);

                String su = sendUser.getText().toString();
                String ru = receiveUser.getText().toString();
                String sa = sendAddress.getText().toString();
                String ra = receiveAddress.getText().toString();
                String pn = productName.getText().toString();

                if(su.length() >= 2 && ru.length() >= 2 && sa.length() >= 2 && ra.length() >= 2 && pn.length() >=2 ){

                    if(StaticString.MainMoreInformation == true){
                        ProductSendFragmentActivity.FragmentIndex = ProductSendFragmentActivity.Fragment_Third;
                    }
                    else{
                        ProductSendFragmentActivity.FragmentIndex = ProductSendFragmentActivity.Fragment_Second;
                    }

                    ((ProductSendFragmentActivity) ProductSendFragmentActivity.mainContext).onResume();

                    StaticString.SendUser = su;
                    StaticString.SendAddress = sa;
                    StaticString.ReceiveUser = ru;
                    StaticString.ReceiveAddress = ra;
                    StaticString.ProductName = pn;
                }

                else{
                    Toast.makeText(getActivity(), "내용을 제대로 입력해주세요", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void setSpinner(){
        Spinner sendernumber = (Spinner) view.findViewById(R.id.sendPhone);
        Spinner receivernumber = (Spinner) view.findViewById(R.id.sendPhone2);
        Spinner productWeight = (Spinner) view.findViewById(R.id.product_weight);
        Spinner productSize = (Spinner) view.findViewById(R.id.product_size);

        ProductSend_ThirdFragment productSend_thirdFragment = new ProductSend_ThirdFragment();
        productSend_thirdFragment.CustomSpinnerAdapter(sendernumber, 13, 13);
        productSend_thirdFragment.CustomSpinnerAdapter(receivernumber, 13, 13);
        productSend_thirdFragment.CustomSpinnerAdapter(productWeight, 13, 13);
        productSend_thirdFragment.CustomSpinnerAdapter(productSize, 13, 13);
    }



}
