package com.example.mobileprogrammingfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TheAdapterMobile extends RecyclerView.Adapter<TheViewHolderMobile> {

    Context context;
    List<item> items;

    public TheAdapterMobile(Context context, List<item> items){
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public TheViewHolderMobile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TheViewHolderMobile(LayoutInflater.from(context).inflate(R.layout.item_mobile,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull TheViewHolderMobile holder, int position) {
        holder.gameImage.setImageResource(items.get(position).getDrawable());
        holder.judul.setText(items.get(position).getJudul());
        holder.inGameCurrency.setText(items.get(position).getCurrency());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
