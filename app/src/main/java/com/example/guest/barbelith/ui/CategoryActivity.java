package com.example.guest.barbelith.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.guest.barbelith.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.imageView_NewPost) ImageView mImageView_NewPost;
    int mainColor;
    int betaColor;
    int alphaColor;
    String title;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mainColor = intent.getIntExtra("mainColor", 0);
        alphaColor = intent.getIntExtra("alphaColor", 0);
        betaColor = intent.getIntExtra("betaColor", 0);
        title = intent.getStringExtra("title");
        category = intent.getStringExtra("category");

        setTitle(title);

        ActionBar actionBar;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Category);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(mainColor));

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Test").setValue("Success");

        mImageView_NewPost.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v == mImageView_NewPost){


            Intent intent = new Intent(CategoryActivity.this, NewTopicActivity.class);
            intent.putExtra("category", category);
            intent.putExtra("title", title);
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
            startActivity(intent);
        }
    }
}
