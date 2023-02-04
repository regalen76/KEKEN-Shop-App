package com.example.mobileprogrammingfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TheAdapterGameMobile extends RecyclerView.Adapter<TheViewHolderGameMobile> {

    private final RecyclerViewInterfaceMobile recyclerViewInterfaceMobile;

    Context context;
    List<item> items;

    public TheAdapterGameMobile(Context context, List<item> items, RecyclerViewInterfaceMobile recyclerViewInterfaceMobile){
        this.context = context;
        this.items = items;
        this.recyclerViewInterfaceMobile = recyclerViewInterfaceMobile;
    }

    @NonNull
    @Override
    public TheViewHolderGameMobile onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_game,parent,false);
        return new TheViewHolderGameMobile(view,recyclerViewInterfaceMobile);
    }

    @Override
    public void onBindViewHolder(@NonNull TheViewHolderGameMobile holder, int position) {
        holder.gameImage.setImageResource(items.get(position).getDrawable());
        holder.judul.setText(items.get(position).getJudul());
        holder.inGameCurrency.setText(items.get(position).getCurrency());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
