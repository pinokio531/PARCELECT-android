package com.jae_onion.sungminkim.jaeonion;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ProductReceiveActivity extends AppCompatActivity {

    private String getDateStateString;
    private String ymd;
    private String hms;
    private String place;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productreceive);

        ComponentSetting();

    }

    public String getDateStateString(String ymd, String hms, String place) {

        this.ymd = ymd;
        this.hms = hms;
        this.place = place;

        String date = ymd + " " + hms + " " + " " + place;

        return date;
    }

    //private으로 전역 변수 없이 그냥 해도 상관은 없음. 전역변수 설정하는 거 연습 중.

    /*public String getDateStateString(String ymd, String hms, String place){

        String date = ymd + " " + hms + " " + " " + place;

        return date;
    }*/


    public void ComponentSetting(){
        TextView tv_contents = (TextView) findViewById(R.id.productContents);
        TextView tv_date = (TextView) findViewById(R.id.receiveDate);

        TextView tv_sendDate1 = (TextView) findViewById(R.id.date1);
        TextView tv_sendDate2 = (TextView) findViewById(R.id.date2);
        TextView tv_sendDate3 = (TextView) findViewById(R.id.date3);
        TextView tv_sendDate4 = (TextView) findViewById(R.id.date4);
        TextView tv_sendDate5 = (TextView) findViewById(R.id.date5);
        TextView tv_sendDate6 = (TextView) findViewById(R.id.date6);
        TextView tv_sendDate7 = (TextView) findViewById(R.id.date7);

        TextView tv_state1 = (TextView) findViewById(R.id.state1);
        TextView tv_state2 = (TextView) findViewById(R.id.state2);
        TextView tv_state3 = (TextView) findViewById(R.id.state3);
        TextView tv_state4 = (TextView) findViewById(R.id.state4);
        TextView tv_state5 = (TextView) findViewById(R.id.state5);
        TextView tv_state6 = (TextView) findViewById(R.id.state6);
        TextView tv_state7 = (TextView) findViewById(R.id.state7);

        tv_sendDate1.setText(getDateStateString("2018.9.4", "14:03:21", "애플코리아"));
        tv_sendDate2.setText(getDateStateString("2018:9.4", "16:23:51", "서울강서개중앙"));
        tv_sendDate3.setText(getDateStateString("2018:9.4", "20:06:11", "강서 A"));
        tv_sendDate4.setText(getDateStateString("2018:9.5", "06:12:37", "대전 HUB"));
        tv_sendDate5.setText(getDateStateString("2018:9.5", "18:57:09", "대전 HUB"));
        tv_sendDate6.setText(getDateStateString("2018:9.6", "08:48:33", "마포 B"));
        tv_sendDate7.setText(getDateStateString("2018:9.6", "10:15:40", "서울마포"));

        tv_state1.setText("상품인수");
        tv_state2.setText("집화처리");
        tv_state3.setText("간선상차");
        tv_state4.setText("간선하차");
        tv_state5.setText("간선상차");
        tv_state6.setText("간선하차");
        tv_state7.setText("배달출발");

    }
}
