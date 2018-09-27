package com.jae_onion.sungminkim.jaeonion.MainPage.MainActivity.GridViewAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.jae_onion.sungminkim.jaeonion.R;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {

    private ArrayList<GridItem> gridItemArrayList;
    private int listSize;
    private LayoutInflater inflater;

    public GridAdapter(ArrayList<GridItem> gridItemArrayList){
        this.gridItemArrayList = gridItemArrayList;
        this.listSize = gridItemArrayList.size();
    }

    @Override
    public int getCount() {
        return listSize;
    }

    @Override
    public Object getItem(int position) {
        return gridItemArrayList.get(position);
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
            convertView = inflater.inflate(R.layout.gridview_item, parent, false);
        }

        ImageView iv_gridItem = (ImageView) convertView.findViewById(R.id.gridItemImage);
        TextView tv_gridItem = (TextView) convertView.findViewById(R.id.gridItemText);

        iv_gridItem.setBackground(gridItemArrayList.get(position).GridDrawer);
        tv_gridItem.setText(gridItemArrayList.get(position).GridItemName);

        return convertView;
    }
}
