package com.example.mobileprogrammingfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    AccountFragment accountFragment = new AccountFragment();
    RegisterFragment registerFragment = new RegisterFragment();

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
                        getSupportFragmentManager().beginTransaction().replace(R.id.containers,accountFragment).commit();
                        return true;
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
}