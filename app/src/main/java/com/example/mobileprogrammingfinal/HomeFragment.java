package com.example.mobileprogrammingfinal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView recyclerViewMobile;
    RecyclerView recyclerViewPC;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        setupRecyclerViewMobile(view);
        setupRecyclerViewPC(view);

        return view;
    }

    private void setupRecyclerViewPC(View view) {
        recyclerViewPC = view.findViewById(R.id.pccontainer);

        List<item> items = new ArrayList<item>();
        items.add(new item(R.drawable.apex_logo,"Apex Legends","Apex Coins"));
        items.add(new item(R.drawable.valorant_logo,"Valorant","Valorant Point"));
        items.add(new item(R.drawable.fortnite_logo,"Fortnite","V-bucks"));
        items.add(new item(R.drawable.ow_logo,"Overwatch","Overwatch Coins"));
        items.add(new item(R.drawable.genshin,"Genshin Impact","Genesis Crystals"));
        items.add(new item(R.drawable.dota,"Dota 2","Steam Wallet"));

        recyclerViewPC.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewPC.setAdapter(new TheAdapterMobile(getActivity().getApplicationContext(),items));
    }

    private void setupRecyclerViewMobile(View view) {
        recyclerViewMobile = view.findViewById(R.id.mobilecontainer);

        List<item> items = new ArrayList<item>();
        items.add(new item(R.drawable.ml_logo,"Mobile Legends","Diamonds"));
        items.add(new item(R.drawable.aov_logo,"AOV","Vouchers"));
        items.add(new item(R.drawable.ff_logo,"Free Fire","Diamonds"));
        items.add(new item(R.drawable.genshin,"Genshin Impact","Genesis Crystals"));
        items.add(new item(R.drawable.pubg_logo,"PUBG Mobile","L-Coins"));

        recyclerViewMobile.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewMobile.setAdapter(new TheAdapterMobile(getActivity().getApplicationContext(),items));
    }
}