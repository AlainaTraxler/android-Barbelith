package com.example.guest.barbelith.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.guest.barbelith.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.imageView_Signin) ImageView mImageView_Signin;
    @Bind(R.id.imageView_Signup) ImageView mImageView_Signup;
    @Bind(R.id.editText_Email) EditText mEditText_Email;
    @Bind(R.id.editText_Password) EditText mEditText_Password;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d("", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d("", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };



        mImageView_Signup.setOnClickListener(this);
        mImageView_Signin.setOnClickListener(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener);
        }
    }

    public void createUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful()) {
                            Intent intent = new Intent(LoginActivity.this, CategoriesActivity.class);
                            startActivity(intent);
                            Toast.makeText(LoginActivity.this, "Signed up", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(LoginActivity.this, "Sign up failed", Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });

    }

    public void signinUser(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {


                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Signed in", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, CategoriesActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(LoginActivity.this, "Sign in failed", Toast.LENGTH_SHORT).show();
                        }


                        // ...
                    }
                });
    }

    @Override
    public void onClick(View v){
        String email = mEditText_Email.getText().toString();
        String password = mEditText_Password.getText().toString();

        if(v == mImageView_Signup){
            if(email.equals("") || password.equals("")){
                Toast.makeText(LoginActivity.this, "Sign up requires a valid e-mail and password", Toast.LENGTH_SHORT).show();
            }else{
                createUser(email, password);
            }

        }else if(v == mImageView_Signin){
            if(email.equals("") || password.equals("")){
                Toast.makeText(LoginActivity.this, "Sign in requires a valid e-mail and password", Toast.LENGTH_SHORT).show();
            }else{
                Log.v(email, password);
                signinUser(email, password);
            }
        }
    }

}
