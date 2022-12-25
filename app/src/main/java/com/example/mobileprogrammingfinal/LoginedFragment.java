package com.example.mobileprogrammingfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LoginedFragment extends Fragment {

    TextView emailUser;
    Button logout,test;

    private DatabaseReference mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_logined, container, false);

        mDatabase = FirebaseDatabase.getInstance("https://mobileprogrammingfinal-8f1a9-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();

        emailUser = view.findViewById(R.id.emailuser);
        logout = view.findViewById(R.id.logoutbtn);

        emailUser.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();

                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeToLoginPage();
            }
        });

        //dibawah ini bagian sementara, cuma mau coba add data ke firebase
        test = view.findViewById(R.id.testbtn);

        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pembelian pembelian = new Pembelian(32131,100,"Mobile Legend","Diamonds");

                mDatabase.child("Pembelian").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(String.valueOf(pembelian.getInvoce())).setValue(pembelian, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        Log.d("zerotwo2","Value was set. Error = "+error);
                    }
                });
            }
        });

        return view;
    }

}