package com.example.guest.barbelith.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.guest.barbelith.R;
import com.example.guest.barbelith.models.Post;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewPostActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.imageView_CreatePost) ImageView mImageView_CreatePost;
    int mainColor;
    int betaColor;
    int alphaColor;
    String category;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        mainColor = intent.getIntExtra("mainColor", 0);
        alphaColor = intent.getIntExtra("alphaColor", 0);
        betaColor = intent.getIntExtra("betaColor", 0);
        category = intent.getStringExtra("category");
        title = intent.getStringExtra("title");

        setTitle("New Reply");

        ActionBar actionBar;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Post);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(mainColor));

        mImageView_CreatePost.setOnClickListener(this);
    }

    public void onClick(View v){
        Post post = new Post("One", "Two", "Three");

        DatabaseReference topicRef = FirebaseDatabase
                .getInstance()
                .getReference("posts");
        DatabaseReference mypostref = topicRef.push();
        mypostref.setValue(post);

        topicRef = FirebaseDatabase
                .getInstance()
                .getReference(category).child(mypostref.getKey()).child("replies");
        mypostref.setValue(post);

        Toast.makeText(NewPostActivity.this, "Post Generated", Toast.LENGTH_SHORT).show();
    }
}
