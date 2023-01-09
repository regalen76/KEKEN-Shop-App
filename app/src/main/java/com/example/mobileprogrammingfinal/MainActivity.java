package com.example.mobileprogrammingfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;
    MobileLegendFragment mobileLegendFragment;
    int price;

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    AccountFragment accountFragment = new AccountFragment();
    RegisterFragment registerFragment = new RegisterFragment();
    LoginedFragment loginedFragment = new LoginedFragment();

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getBottomNavigationWithFragment();

        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    private void getBottomNavigationWithFragment() {
        bottomNavigationView = findViewById(R.id.bot_nav);

        getSupportFragmentManager().beginTransaction().replace(R.id.containers,homeFragment).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers,homeFragment).commit();
                        return true;
                    case R.id.search_order:
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers,searchFragment).commit();
                        return true;
                    case R.id.account:
                        if (FirebaseAuth.getInstance().getCurrentUser()!=null) //check jika sudah login ato belom
                        {
                            getSupportFragmentManager().beginTransaction().replace(R.id.containers,loginedFragment).commit();
                            return true;
                        }else{
                            getSupportFragmentManager().beginTransaction().replace(R.id.containers,accountFragment).commit();
                            return true;
                        }
                }
                return false;
            }
        });
    }

    public void changeToRegisterPage(){
       getSupportFragmentManager().beginTransaction().replace(R.id.containers,registerFragment).commit();
    }

    public void changeToLoginPage(){
        getSupportFragmentManager().beginTransaction().replace(R.id.containers,accountFragment).commit();
    }

    public void changeToHomePage(){
        getSupportFragmentManager().beginTransaction().replace(R.id.containers,homeFragment).commit();
    }

    public void createFragment(){
        fm = getSupportFragmentManager();
        mobileLegendFragment = new MobileLegendFragment();
        fm.beginTransaction()
                .add(R.id.containers, mobileLegendFragment, "4")
                .hide(mobileLegendFragment)
                .commit();
    }

    public void tes(View view){
        Toast.makeText(getApplicationContext(), "tes", Toast.LENGTH_SHORT).show();
    }

//    public void toDetail(View view){
//
//        TextView textView = findViewById(R.id.judulgame);
//        String title = textView.getText().toString();
//
//        fm = getSupportFragmentManager();
//
//        createFragment();
//        if (title.equals("Mobile Legends")) {
//            fm.beginTransaction()
//                    .replace(R.id.containers,mobileLegendFragment)
//                    .commit();
//        } else if (title.equals("Gura")) {
//            fm.beginTransaction()
//                    .replace(R.id.containers,mobileLegendFragment)
//                    .commit();
//        } else if (title.equals("Anyi")) {
//            fm.beginTransaction()
//                    .replace(R.id.containers,mobileLegendFragment)
//                    .commit();
//        }
//        Toast.makeText(getApplicationContext(), title, Toast.LENGTH_SHORT).show();
//
//    }
//
//    public void resetRectangle(){
//        int counter = 1;
//        int i;
//        String idRectangle ;
//        int resIdRectangle;
//        for (i=1; i<17; i++){
//            idRectangle = "rectangle" + counter;
//            resIdRectangle = getResources().getIdentifier(idRectangle, "id", getPackageName());
//            ImageView image_temp = findViewById(resIdRectangle);
//            image_temp.setImageResource(R.drawable.rounded_rectangle);
//            counter++;
//        }
//    }
//
//    public void diamond1(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle1);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 1000;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond2(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle2);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 1600;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond3(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle3);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 3700;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond4(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle4);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 5800;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond5(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle5);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 8500;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond6(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle6);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 12700;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond7(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle7);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 17000;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond8(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle8);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 25000;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond9(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle9);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 49000;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond10(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle10);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 69000;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond11(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle11);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 85000;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond12(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle12);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 116000;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond13(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle13);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 159000;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond14(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle14);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 243000;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond15(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle15);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 528000;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }
//
//    public void diamond16(View view){
//        resetRectangle();
//        ImageView image = findViewById(R.id.rectangle16);
//        image.setImageResource(R.drawable.rounded_rectangle2);
//        price = 1260000;
//        TextView txt = findViewById(R.id.price);
//        txt.setText("Price: Rp. " + price);
//    }

}