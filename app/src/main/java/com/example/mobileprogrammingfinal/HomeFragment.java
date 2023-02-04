package com.example.mobileprogrammingfinal;

import android.content.Intent;
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

public class HomeFragment extends Fragment implements RecyclerViewInterface,RecyclerViewInterfaceMobile {

    RecyclerView recyclerViewMobile;
    RecyclerView recyclerViewPC;
    List<item> items = new ArrayList<item>();
    List<item> items2 = new ArrayList<item>();

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

        items.clear();

        items.add(new item(R.drawable.apex_logo,"Apex Legends","Apex Coins"));
        items.add(new item(R.drawable.valorant_logo,"Valorant","Valorant Point"));
        items.add(new item(R.drawable.fortnite_logo,"Fortnite","V-bucks"));
        items.add(new item(R.drawable.battle_net,"BATTLE.NET","BATTLE.NET Balance"));
        items.add(new item(R.drawable.genshin,"Genshin Impact","Genesis Crystals"));
        items.add(new item(R.drawable.steam_logo,"Steam","Steam Wallet"));

        recyclerViewPC.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewPC.setAdapter(new TheAdapterGame(getActivity().getApplicationContext(),items,this));
    }

    private void setupRecyclerViewMobile(View view) {
        recyclerViewMobile = view.findViewById(R.id.mobilecontainer);

        items2.clear();

        items2.add(new item(R.drawable.ml_logo,"Mobile Legends","Diamonds"));
        items2.add(new item(R.drawable.aov_logo,"AOV","Vouchers"));
        items2.add(new item(R.drawable.ff_logo,"Free Fire","Diamonds"));
        items2.add(new item(R.drawable.genshin,"Genshin Impact","Genesis Crystals"));
        items2.add(new item(R.drawable.pubg_logo,"PUBG Mobile","UC"));

        recyclerViewMobile.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        recyclerViewMobile.setAdapter(new TheAdapterGameMobile(getActivity().getApplicationContext(),items2,this));
    }

    @Override
    public void onItemClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("key", items.get(position).getJudul());

        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.changeToGamePage(bundle);
    }

    @Override
    public void onItemClick2(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("key", items2.get(position).getJudul());

        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.changeToGamePage(bundle);
    }
}