package com.jae_onion.sungminkim.jaeonion;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainBannerAdapter extends PagerAdapter {

    private ArrayList<MainBannerItem> bannerItems;
    private int listSize;
    private LayoutInflater inflater = null;

    public MainBannerAdapter(ArrayList<MainBannerItem> bannerItems){
        this.bannerItems = bannerItems;
        this.listSize = bannerItems.size();
    }

    @Override
    public int getCount() {
        return listSize;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        Context context = container.getContext();

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.viewpageritem, container, false);

        ImageView banner = (ImageView) view.findViewById(R.id.bannerImage);
        banner.setBackground(bannerItems.get(position).bannerImage);

        container.addView(view);

        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
