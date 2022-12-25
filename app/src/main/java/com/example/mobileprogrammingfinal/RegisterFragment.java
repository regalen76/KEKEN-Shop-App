package com.example.mobileprogrammingfinal;

import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
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
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;

public class RegisterFragment extends Fragment {

    EditText inputEmail, inputPassword, reInputPassword;
    Button registerBtn;
    ProgressBar progressBar;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        inputEmail = view.findViewById(R.id.emailregisteredittext);
        inputPassword = view.findViewById(R.id.registerpwfirstedittext);
        reInputPassword = view.findViewById(R.id.registerpwsecondedittext);
        registerBtn = view.findViewById(R.id.registerbutton);

        progressBar = view.findViewById(R.id.progressbar);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performAuth();
            }
        });

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();

        inputEmail.setText("");
        inputPassword.setText("");
        reInputPassword.setText("");
    }

    private void performAuth() {
        String email = inputEmail.getText().toString();
        String pw = inputPassword.getText().toString();
        String pw2 = reInputPassword.getText().toString();

        if (!email.matches(emailPattern)){
            inputEmail.setError("Enter Correct Email");
            inputEmail.requestFocus();
        }else if(pw.isEmpty() || pw.length()<8){
            inputPassword.setError("Password can't be empty and must be more than 8 characters");
            inputPassword.requestFocus();
        }else if(!pw.equals(pw2)){
            reInputPassword.setError("Password not match");
            reInputPassword.requestFocus();
        }else{
            progressBar.setVisibility(getView().VISIBLE);

            mAuth.createUserWithEmailAndPassword(email,pw).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        progressBar.setVisibility(getView().INVISIBLE);
                        Toast.makeText(getActivity(),"Registration Complete",Toast.LENGTH_SHORT).show();

                        MainActivity mainActivity = (MainActivity) getActivity();
                        mainActivity.changeToHomePage();
                    } else{
                        progressBar.setVisibility(getView().INVISIBLE   );
                        try {
                            throw task.getException();
                        } catch(FirebaseAuthUserCollisionException e) {
                            inputEmail.setError("User already exists");
                            inputEmail.requestFocus();
                        } catch(Exception e) {
                            Log.e(TAG, e.getMessage());
                        }
                    }
                }
            });
        }
    }

}