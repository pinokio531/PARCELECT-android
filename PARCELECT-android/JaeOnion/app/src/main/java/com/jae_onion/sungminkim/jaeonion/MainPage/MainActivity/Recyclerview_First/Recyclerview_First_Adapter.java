package com.jae_onion.sungminkim.jaeonion.MainPage.MainActivity.Recyclerview_First;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jae_onion.sungminkim.jaeonion.R;

import java.util.ArrayList;

public class Recyclerview_First_Adapter extends RecyclerView.Adapter<Recyclerview_First_Adapter.FirstViewHolder>{

    public ArrayList<RecyclerviewItem_First> recyclerviewItem_firsts;

    public Recyclerview_First_Adapter(ArrayList<RecyclerviewItem_First> recyclerviewItem_firsts){
        this.recyclerviewItem_firsts = recyclerviewItem_firsts;
    }

    @Override
    public FirstViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View convertview = inflater.inflate(R.layout.recyclerviewitem1, parent, false);

        FirstViewHolder firstViewHolder = new FirstViewHolder(convertview);
        return firstViewHolder;
    }

    @Override
    public void onBindViewHolder(FirstViewHolder holder, int position) {

        RecyclerviewItem_First recyclerviewItem_first = recyclerviewItem_firsts.get(position);

        ImageView recyclerviewImgs = holder.imageView;
        TextView recyclerviewText = holder.textView;

        recyclerviewImgs.setBackground(recyclerviewItem_first.RecyclerImg);
        recyclerviewText.setText(recyclerviewItem_first.ComStr);

    }

    @Override
    public int getItemCount() {
        return recyclerviewItem_firsts.size();
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
}
