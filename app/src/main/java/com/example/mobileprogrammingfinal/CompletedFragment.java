package com.example.mobileprogrammingfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CompletedFragment extends Fragment {

    TextView invoiceText, itemText, priceText, paymentText, codeText;

    private DatabaseReference mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_completed, container, false);

        setData(view);

        return view;
    }

    private void setData(View view) {
        String[] trueData = new String[5];

        Bundle bundle = this.getArguments();
        String data = bundle.getString("key");

        mDatabase = FirebaseDatabase.getInstance("https://mobileprogrammingfinal-8f1a9-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Pembelian");
        if(FirebaseAuth.getInstance().getCurrentUser() == null){ //jika gak login
            mDatabase.child("Default").child(data).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()){
                        if(task.getResult().child("invoice").exists()){   //jika invoice benar
                            DataSnapshot dataSnapshot = task.getResult();
                            trueData[0] = String.valueOf(dataSnapshot.child("invoice").getValue());
                            trueData[1] = String.valueOf(dataSnapshot.child("item").getValue());
                            trueData[2] = String.valueOf(dataSnapshot.child("price").getValue());
                            trueData[3] = String.valueOf(dataSnapshot.child("method").getValue());
                            trueData[4] = String.valueOf(dataSnapshot.child("code").getValue());

                            setTextView(view, trueData);
                        }else{
                            Toast.makeText(getActivity(),"Invoice Doesn't Exist",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getActivity(),"Failed To Read",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }else{
            mDatabase.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(data).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DataSnapshot> task) {
                    if (task.isSuccessful()){
                        if(task.getResult().child("invoice").exists()){   //jika invoice benar
                            DataSnapshot dataSnapshot = task.getResult();
                            trueData[0] = String.valueOf(dataSnapshot.child("invoice").getValue());
                            trueData[1] = String.valueOf(dataSnapshot.child("item").getValue());
                            trueData[2] = String.valueOf(dataSnapshot.child("price").getValue());
                            trueData[3] = String.valueOf(dataSnapshot.child("method").getValue());
                            trueData[4] = String.valueOf(dataSnapshot.child("code").getValue());

                            setTextView(view, trueData);
                        }else{ //jika gak ada cari di default
                            mDatabase.child("Default").child(data).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DataSnapshot> task) {
                                    if (task.isSuccessful()){
                                        if(task.getResult().child("invoice").exists()){   //jika invoice benar
                                            DataSnapshot dataSnapshot = task.getResult();
                                            trueData[0] = String.valueOf(dataSnapshot.child("invoice").getValue());
                                            trueData[1] = String.valueOf(dataSnapshot.child("item").getValue());
                                            trueData[2] = String.valueOf(dataSnapshot.child("price").getValue());
                                            trueData[3] = String.valueOf(dataSnapshot.child("method").getValue());
                                            trueData[4] = String.valueOf(dataSnapshot.child("code").getValue());

                                            setTextView(view, trueData);
                                        }else{
                                            Toast.makeText(getActivity(),"Invoice Doesn't Exist",Toast.LENGTH_SHORT).show();
                                        }
                                    }else{
                                        Toast.makeText(getActivity(),"Failed To Read",Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });
                        }
                    }else{
                        Toast.makeText(getActivity(),"Failed To Read",Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setTextView(View view, String[] data) {
        invoiceText = view.findViewById(R.id.invoiceText);
        itemText = view.findViewById(R.id.itemNameText);
        priceText = view.findViewById(R.id.itemPriceText);
        paymentText = view.findViewById(R.id.paymentMethodText);
        codeText = view.findViewById(R.id.codeText);

        invoiceText.setText("Invoice: " + data[0]);
        itemText.setText(data[1]);
        priceText.setText(data[2]);
        paymentText.setText("Payment Method: " +data[3]);
        codeText.setText(data[4]);
    }
}