package com.example.mobileprogrammingfinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class TheAdapterPembelian extends RecyclerView.Adapter<TheViewHolderPembelian> {

    Context context;
    List<Pembelian> pembelians;

    public TheAdapterPembelian(Context context, List<Pembelian> pembelians) {
        this.context = context;
        this.pembelians = pembelians;
    }

    @NonNull
    @Override
    public TheViewHolderPembelian onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_pembelian,parent,false);
        return new TheViewHolderPembelian(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TheViewHolderPembelian holder, int position) {
        holder.invoice.setText("Invoice: "+pembelians.get(position).getInvoice());
        holder.item.setText(pembelians.get(position).getItem());
        holder.price.setText(pembelians.get(position).getPrice());
        holder.method.setText("Method: "+pembelians.get(position).getMethod());
        holder.code.setText("Code: "+pembelians.get(position).getCode());
    }

    @Override
    public int getItemCount() {
        return pembelians.size();
    }
}
