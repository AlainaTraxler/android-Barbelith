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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        setTitle(intent.getStringExtra("title"));

        ActionBar actionBar;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Category);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(intent.getIntExtra("mainColor", 0)));

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        ref.child("Test").setValue("Success");

        mImageView_NewPost.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v == mImageView_NewPost){
            Intent intent = new Intent(CategoryActivity.this, NewTopicActivity.class);
            startActivity(intent);
        }
    }
}
