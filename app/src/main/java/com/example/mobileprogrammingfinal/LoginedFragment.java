package com.example.mobileprogrammingfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginedFragment extends Fragment {

    TextView emailUser;
    Button logout;

    TheAdapterPembelian myAdapter;
    RecyclerView recyclerViewPembelian;
    List<Pembelian> pembelians = new ArrayList<Pembelian>();

    private DatabaseReference mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_logined, container, false);

        mDatabase = FirebaseDatabase.getInstance("https://mobileprogrammingfinal-8f1a9-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Pembelian");

        emailUser = view.findViewById(R.id.emailuser);
        logout = view.findViewById(R.id.logoutbtn);

        emailUser.setText("Email: " +FirebaseAuth.getInstance().getCurrentUser().getEmail());
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeToLoginPage();
            }
        });

        setupRecyclerViewPembelian(view);

        return view;
    }

    private void setupRecyclerViewPembelian(View view) {
        pembelians.clear();

        recyclerViewPembelian = view.findViewById(R.id.historycontainer);
        myAdapter =  new TheAdapterPembelian(getActivity().getApplicationContext(),pembelians);

        recyclerViewPembelian.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerViewPembelian.setAdapter(myAdapter);

        mDatabase.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Pembelian pembelian = dataSnapshot.getValue(Pembelian.class);
                    pembelians.add(pembelian);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}