package com.example.mobileprogrammingfinal;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GameFragment extends Fragment {

    FrameLayout f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16;
    TextView t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,price;
    ImageView imageBanner,i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,c1,c2,c3,c4,c5,c6,c7
            ,c8,c9,c10,c11,c12,c13,c14,c15,c16;
    Button buyBtn;

    String item = null;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, null);

        initialize(view);
        editGame(view);

        buyBtn = view.findViewById(R.id.buyBtn);
        buyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key1", price.getText().toString());
                bundle.putString("key2", item);

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeToPaymentPage(bundle);
            }
        });

        return view;
    }

    public void resetRectangle(View view, Integer count){
        int counter = 1;
        int i;
        String idRectangle ;
        int resIdRectangle;
        for (i=1; i<count; i++){
            idRectangle = "rectangle" + counter;
            resIdRectangle = getResources().getIdentifier(idRectangle, "id", getActivity().getPackageName());
            ImageView image_temp = view.findViewById(resIdRectangle);
            image_temp.setImageResource(R.drawable.rounded_rectangle);
            counter++;
        }
    }

    private void editGame(View view2){
        Bundle bundle = this.getArguments();
        String data = bundle.getString("key");

        if(data.equals("Mobile Legends")){
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c1.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1000");
                    item = t1.getText().toString();
                }
            });
            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c2.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1600");
                    item = t2.getText().toString();
                }
            });
            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c3.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2400");
                    item = t3.getText().toString();
                }
            });
            c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c4.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2800");
                    item = t4.getText().toString();
                }
            });
            c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c5.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3200");
                    item = t5.getText().toString();
                }
            });
            c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c6.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3600");
                    item = t6.getText().toString();
                }
            });
            c7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c7.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 4300");
                    item = t7.getText().toString();
                }
            });
            c8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c8.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 4600");
                    item = t8.getText().toString();
                }
            });
            c9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c9.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 5200");
                    item = t9.getText().toString();
                }
            });
            c10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c10.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 5600");
                    item = t10.getText().toString();
                }
            });
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c11.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 6100");
                    item = t11.getText().toString();
                }
            });
            c12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c12.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 6800");
                    item = t12.getText().toString();
                }
            });
            c13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c13.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 7300");
                    item = t13.getText().toString();
                }
            });
            c14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c14.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 7600");
                    item = t14.getText().toString();
                }
            });
            c15.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c15.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 8400");
                    item = t15.getText().toString();
                }
            });
            c16.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 17);
                    c16.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 8900");
                    item = t16.getText().toString();
                }
            });
        }else if(data.equals("AOV")){
            imageBanner.setImageResource(R.drawable.aov_banner_banner);
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c1.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1000");
                    item = t1.getText().toString();
                }
            });
            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c2.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1600");
                    item = t2.getText().toString();
                }
            });
            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c3.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2400");
                    item = t3.getText().toString();
                }
            });
            c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c4.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2800");
                    item = t4.getText().toString();
                }
            });
            c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c5.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3200");
                    item = t5.getText().toString();
                }
            });
            c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c6.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3600");
                    item = t6.getText().toString();
                }
            });
            c7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c7.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 4300");
                    item = t7.getText().toString();
                }
            });
            c8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c8.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 4600");
                    item = t8.getText().toString();
                }
            });
            c9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c9.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 5200");
                    item = t9.getText().toString();
                }
            });
            c10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c10.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 5600");
                    item = t10.getText().toString();
                }
            });
            f11.setVisibility(View.GONE);
            f12.setVisibility(View.GONE);
            f13.setVisibility(View.GONE);
            f14.setVisibility(View.GONE);
            f15.setVisibility(View.GONE);
            f16.setVisibility(View.GONE);
            i1.setImageResource(R.drawable.aov_currency);
            i2.setImageResource(R.drawable.aov_currency);
            i3.setImageResource(R.drawable.aov_currency);
            i4.setImageResource(R.drawable.aov_currency);
            i5.setImageResource(R.drawable.aov_currency);
            i6.setImageResource(R.drawable.aov_currency);
            i7.setImageResource(R.drawable.aov_currency);
            i8.setImageResource(R.drawable.aov_currency);
            i9.setImageResource(R.drawable.aov_currency);
            i10.setImageResource(R.drawable.aov_currency);
            t1.setText("40\nVouchers");
            t2.setText("90\nVouchers");
            t3.setText("230\nVouchers");
            t4.setText("470\nVouchers");
            t5.setText("950\nVouchers");
            t6.setText("1430\nVouchers");
            t7.setText("2390\nVouchers");
            t8.setText("4800\nVouchers");
            t9.setText("24050\nVouchers");
            t10.setText("48200\nVouchers");
        }else if(data.equals("Free Fire")){
            imageBanner.setImageResource(R.drawable.freefire_banner);
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 14);
                    c1.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1000");
                    item = t1.getText().toString();
                }
            });
            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 14);
                    c2.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1600");
                    item = t2.getText().toString();
                }
            });
            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 14);
                    c3.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2400");
                    item = t3.getText().toString();
                }
            });
            c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 14);
                    c4.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2800");
                    item = t4.getText().toString();
                }
            });
            c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 14);
                    c5.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3200");
                    item = t5.getText().toString();
                }
            });
            c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 14);
                    c6.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3600");
                    item = t6.getText().toString();
                }
            });
            c7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 14);
                    c7.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 4300");
                    item = t7.getText().toString();
                }
            });
            c8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 14);
                    c8.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 4600");
                    item = t8.getText().toString();
                }
            });
            c9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 14);
                    c9.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 5200");
                    item = t9.getText().toString();
                }
            });
            c10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 14);
                    c10.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 5600");
                    item = t10.getText().toString();
                }
            });
            c11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 14);
                    c11.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 6100");
                    item = t11.getText().toString();
                }
            });
            c12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 14);
                    c12.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 6800");
                    item = t12.getText().toString();
                }
            });
            c13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 14);
                    c13.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 7300");
                    item = t13.getText().toString();
                }
            });
            f14.setVisibility(View.GONE);
            f15.setVisibility(View.GONE);
            f16.setVisibility(View.GONE);
            i1.setImageResource(R.drawable.ff_diamond2);
            i2.setImageResource(R.drawable.ff_diamond2);
            i3.setImageResource(R.drawable.ff_diamond2);
            i4.setImageResource(R.drawable.ff_diamond2);
            i5.setImageResource(R.drawable.ff_diamond2);
            i6.setImageResource(R.drawable.ff_diamond2);
            i7.setImageResource(R.drawable.ff_diamond2);
            i8.setImageResource(R.drawable.ff_diamond2);
            i9.setImageResource(R.drawable.ff_diamond2);
            i10.setImageResource(R.drawable.ff_diamond2);
            i11.setImageResource(R.drawable.ff_diamond2);
            i12.setImageResource(R.drawable.ff_diamond2);
            i13.setImageResource(R.drawable.ff_diamond2);
            t1.setText("5\nDiamonds");
            t2.setText("12\nDiamonds");
            t3.setText("50\nDiamonds");
            t4.setText("70\nDiamonds");
            t5.setText("140\nDiamonds");
            t6.setText("355\nDiamonds");
            t7.setText("720\nDiamonds");
            t8.setText("1450\nDiamonds");
            t9.setText("2180\nDiamonds");
            t10.setText("3640\nDiamonds");
            t11.setText("7290\nDiamonds");
            t12.setText("36500\nDiamonds");
            t13.setText("73100\nDiamonds");
        }else if(data.equals("PUBG Mobile")){
            imageBanner.setImageResource(R.drawable.pubgm_banner);
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c1.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1000");
                    item = t1.getText().toString();
                }
            });
            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c2.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1600");
                    item = t2.getText().toString();
                }
            });
            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c3.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2400");
                    item = t3.getText().toString();
                }
            });
            c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c4.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2800");
                    item = t4.getText().toString();
                }
            });
            c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c5.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3200");
                    item = t5.getText().toString();
                }
            });
            c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c6.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3600");
                    item = t6.getText().toString();
                }
            });
            c7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c7.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 4300");
                    item = t7.getText().toString();
                }
            });
            c8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c8.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 4600");
                    item = t8.getText().toString();
                }
            });
            c9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c9.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 5200");
                    item = t9.getText().toString();
                }
            });
            c10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 11);
                    c10.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 5600");
                    item = t10.getText().toString();
                }
            });
            f11.setVisibility(View.GONE);
            f12.setVisibility(View.GONE);
            f13.setVisibility(View.GONE);
            f14.setVisibility(View.GONE);
            f15.setVisibility(View.GONE);
            f16.setVisibility(View.GONE);
            i1.setImageResource(R.drawable.uc_pubg2);
            i2.setImageResource(R.drawable.uc_pubg2);
            i3.setImageResource(R.drawable.uc_pubg2);
            i4.setImageResource(R.drawable.uc_pubg2);
            i5.setImageResource(R.drawable.uc_pubg2);
            i6.setImageResource(R.drawable.uc_pubg2);
            i7.setImageResource(R.drawable.uc_pubg2);
            i8.setImageResource(R.drawable.uc_pubg2);
            i9.setImageResource(R.drawable.uc_pubg2);
            i10.setImageResource(R.drawable.uc_pubg2);
            t1.setText("25\nUC");
            t2.setText("35\nUC");
            t3.setText("50\nUC");
            t4.setText("70\nUC");
            t5.setText("125\nUC");
            t6.setText("250\nUC");
            t7.setText("500\nUC");
            t8.setText("1250\nUC");
            t9.setText("2500\nUC");
            t10.setText("5000\nUC");
        }else if(data.equals("Genshin Impact")){
            imageBanner.setImageResource(R.drawable.genshin_banner);
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 7);
                    c1.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1000");
                    item = t1.getText().toString();
                }
            });
            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 7);
                    c2.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1600");
                    item = t2.getText().toString();
                }
            });
            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 7);
                    c3.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2400");
                    item = t3.getText().toString();
                }
            });
            c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 7);
                    c4.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2800");
                    item = t4.getText().toString();
                }
            });
            c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 7);
                    c5.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3200");
                    item = t5.getText().toString();
                }
            });
            c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 7);
                    c6.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3600");
                    item = t6.getText().toString();
                }
            });
            f7.setVisibility(View.GONE);
            f8.setVisibility(View.GONE);
            f9.setVisibility(View.GONE);
            f10.setVisibility(View.GONE);
            f11.setVisibility(View.GONE);
            f12.setVisibility(View.GONE);
            f13.setVisibility(View.GONE);
            f14.setVisibility(View.GONE);
            f15.setVisibility(View.GONE);
            f16.setVisibility(View.GONE);
            i1.setImageResource(R.drawable.item_genesis_crystal);
            i2.setImageResource(R.drawable.item_genesis_crystal);
            i3.setImageResource(R.drawable.item_genesis_crystal);
            i4.setImageResource(R.drawable.item_genesis_crystal);
            i5.setImageResource(R.drawable.item_genesis_crystal);
            i6.setImageResource(R.drawable.item_genesis_crystal);
            t1.setText("6480+1600\nGenesis Crystals");
            t2.setText("3280+600\nGenesis Crystals");
            t3.setText("1980+260\nGenesis Crystals");
            t4.setText("980+110\nGenesis Crystals");
            t5.setText("300+30\nGenesis Crystals");
            t6.setText("60\nGenesis Crystals");
        }else if(data.equals("Apex Legends")){
            imageBanner.setImageResource(R.drawable.apex_banner);
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 6);
                    c1.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1000");
                    item = t1.getText().toString();
                }
            });
            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 6);
                    c2.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1600");
                    item = t2.getText().toString();
                }
            });
            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 6);
                    c3.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2400");
                    item = t3.getText().toString();
                }
            });
            c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 6);
                    c4.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2800");
                    item = t4.getText().toString();
                }
            });
            c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 6);
                    c5.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3200");
                    item = t5.getText().toString();
                }
            });
            f6.setVisibility(View.GONE);
            f7.setVisibility(View.GONE);
            f8.setVisibility(View.GONE);
            f9.setVisibility(View.GONE);
            f10.setVisibility(View.GONE);
            f11.setVisibility(View.GONE);
            f12.setVisibility(View.GONE);
            f13.setVisibility(View.GONE);
            f14.setVisibility(View.GONE);
            f15.setVisibility(View.GONE);
            f16.setVisibility(View.GONE);
            i1.setImageResource(R.drawable.apex_coins);
            i2.setImageResource(R.drawable.apex_coins);
            i3.setImageResource(R.drawable.apex_coins);
            i4.setImageResource(R.drawable.apex_coins);
            i5.setImageResource(R.drawable.apex_coins);
            t1.setText("1000\nApex Coins");
            t2.setText("2150\nApex Coins");
            t3.setText("4350\nApex Coins");
            t4.setText("6700\nApex Coins");
            t5.setText("11500\nApex Coins");
        }else if(data.equals("Valorant")){
            imageBanner.setImageResource(R.drawable.valo_banner);
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 8);
                    c1.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1000");
                    item = t1.getText().toString();
                }
            });
            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 8);
                    c2.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1600");
                    item = t2.getText().toString();
                }
            });
            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 8);
                    c3.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2400");
                    item = t3.getText().toString();
                }
            });
            c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 8);
                    c4.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2800");
                    item = t4.getText().toString();
                }
            });
            c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 8);
                    c5.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3200");
                    item = t5.getText().toString();
                }
            });
            c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 8);
                    c6.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3600");
                    item = t6.getText().toString();
                }
            });
            c7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 8);
                    c7.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 4300");
                    item = t7.getText().toString();
                }
            });
            f8.setVisibility(View.GONE);
            f9.setVisibility(View.GONE);
            f10.setVisibility(View.GONE);
            f11.setVisibility(View.GONE);
            f12.setVisibility(View.GONE);
            f13.setVisibility(View.GONE);
            f14.setVisibility(View.GONE);
            f15.setVisibility(View.GONE);
            f16.setVisibility(View.GONE);
            i1.setImageResource(R.drawable.vp);
            i2.setImageResource(R.drawable.vp);
            i3.setImageResource(R.drawable.vp);
            i4.setImageResource(R.drawable.vp);
            i5.setImageResource(R.drawable.vp);
            i6.setImageResource(R.drawable.vp);
            i7.setImageResource(R.drawable.vp);
            t1.setText("125\nValorant Points");
            t2.setText("420\nValorant Points");
            t3.setText("700\nValorant Points");
            t4.setText("1375\nValorant Points");
            t5.setText("2400\nValorant Points");
            t6.setText("4000\nValorant Points");
            t7.setText("8150\nValorant Points");
        }else if(data.equals("Fortnite")){
            imageBanner.setImageResource(R.drawable.fortnite_banner);
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 5);
                    c1.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1000");
                    item = t1.getText().toString();
                }
            });
            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 5);
                    c2.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1600");
                    item = t2.getText().toString();
                }
            });
            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 5);
                    c3.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2400");
                    item = t3.getText().toString();
                }
            });
            c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 5);
                    c4.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2800");
                    item = t4.getText().toString();
                }
            });
            f5.setVisibility(View.GONE);
            f6.setVisibility(View.GONE);
            f7.setVisibility(View.GONE);
            f8.setVisibility(View.GONE);
            f9.setVisibility(View.GONE);
            f10.setVisibility(View.GONE);
            f11.setVisibility(View.GONE);
            f12.setVisibility(View.GONE);
            f13.setVisibility(View.GONE);
            f14.setVisibility(View.GONE);
            f15.setVisibility(View.GONE);
            f16.setVisibility(View.GONE);
            i1.setImageResource(R.drawable.v_bucks);
            i2.setImageResource(R.drawable.v_bucks);
            i3.setImageResource(R.drawable.v_bucks);
            i4.setImageResource(R.drawable.v_bucks);
            t1.setText("1000\nV-Bucks");
            t2.setText("2800\nV-Bucks");
            t3.setText("5000\nV-Bucks");
            t4.setText("13500\nV-Bucks");
        }else if(data.equals("BATTLE.NET")){
            imageBanner.setImageResource(R.drawable.blizzard_banner);
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 4);
                    c1.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1000");
                    item = t1.getText().toString();
                }
            });
            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 4);
                    c2.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1600");
                    item = t2.getText().toString();
                }
            });
            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 4);
                    c3.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2400");
                    item = t3.getText().toString();
                }
            });
            f4.setVisibility(View.GONE);
            f5.setVisibility(View.GONE);
            f6.setVisibility(View.GONE);
            f7.setVisibility(View.GONE);
            f8.setVisibility(View.GONE);
            f9.setVisibility(View.GONE);
            f10.setVisibility(View.GONE);
            f11.setVisibility(View.GONE);
            f12.setVisibility(View.GONE);
            f13.setVisibility(View.GONE);
            f14.setVisibility(View.GONE);
            f15.setVisibility(View.GONE);
            f16.setVisibility(View.GONE);
            i1.setImageResource(R.drawable.battle_net2);
            i2.setImageResource(R.drawable.battle_net2);
            i3.setImageResource(R.drawable.battle_net2);
            t1.setText("US 5$\nBalance");
            t2.setText("US 10$\nBalance");
            t3.setText("US 20$\nBalance");
        }else if(data.equals("Steam")){
            imageBanner.setImageResource(R.drawable.steam_banner);
            c1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 9);
                    c1.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1000");
                    item = t1.getText().toString();
                }
            });
            c2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 9);
                    c2.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 1600");
                    item = t2.getText().toString();
                }
            });
            c3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 9);
                    c3.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2400");
                    item = t3.getText().toString();
                }
            });
            c4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 9);
                    c4.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 2800");
                    item = t4.getText().toString();
                }
            });
            c5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 9);
                    c5.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3200");
                    item = t5.getText().toString();
                }
            });
            c6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 9);
                    c6.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 3600");
                    item = t6.getText().toString();
                }
            });
            c7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 9);
                    c7.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 4300");
                    item = t7.getText().toString();
                }
            });
            c8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resetRectangle(view2, 9);
                    c8.setImageResource(R.drawable.rounded_rectangle2);
                    price.setText("Price: Rp. 4600");
                    item = t8.getText().toString();
                }
            });
            f9.setVisibility(View.GONE);
            f10.setVisibility(View.GONE);
            f11.setVisibility(View.GONE);
            f12.setVisibility(View.GONE);
            f13.setVisibility(View.GONE);
            f14.setVisibility(View.GONE);
            f15.setVisibility(View.GONE);
            f16.setVisibility(View.GONE);
            i1.setImageResource(R.drawable.steam_wallet);
            i2.setImageResource(R.drawable.steam_wallet);
            i3.setImageResource(R.drawable.steam_wallet);
            i4.setImageResource(R.drawable.steam_wallet);
            i5.setImageResource(R.drawable.steam_wallet);
            i6.setImageResource(R.drawable.steam_wallet);
            i7.setImageResource(R.drawable.steam_wallet);
            i8.setImageResource(R.drawable.steam_wallet);
            t1.setText("IDR 12.000\nSteam Wallet");
            t2.setText("IDR 45.000\nSteam Wallet");
            t3.setText("IDR 60.000\nSteam Wallet");
            t4.setText("IDR 90.000\nSteam Wallet");
            t5.setText("IDR 120.000\nSteam Wallet");
            t6.setText("IDR 250.000\nSteam Wallet");
            t7.setText("IDR 400.000\nSteam Wallet");
            t8.setText("IDR 600.000\nSteam Wallet");
        }
    }

    private void initialize(View view){
        //Frame Layout
        f1 = view.findViewById(R.id.diamond1);
        f2 = view.findViewById(R.id.diamond2);
        f3 = view.findViewById(R.id.diamond3);
        f4 = view.findViewById(R.id.diamond4);
        f5 = view.findViewById(R.id.diamond5);
        f6 = view.findViewById(R.id.diamond6);
        f7 = view.findViewById(R.id.diamond7);
        f8 = view.findViewById(R.id.diamond8);
        f9 = view.findViewById(R.id.diamond9);
        f10 = view.findViewById(R.id.diamond10);
        f11 = view.findViewById(R.id.diamond11);
        f12 = view.findViewById(R.id.diamond12);
        f13 = view.findViewById(R.id.diamond13);
        f14 = view.findViewById(R.id.diamond14);
        f15 = view.findViewById(R.id.diamond15);
        f16 = view.findViewById(R.id.diamond16);

        //Text View
        t1 = view.findViewById(R.id.diamond_text1);
        t2 = view.findViewById(R.id.diamond_text2);
        t3 = view.findViewById(R.id.diamond_text3);
        t4 = view.findViewById(R.id.diamond_text4);
        t5 = view.findViewById(R.id.diamond_text5);
        t6 = view.findViewById(R.id.diamond_text6);
        t7 = view.findViewById(R.id.diamond_text7);
        t8 = view.findViewById(R.id.diamond_text8);
        t9 = view.findViewById(R.id.diamond_text9);
        t10 = view.findViewById(R.id.diamond_text10);
        t11 = view.findViewById(R.id.diamond_text11);
        t12 = view.findViewById(R.id.diamond_text12);
        t13 = view.findViewById(R.id.diamond_text13);
        t14 = view.findViewById(R.id.diamond_text14);
        t15 = view.findViewById(R.id.diamond_text15);
        t16 = view.findViewById(R.id.diamond_text16);

        //price text
        price = view.findViewById(R.id.price);

        //image banner
        imageBanner = view.findViewById(R.id.imagee);

        //image item
        i1 = view.findViewById(R.id.diamond_image1);
        i2 = view.findViewById(R.id.diamond_image2);
        i3 = view.findViewById(R.id.diamond_image3);
        i4 = view.findViewById(R.id.diamond_image4);
        i5 = view.findViewById(R.id.diamond_image5);
        i6 = view.findViewById(R.id.diamond_image6);
        i7 = view.findViewById(R.id.diamond_image7);
        i8 = view.findViewById(R.id.diamond_image8);
        i9 = view.findViewById(R.id.diamond_image9);
        i10 = view.findViewById(R.id.diamond_image10);
        i11 = view.findViewById(R.id.diamond_image11);
        i12 = view.findViewById(R.id.diamond_image12);
        i13 = view.findViewById(R.id.diamond_image13);
        i14 = view.findViewById(R.id.diamond_image14);
        i15 = view.findViewById(R.id.diamond_image15);
        i16 = view.findViewById(R.id.diamond_image16);

        //image frame
        c1 = view.findViewById(R.id.rectangle1);
        c2 = view.findViewById(R.id.rectangle2);
        c3 = view.findViewById(R.id.rectangle3);
        c4 = view.findViewById(R.id.rectangle4);
        c5 = view.findViewById(R.id.rectangle5);
        c6 = view.findViewById(R.id.rectangle6);
        c7 = view.findViewById(R.id.rectangle7);
        c8 = view.findViewById(R.id.rectangle8);
        c9 = view.findViewById(R.id.rectangle9);
        c10 = view.findViewById(R.id.rectangle10);
        c11 = view.findViewById(R.id.rectangle11);
        c12 = view.findViewById(R.id.rectangle12);
        c13 = view.findViewById(R.id.rectangle13);
        c14 = view.findViewById(R.id.rectangle14);
        c15 = view.findViewById(R.id.rectangle15);
        c16 = view.findViewById(R.id.rectangle16);
    }
}
