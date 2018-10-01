package com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.ThirdFragment;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.ProductSendFragmentActivity;
import com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.StaticString;
import com.jae_onion.sungminkim.jaeonion.MainPage.MainActivity.MainActivity;
import com.jae_onion.sungminkim.jaeonion.R;

public class ProductSend_ThirdFragment extends Fragment{

    View view;
    RadioButton credit, send, noCard, token, cellphone;

    public ProductSend_ThirdFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_productsend_third, container, false);

        bt_PayComplete();
        setSpinner();
        RadioGroupOneSelecet();
        settingDeliveryContents();


        return view;
    }

    public void bt_PayComplete(){
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.bt_payComplete);
        final CheckBox checkBox1 = (CheckBox) view.findViewById(R.id.checkbox1);
        final CheckBox checkBox2 = (CheckBox) view.findViewById(R.id.checkbox2);
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                if(checkBox1.isChecked() && checkBox2.isChecked()){
                    startActivity(new Intent(getActivity(), MainActivity.class));
                    Toast.makeText(getActivity(), "결제가 완료되었습니다.", Toast.LENGTH_SHORT).show();
                    getActivity().finish();
                }
                else{
                    Toast.makeText(getActivity(), "정보제공 동의란을 모두 체크해주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void setSpinner(){
        Spinner period = (Spinner) view.findViewById(R.id.spinnerPeriod);
        Spinner card = (Spinner) view.findViewById(R.id.spinnerCard);

        CustomSpinnerAdapter(period, 15, 20);
        CustomSpinnerAdapter(card, 15, 20);


    }

    //spinner 사이즈 조절
    public void CustomSpinnerAdapter(Spinner spinner, final int selectedTextSize, final int nothingTextSize){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ((TextView) view).setTextSize(selectedTextSize);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                ((TextView) view).setTextSize(nothingTextSize);

            }
        });

    }

    //배열로 하다가 급해서 일단 ischecked 쑤셔박음 -> 수정예정 / radiobutton 하나만 선택되게 기능
    public void RadioGroupOneSelecet(){
        credit = (RadioButton) view.findViewById(R.id.credit);
        send = (RadioButton) view.findViewById(R.id.sendMoney);
        noCard = (RadioButton) view.findViewById(R.id.noCard);
        token = (RadioButton) view.findViewById(R.id.tokenPay);
        cellphone = (RadioButton) view.findViewById(R.id.cellphonePay);


        credit.setChecked(true);

        credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credit.setChecked(true);
                send.setChecked(false);
                noCard.setChecked(false);
                token.setChecked(false);
                cellphone.setChecked(false);
            }
        });

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                credit.setChecked(false);
                send.setChecked(true);
                noCard.setChecked(false);
                token.setChecked(false);
                cellphone.setChecked(false);

            }
        });

        noCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credit.setChecked(false);
                send.setChecked(false);
                noCard.setChecked(true);
                token.setChecked(false);
                cellphone.setChecked(false);
            }
        });

        token.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credit.setChecked(false);
                send.setChecked(false);
                noCard.setChecked(false);
                token.setChecked(true);
                cellphone.setChecked(false);
            }
        });

        cellphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                credit.setChecked(false);
                send.setChecked(false);
                noCard.setChecked(false);
                token.setChecked(false);
                cellphone.setChecked(true);
            }
        });

    }

    public void settingDeliveryContents(){

        TextView companyName = (TextView) view.findViewById(R.id.companyName);
        ImageView companyImg = (ImageView) view.findViewById(R.id.company);
        TextView SenderReceiver = (TextView) view.findViewById(R.id.deliveryPrice);
        TextView productName = (TextView) view.findViewById(R.id.productContents);
        TextView receiveDate = (TextView) view.findViewById(R.id.saleRate);
        TextView lastPrice = (TextView) view.findViewById(R.id.LastPrice);

        companyName.setText(StaticString.DeliveryCompany);
        companyImg.setImageDrawable(StaticString.CompanyImg);
        productName.setText("상품명 : " + StaticString.ProductName);
        SenderReceiver.setText("보내는 분 : " + StaticString.SendUser + "                     " + "받는 분 : " + StaticString.ReceiveUser );
        receiveDate.setText("예상배송기간 : 1 ~ 3일             보험여부 : 적용");
        lastPrice.setText(StaticString.LastPrice.replace("가격 ", ""));

    }

}
