package com.jae_onion.sungminkim.jaeonion.MainPage.MainActivity.Recyclerview_First;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jae_onion.sungminkim.jaeonion.R;

import java.util.ArrayList;

public class Recyclerview_First_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    public ArrayList<RecyclerviewItem_First> recyclerviewItem_firsts;

    public Recyclerview_First_Adapter(ArrayList<RecyclerviewItem_First> recyclerviewItem_firsts){
        this.recyclerviewItem_firsts = recyclerviewItem_firsts;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType){
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem1, parent, false);
                viewHolder = new FirstViewHolder(view);
                break;

            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerviewitem1, parent, false);
                viewHolder = new OtherViewHolder(view);
                break;
        }

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof FirstViewHolder){
            RecyclerviewItem_First recyclerviewItem_first = recyclerviewItem_firsts.get(position);
            ImageView imageView1 = ((FirstViewHolder) holder).imageView;
            imageView1.setBackground(recyclerviewItem_first.RecyclerImg);

            TextView textView1 = ((FirstViewHolder) holder).textView;
            textView1.setText(recyclerviewItem_first.ComStr);
        }
        else if(holder instanceof OtherViewHolder){
            RecyclerviewItem_First recyclerviewItem_first = recyclerviewItem_firsts.get(position);
            ImageView otherImageView = ((OtherViewHolder) holder).OtherImageView;
            otherImageView.setBackground(recyclerviewItem_first.RecyclerImg);
        }

    }

    @Override
    public int getItemCount() {
        return recyclerviewItem_firsts.size();
    }

    @Override
    public int getItemViewType(int position) {
        int viewType;

        if(position ==1){
            viewType = 2;
        }
        else{
            viewType = 1;
        }
        return viewType;
    }

    class FirstViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;
        public TextView textView;

        public FirstViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.recyclerviewImg);
            textView = itemView.findViewById(R.id.recyclerviewText);
        }
    }

    class OtherViewHolder extends  RecyclerView.ViewHolder{

        public ImageView OtherImageView;

        public OtherViewHolder(View itemView) {
            super(itemView);

            OtherImageView = itemView.findViewById(R.id.recyclerviewImg);
        }
    }
}
