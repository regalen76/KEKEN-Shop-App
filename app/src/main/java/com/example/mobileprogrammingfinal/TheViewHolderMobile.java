package com.example.mobileprogrammingfinal;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TheViewHolderMobile extends RecyclerView.ViewHolder {

    ImageView gameImage;
    TextView judul,inGameCurrency;

    public TheViewHolderMobile(@NonNull View itemView) {
        super(itemView);

        gameImage = itemView.findViewById(R.id.gameimage);
        judul = itemView.findViewById(R.id.judulgame);
        inGameCurrency = itemView.findViewById(R.id.currencygame);
    }
}
