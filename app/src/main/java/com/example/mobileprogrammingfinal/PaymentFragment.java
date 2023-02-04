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
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PaymentFragment extends Fragment {

    RadioGroup radioGroup;
    RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5;

    Button submitBtn;

    String paymentMethod;

    private DatabaseReference mDatabase;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);

        setRadio(view);
        String[] data = setData();
        radioFunc();

        mDatabase = FirebaseDatabase.getInstance("https://mobileprogrammingfinal-8f1a9-default-rtdb.asia-southeast1.firebasedatabase.app").getReference();

        submitBtn = view.findViewById(R.id.submitBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(FirebaseAuth.getInstance().getCurrentUser() == null){  //jika gak login
                    String invoice = createInvoice();
                    String code = createCode();

                    Pembelian pembelian = new Pembelian(invoice,data[1],data[0],code,paymentMethod);

                    mDatabase.child("Pembelian").child("Default").child(String.valueOf(pembelian.getInvoice())).setValue(pembelian, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                            Bundle bundle = new Bundle();
                            bundle.putString("key", invoice);

                            MainActivity mainActivity = (MainActivity) getActivity();
                            mainActivity.changeToCompletedPage(bundle);
                        }
                    });
                }else{
                    String invoice = createInvoice();
                    String code = createCode();

                    Pembelian pembelian = new Pembelian(invoice,data[1],data[0],code,paymentMethod);

                    mDatabase.child("Pembelian").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(String.valueOf(pembelian.getInvoice())).setValue(pembelian, new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                            Bundle bundle = new Bundle();
                            bundle.putString("key", invoice);

                            MainActivity mainActivity = (MainActivity) getActivity();
                            mainActivity.changeToCompletedPage(bundle);
                        }
                    });
                }
            }
        });
        return view;
    }

    private String createCode()
    {
        int n = 5;

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        String string1,string2,string3;

        StringBuilder sb = new StringBuilder(n);
        StringBuilder sb2 = new StringBuilder(n);
        StringBuilder sb3 = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
            int index2 = (int)(AlphaNumericString.length() * Math.random());
            sb2.append(AlphaNumericString.charAt(index2));
            int index3 = (int)(AlphaNumericString.length() * Math.random());
            sb3.append(AlphaNumericString.charAt(index3));
        }
        string1 = sb.toString();
        string2 = sb2.toString();
        string3 = sb3.toString();

        String code = string1 + "-" + string2 + "-" + string3;

        return code;
    }

    private String createInvoice()
    {
        int n = 15;

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    private void radioFunc() {
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(i == R.id.radioBtn1){
                    paymentMethod = radioButton1.getText().toString();
                }else if(i == R.id.radioBtn2){
                    paymentMethod = radioButton2.getText().toString();
                }else if(i == R.id.radioBtn3){
                    paymentMethod = radioButton3.getText().toString();
                }else if(i == R.id.radioBtn4){
                    paymentMethod = radioButton4.getText().toString();
                }else if(i == R.id.radioBtn5){
                    paymentMethod = radioButton5.getText().toString();
                }
            }
        });
    }

    private String[] setData() {
        String trueData2 = null;
        Bundle bundle = this.getArguments();
        String data = bundle.getString("key1");
        String data2 = bundle.getString("key2");
        String[] splitStr = data2.split("\\s+");
        if(splitStr[1].equals("Apex") || splitStr[1].equals("Valorant") || splitStr[1].equals("BATTLE.NET") || splitStr[1].equals("Genesis") || splitStr[1].equals("Steam")){
            trueData2 = "Item: " + splitStr[0] + " " + splitStr[1] + " " + splitStr[2];
        }else{
            trueData2 = "Item: " + splitStr[0] + " " + splitStr[1];
        }
        Log.d("test2",trueData2);

        String[] arrData = {data, trueData2};

        return arrData;
    }

    private void setRadio(View view) {
        radioGroup = view.findViewById(R.id.radioGroup);
        radioButton1 = view.findViewById(R.id.radioBtn1);
        radioButton2 = view.findViewById(R.id.radioBtn2);
        radioButton3 = view.findViewById(R.id.radioBtn3);
        radioButton4 = view.findViewById(R.id.radioBtn4);
        radioButton5 = view.findViewById(R.id.radioBtn5);
    }
}