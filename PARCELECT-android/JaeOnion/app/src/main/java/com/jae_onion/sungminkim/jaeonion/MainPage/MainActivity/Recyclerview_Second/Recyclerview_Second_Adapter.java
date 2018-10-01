package com.jae_onion.sungminkim.jaeonion.MainPage.MainActivity.Recyclerview_Second;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jae_onion.sungminkim.jaeonion.MainPage.MainActivity.Recyclerview_First.RecyclerviewItem_First;
import com.jae_onion.sungminkim.jaeonion.MainPage.MainActivity.Recyclerview_First.Recyclerview_First_Adapter;
import com.jae_onion.sungminkim.jaeonion.R;

import java.util.ArrayList;

public class Recyclerview_Second_Adapter extends RecyclerView.Adapter<Recyclerview_Second_Adapter.SecondViewHolder> {

    public ArrayList<RecyclerviewItem_Second> recyclerviewItem_seconds;

    public Recyclerview_Second_Adapter(ArrayList<RecyclerviewItem_Second> recyclerviewItem_seconds){
        this.recyclerviewItem_seconds = recyclerviewItem_seconds;
    }

    @Override
    public SecondViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View convertview = inflater.inflate(R.layout.recyclerviewitem2, parent, false);

        Recyclerview_Second_Adapter.SecondViewHolder secondViewHolder = new Recyclerview_Second_Adapter.SecondViewHolder(convertview);

        return secondViewHolder;
    }

    @Override
    public void onBindViewHolder(SecondViewHolder holder, int position) {
        RecyclerviewItem_Second recyclerviewItem_second = recyclerviewItem_seconds.get(position);

        ImageView recyclerviewImgs = holder.imageView;

        recyclerviewImgs.setBackground(recyclerviewItem_second.RecyclerImg);

    }

    @Override
    public int getItemCount() {
        return recyclerviewItem_seconds.size();
    }

    class SecondViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public SecondViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.recyclerviewImg);
        }
    }
}
