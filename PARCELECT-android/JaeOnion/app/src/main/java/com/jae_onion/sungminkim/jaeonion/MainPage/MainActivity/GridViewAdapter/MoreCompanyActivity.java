package com.jae_onion.sungminkim.jaeonion.MainPage.MainActivity.GridViewAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jae_onion.sungminkim.jaeonion.R;

import java.util.ArrayList;

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class MoreCompanyActivity extends AppCompatActivity {

    private ArrayList<GridItem> GridList;
    private GridItem gridItem;
    private GridView gridView;
    private View attachView;
    private RelativeLayout background;
    private Boolean attachedView = true;
    private ImageView[] imageViews = null;
    private ArrayList<Drawable> drawables = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_company);
        GridList = new ArrayList<>();

        settingGridView();
        GridViewItemSelect();
    }

    public void settingGridView(){
        GridList("무인택배함", getDrawable(R.drawable.more_nopeople));
        GridList("카드롭", getDrawable(R.drawable.more_cardrop));
        GridList("드론택배", getDrawable(R.drawable.more_drone));
        GridList("퀵서비스", getDrawable(R.drawable.more_quickservice));
        GridList("일반택배", getDrawable(R.drawable.more_package));
        GridList("소셜물류", getDrawable(R.drawable.more_social));
        GridList("당일배송", getDrawable(R.drawable.more_daytoday));
    }

    public void GridList(String How, Drawable img){

        gridView = (GridView) findViewById(R.id.gridSample);
        gridItem = new GridItem();

        gridItem.GridItemName = How;
        gridItem.GridDrawer = img;
        GridList.add(gridItem);

        GridAdapter gridAdapter = new GridAdapter(GridList);
        gridView.setAdapter(gridAdapter);
    }

    public void GridViewItemSelect(){
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickItemStr = GridList.get(position).GridItemName.toString();
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                attachView = inflater.inflate(R.layout.more_compant_click, parent, false);
                TextView method = (TextView) attachView.findViewById(R.id.howMethod);
                method.setText(clickItemStr);
                ImageArray(clickItemStr);
                ImgSetting();

                background = (RelativeLayout) findViewById(R.id.useCompany);
                background.addView(attachView);

                attachedView = true;

                bt_useCompanyListener();
                removeAttachView();

            }
        });
    }

    public void removeAttachView(){
        RelativeLayout below_backview = (RelativeLayout) attachView.findViewById(R.id.company_contents);
        View backView = (View) attachView.findViewById(R.id.backgroundView);
        backView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.removeView(attachView);
                attachedView = false;
            }
        });

        below_backview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void ImgSetting(){
        LinearLayout srcImg = (LinearLayout) attachView.findViewById(R.id.companyImage);
        imageViews = new ImageView[2];
        int width = 300;
        int height = 300;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        params.setMargins( 30, 30, 30, 30);

        for(int i =0; i<drawables.size(); i++){
            imageViews[i] = new ImageView(this);
            imageViews[i].setLayoutParams(params);

            /*
            imageViews[i].setImageResource(R.drawable.loginfacebook);
            imageViews[i].setImageDrawable(getResources().getDrawable(R.drawable.loginfacebook));
            imageViews[i].setBackground(getResources().getDrawable(R.drawable.loginfacebook));
            imageViews[i].setBackgroundResource(R.drawable.loginfacebook);
            imageViews[i].setImageDrawable(getDrawable(R.drawable.loginfacebook));
            */

            imageViews[i].setImageDrawable(drawables.get(i));
            imageViews[i].setBackgroundResource(R.drawable.menu_background);
            imageViews[i].setPadding(30, 10, 30, 10);

            srcImg.addView(imageViews[i]);
            ImageClickListener(i);

        }

    }

    public void ImageArray(String str){
        drawables = new ArrayList<>();

        switch (str){
            case "무인택배함":
                drawables.add(getResources().getDrawable(R.drawable.company_normal));
                drawables.add(getResources().getDrawable(R.drawable.company_normal2));
                break;

            case "카드롭":
                drawables.add(getResources().getDrawable(R.drawable.company_cardrop));
                break;

            case "드론택배":
                drawables.add(getResources().getDrawable(R.drawable.compan_drone));
                drawables.add(getResources().getDrawable(R.drawable.company_drone2));
                break;

            case "퀵서비스":
                drawables.add(getResources().getDrawable(R.drawable.company_quick));
                drawables.add(getResources().getDrawable(R.drawable.company_quick2));
                break;

            case "일반택배":
                drawables.add(getResources().getDrawable(R.drawable.company_normal));
                drawables.add(getResources().getDrawable(R.drawable.company_normal2));
                break;

            case "소셜물류":
                drawables.add(getResources().getDrawable(R.drawable.company_social));
                drawables.add(getResources().getDrawable(R.drawable.company_social2));
                break;

            case "당일배송":
                drawables.add(getResources().getDrawable(R.drawable.company_normal));
                drawables.add(getResources().getDrawable(R.drawable.company_normal2));
                break;

        }
    }

    public void ImageClickListener(int position2){
        imageViews[position2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int k=0; k<drawables.size(); k++){
                    imageViews[k].setBackground(getDrawable(R.drawable.menu_background));
                }
                v.setBackgroundColor(getResources().getColor(R.color.actionbarColor));
            }
        });
    }

    public void bt_useCompanyListener(){
        FrameLayout bt_useCompany = (FrameLayout) attachView.findViewById(R.id.bt_useCompany);
        bt_useCompany.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if(attachedView == false){
            super.onBackPressed();
        }

        else{
            background.removeView(attachView);
            attachedView = false;
        }
    }
}
