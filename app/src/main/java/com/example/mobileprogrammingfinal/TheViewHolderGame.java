package com.example.mobileprogrammingfinal;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TheViewHolderGame extends RecyclerView.ViewHolder {

    ImageView gameImage;
    TextView judul,inGameCurrency;

    public TheViewHolderGame(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
        super(itemView);

        gameImage = itemView.findViewById(R.id.gameimage);
        judul = itemView.findViewById(R.id.judulgame);
        inGameCurrency = itemView.findViewById(R.id.currencygame);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (recyclerViewInterface != null){
                    int pos = getAdapterPosition();

                    if (pos != RecyclerView.NO_POSITION){
                        recyclerViewInterface.onItemClick(pos);
                    }
                }
            }
        });
    }
}
