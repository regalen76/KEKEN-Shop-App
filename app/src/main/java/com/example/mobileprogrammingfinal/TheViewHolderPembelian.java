package com.example.mobileprogrammingfinal;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TheViewHolderPembelian extends RecyclerView.ViewHolder {

    TextView invoice,item,price,method,code;

    public TheViewHolderPembelian(@NonNull View itemView) {
        super(itemView);

        invoice = itemView.findViewById(R.id.invoicecell);
        item = itemView.findViewById(R.id.itemcell);
        price = itemView.findViewById(R.id.pricecell);
        method = itemView.findViewById(R.id.methodcell);
        code = itemView.findViewById(R.id.codecell);
    }
}
