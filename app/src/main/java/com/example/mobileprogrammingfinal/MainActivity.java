package com.example.mobileprogrammingfinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    AccountFragment accountFragment = new AccountFragment();
    RegisterFragment registerFragment = new RegisterFragment();
    LoginedFragment loginedFragment = new LoginedFragment();
    GameFragment gameFragment = new GameFragment();
    PaymentFragment paymentFragment = new PaymentFragment();
    CompletedFragment completedFragment = new CompletedFragment();

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
                        }else {
                            getSupportFragmentManager().beginTransaction().replace(R.id.containers, accountFragment).commit();
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

    public void changeToGamePage(Bundle bundle){
        gameFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.containers,gameFragment).commit();
    }

    public void changeToPaymentPage(Bundle bundle){
        paymentFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.containers,paymentFragment).commit();
    }

    public void changeToCompletedPage(Bundle bundle){
        completedFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.containers,completedFragment).commit();
    }

}