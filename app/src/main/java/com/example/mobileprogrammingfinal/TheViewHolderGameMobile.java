package com.example.mobileprogrammingfinal;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TheViewHolderGameMobile extends RecyclerView.ViewHolder {

    ImageView gameImage;
    TextView judul,inGameCurrency;

    public TheViewHolderGameMobile(@NonNull View itemView, RecyclerViewInterfaceMobile recyclerViewInterfaceMobile) {
        super(itemView);

        gameImage = itemView.findViewById(R.id.gameimage);
        judul = itemView.findViewById(R.id.judulgame);
        inGameCurrency = itemView.findViewById(R.id.currencygame);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (recyclerViewInterfaceMobile != null){
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION){
                        recyclerViewInterfaceMobile.onItemClick2(pos);
                    }
                }
            }
        });
    }
}
