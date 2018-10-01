package com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.SecondFragment;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.jae_onion.sungminkim.jaeonion.MainPage.DrawerItem.SendProduct.SecondFragment.CompanyListItem;
import com.jae_onion.sungminkim.jaeonion.R;

import java.util.ArrayList;

public class CompanyListViewAdapter extends BaseAdapter {

    private ArrayList<CompanyListItem> companyList = new ArrayList<>();
    private int howManyCompany;
    private LayoutInflater inflater;

    public CompanyListViewAdapter(ArrayList<CompanyListItem> companyList){

        this.companyList = companyList;
        this.howManyCompany = companyList.size();

    }

    @Override
    public int getCount() {
        return howManyCompany;
    }

    @Override
    public Object getItem(int position) {
        return companyList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        if(convertView == null){
            if(inflater == null){
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.companylistviewitem, parent, false);
        }

        TextView CompanyName = (TextView) convertView.findViewById(R.id.companyName);
        ImageView CompanyImage = (ImageView) convertView.findViewById(R.id.company);
        TextView DeliveryPrice = (TextView) convertView.findViewById(R.id.deliveryPrice);
        TextView Adventage = (TextView) convertView.findViewById(R.id.saleRate);
        TextView contents = (TextView) convertView.findViewById(R.id.productContents);

        RatingBar ratingBar = (RatingBar) convertView.findViewById(R.id.ratingSize);

        CompanyName.setText(companyList.get(position).companyName);
        DeliveryPrice.setText(companyList.get(position).deliveryPrice);
        CompanyImage.setImageDrawable(companyList.get(position).companyImg);
        Adventage.setText(companyList.get(position).advantage);
        contents.setText(companyList.get(position).contents);
        ratingBar.setRating(companyList.get(position).rating);

        if(position==0){
            convertView.setBackgroundColor(Color.parseColor("#f9ff9e"));
            TextView recommend = (TextView) convertView.findViewById(R.id.recommendTextView);
            recommend.setText("추천");
            recommend.setPadding(20, 2, 20, 2);
        }

        return convertView;
    }
}
