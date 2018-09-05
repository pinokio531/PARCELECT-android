package com.jae_onion.sungminkim.jaeonion;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ShoppingListAdapter extends BaseAdapter {

    private ArrayList<ShoppingItem> shoppingItemList;
    private int listSize;
    private LayoutInflater inflater = null;

    public ShoppingListAdapter(ArrayList<ShoppingItem> shoppingItemList){
        this.shoppingItemList = shoppingItemList;
        this.listSize = shoppingItemList.size();
    }

    @Override
    public int getCount() {
        return listSize;
    }

    @Override
    public Object getItem(int position) {
        return shoppingItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = parent.getContext();

        //메인 함수에서 convertView 자리에 별도의 view를 넣지 않으면 작동
        if(convertView == null){
            if(inflater == null){
                inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            }
            convertView = inflater.inflate(R.layout.listviewitem, parent, false);
        }

        //지정한 convertView(없을시 R.layout.listviewitem 에서 정의된 view가 convertView가 됨)에 있는 view들을 지정해준다.
        ImageView iv_brand = (ImageView) convertView.findViewById(R.id.brand);
        ImageView iv_product = (ImageView) convertView.findViewById(R.id.product);
        TextView tv_contents = (TextView) convertView.findViewById(R.id.productContents);
        TextView tv_originalPrice = (TextView) convertView.findViewById(R.id.originalPrice);
        TextView tv_salePrice = (TextView) convertView.findViewById(R.id.salePrice);
        TextView tv_saleRate = (TextView) convertView.findViewById(R.id.saleRate);

        iv_brand.setImageDrawable(shoppingItemList.get(position).brand);
        iv_product.setImageDrawable(shoppingItemList.get(position).product);

        tv_contents.setText(shoppingItemList.get(position).contents);
        tv_originalPrice.setText(shoppingItemList.get(position).originalPrice);
        tv_salePrice.setText(shoppingItemList.get(position).salePrice);
        tv_saleRate.setText(shoppingItemList.get(position).saleRate);

        return convertView;
    }
}
