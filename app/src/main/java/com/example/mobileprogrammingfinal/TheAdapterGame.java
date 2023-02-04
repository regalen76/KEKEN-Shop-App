package com.example.mobileprogrammingfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TheAdapterGame extends RecyclerView.Adapter<TheViewHolderGame> {

    private final RecyclerViewInterface recyclerViewInterface;

    Context context;
    List<item> items;

    public TheAdapterGame(Context context, List<item> items, RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.items = items;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public TheViewHolderGame onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_game,parent,false);
        return new TheViewHolderGame(view,recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull TheViewHolderGame holder, int position) {
        holder.gameImage.setImageResource(items.get(position).getDrawable());
        holder.judul.setText(items.get(position).getJudul());
        holder.inGameCurrency.setText(items.get(position).getCurrency());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}
