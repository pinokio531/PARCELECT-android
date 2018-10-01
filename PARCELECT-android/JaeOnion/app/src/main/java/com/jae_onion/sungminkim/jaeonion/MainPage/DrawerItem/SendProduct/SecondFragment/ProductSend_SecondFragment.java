package com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.SecondFragment;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.ProductSendFragmentActivity;
import com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.ThirdFragment.ProductSend_ThirdFragment;
import com.jae_onion.sungminkim.jaeonion.R;
import com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.StaticString;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class ProductSend_SecondFragment extends Fragment {

    ArrayList<CompanyListItem> companyList = null;
    CompanyListItem companyListItem;
    View view;
    ListView companyListView;
    ImageView company_img;
    TextView company_name, price;
    public static ProductSend_SecondFragment productSend_secondFragment = new ProductSend_SecondFragment();

    public static boolean inflatedView = false;
    public static RelativeLayout relativeLayout;
    public static View convertView;

    public ProductSend_SecondFragment(){

    }

    public static ProductSend_SecondFragment getInstance(){
        return productSend_secondFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_productsend_second, container, false);
        companyListView  = (ListView) view.findViewById(R.id.companyListview);

        clickItem();

        setListView();


        return view;
    }

    public void setListView(){

        companyList = new ArrayList<>();

        String ad1 = "일반배송";
        String ad2 = "당일배송";
        String ad3 = "무인택배함";
        String ad4 = "보험적용가능";
        String ad5 = "드론배송";
        String ad6 = "퀵서비스";
        String ad7 = "지하철 배송";
        String blank = "  ";

        setCompanyItem("CJ 대한통운", "후기 213건", "가격 3,500원",
                ad1+blank+ad2+blank+ad3+blank+ad4, getActivity().getResources().getDrawable(R.drawable.company_drone2), (float)5);

        setCompanyItem("우체국 택배", "후기 135건", "가격 4,000원",
                ad1+blank+ad2+blank+ad3+blank+ad4+blank+ad5, getActivity().getResources().getDrawable(R.drawable.compan_drone), (float)4.5);

        setCompanyItem("로젠택배", "후기 177건", "가격 3,500원",
                ad1+blank+ad2+blank+ad3+blank+ad4, getActivity().getResources().getDrawable(R.drawable.company_normal2), (float) 4);

        setCompanyItem("퀵서비스 퀵퀵", "후기 119건", "가격 7,000원",
                ad6+blank+ad2+blank+ad7, getActivity().getResources().getDrawable(R.drawable.company_quick2), (float) 3.8);

        setCompanyItem("한진택배", "후기 81건", "가격 4,500원",
                ad1+blank+ad2+blank+ad3+blank+ad4, getActivity().getResources().getDrawable(R.drawable.company_normal), (float) 3.5);

    }

    public void setCompanyItem(String cName, String cContents, String dPrice, String ad, Drawable cImg, Float rate){
        companyListItem = new CompanyListItem();

        companyListItem.companyName = cName;
        companyListItem.deliveryPrice = dPrice;
        companyListItem.advantage = ad;
        companyListItem.contents = cContents;
        companyListItem.companyImg = cImg;
        companyListItem.rating = rate;

        companyList.add(companyListItem);

        CompanyListViewAdapter adapter = new CompanyListViewAdapter(companyList);

        companyListView.setAdapter(adapter);
    }

    public void clickItem(){
        companyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View subView, int position, long id) {
                inflatedView = true;
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.pay_click, null);

                relativeLayout = (RelativeLayout) view.findViewById(R.id.clickActivity);
                relativeLayout.addView(convertView);

                setInflatedView(position);

                bt_payListener();



            }
        });
    }

    public void setInflatedView(int position){
        company_name = (TextView) convertView.findViewById(R.id.companyName);
        company_img = (ImageView) convertView.findViewById(R.id.company);
        TextView sender = (TextView) convertView.findViewById(R.id.productContents);
        TextView receiver = (TextView) convertView.findViewById(R.id.deliveryPrice);
        price = (TextView) convertView.findViewById(R.id.saleRate);

        company_name.setText(companyList.get(position).companyName);
        company_img.setImageDrawable(companyList.get(position).companyImg);
        price.setText(companyList.get(position).deliveryPrice);

        /*putBundle.putString("SendUserName", sendUser.getText().toString());
        putBundle.putString("ReceiveUserName", receiveUser.getText().toString());
        putBundle.putString("SendAddress", sendAddress.getText().toString());
        putBundle.putString("ReceiveAddress", receiveAddress.getText().toString());*/


        String s_name = StaticString.SendUser;
        String r_name = StaticString.ReceiveUser;
        String s_address = StaticString.SendAddress;
        String r_address = StaticString.ReceiveAddress;

        sender.setText(s_name + " : " + s_address);
        receiver.setText(r_name + " : " + r_address);


        setSpinner();

        removeView();
    }

    public void bt_payListener(){
        FrameLayout frameLayout = (FrameLayout) convertView.findViewById(R.id.bt_pay);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ProductSendFragmentActivity.FragmentIndex = ProductSendFragmentActivity.Fragment_Third;
                ((ProductSendFragmentActivity) ProductSendFragmentActivity.mainContext).onResume();

                StaticString.DeliveryCompany = company_name.getText().toString();
                StaticString.CompanyImg = company_img.getDrawable();
                StaticString.LastPrice = price.getText().toString();
                inflatedView = false;
            }
        });
    }

    public void removeView(){
        View backView = (View) convertView.findViewById(R.id.backgroundView);
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.removeView(convertView);
                inflatedView = false;
                companyList.clear();
            }
        });

        RelativeLayout backgroundBottom = (RelativeLayout) convertView.findViewById(R.id.company_contents);
        backgroundBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void setSpinner(){
        Spinner delivery = (Spinner) convertView.findViewById(R.id.delivery);
        Spinner insurance = (Spinner) convertView.findViewById(R.id.insuranceExist);
        Spinner date = (Spinner) convertView.findViewById(R.id.dateSpinner);

        ProductSend_ThirdFragment productSend_thirdFragment = new ProductSend_ThirdFragment();
        productSend_thirdFragment.CustomSpinnerAdapter(delivery, 15, 20);
        productSend_thirdFragment.CustomSpinnerAdapter(insurance, 15, 20);
        productSend_thirdFragment.CustomSpinnerAdapter(date, 15, 20);

    }

}
