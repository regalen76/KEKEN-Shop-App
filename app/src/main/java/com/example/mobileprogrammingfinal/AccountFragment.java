package com.example.mobileprogrammingfinal;

import static android.content.ContentValues.TAG;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;

public class AccountFragment extends Fragment {

    Button signUpBtn,loginBtn;
    EditText inputEmail,inputPassword;
    ProgressBar progressBar;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_account, container, false);

        inputEmail = view.findViewById(R.id.emailedittext);
        inputPassword = view.findViewById(R.id.pwfirstedittext);
        loginBtn = view.findViewById(R.id.loginbutton);
        signUpBtn = view.findViewById(R.id.createaccbutton);

        progressBar = view.findViewById(R.id.progbar);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performLogin();
            }
        });

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.changeToRegisterPage();
            }
        });

        return view;
    }

    private void performLogin() {
        String email = inputEmail.getText().toString();
        String pw = inputPassword.getText().toString();

        if (!email.matches(emailPattern)){
            inputEmail.setError("Enter Correct Email");
            inputEmail.requestFocus();
        }else if(pw.isEmpty() || pw.length()<8){
            inputPassword.setError("Password can't be empty and must be more than 8 characters");
            inputPassword.requestFocus();
        }else{
            progressBar.setVisibility(getView().VISIBLE);

            mAuth.signInWithEmailAndPassword(email,pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        progressBar.setVisibility(getView().INVISIBLE);
                        Toast.makeText(getActivity(),"Login Complete",Toast.LENGTH_SHORT).show();
                        MainActivity mainActivity = (MainActivity) getActivity();
                        mainActivity.changeToHomePage();
                    }else{
                        progressBar.setVisibility(getView().INVISIBLE);
                        Toast.makeText(getActivity(),""+task.getException(),Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}