package com.example.guest.barbelith.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.guest.barbelith.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.imageView_Barbelith) ImageView mImageView_Barbelith;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                    Log.v(">>>>>>>>", "Logged In");
                    Log.d("", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.v(">>>>>>>>", "Not Logged In");
                    Log.d("", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        if(mAuth.getCurrentUser() != null){
            Log.v("<<<<<<<<", mAuth.getCurrentUser().getUid());
            Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
            startActivity(intent);
        }


        mImageView_Barbelith.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == mImageView_Barbelith){
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }
    }
}
