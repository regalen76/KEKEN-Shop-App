package com.example.mobileprogrammingfinal;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SearchFragment extends Fragment {

    EditText invoice;
    Button sbmtBtn;

    private DatabaseReference mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        invoice = view.findViewById(R.id.invoicecode);
        sbmtBtn = view.findViewById(R.id.sbmtBtn);

        sbmtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("key", invoice.getText().toString());

                mDatabase = FirebaseDatabase.getInstance("https://mobileprogrammingfinal-8f1a9-default-rtdb.asia-southeast1.firebasedatabase.app").getReference("Pembelian");
                if(FirebaseAuth.getInstance().getCurrentUser() == null){ //jika gak login
                    mDatabase.child("Default").child(invoice.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if (task.isSuccessful()){
                                if(task.getResult().child("invoice").exists()){   //jika invoice benar
                                    MainActivity mainActivity = (MainActivity) getActivity();
                                    mainActivity.changeToCompletedPage(bundle);
                                }else{
                                    Toast.makeText(getActivity(),"Invoice is invalid",Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(getActivity(),"Failed To Read",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }else{
                    mDatabase.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(invoice.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                            if (task.isSuccessful()){
                                if(task.getResult().child("invoice").exists()){   //jika invoice benar
                                    MainActivity mainActivity = (MainActivity) getActivity();
                                    mainActivity.changeToCompletedPage(bundle);
                                }else{
                                    mDatabase.child("Default").child(invoice.getText().toString()).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
                                        @Override
                                        public void onComplete(@NonNull Task<DataSnapshot> task) {
                                            if (task.isSuccessful()){
                                                if(task.getResult().child("invoice").exists()){   //jika invoice benar
                                                    MainActivity mainActivity = (MainActivity) getActivity();
                                                    mainActivity.changeToCompletedPage(bundle);
                                                }else{
                                                    Toast.makeText(getActivity(),"Invoice is invalid",Toast.LENGTH_SHORT).show();
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
        });

        return view;
    }
}