package com.example.guest.barbelith.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.guest.barbelith.R;
import com.example.guest.barbelith.adapters.TopicListAdapter;
import com.example.guest.barbelith.models.Topic;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.imageView_NewPost) ImageView mImageView_NewPost;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    int mainColor;
    int betaColor;
    int alphaColor;
    String title;
    String category;

    private DatabaseReference mTopics;
    private TopicListAdapter mAdapter;


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

        mTopics = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(category);

        mTopics.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<Topic> topics = new ArrayList<Topic>();
                for (DataSnapshot topicSnapshot : dataSnapshot.getChildren()) {
                    Topic topic = topicSnapshot.getValue(Topic.class);
                    topics.add(topic);
//                    Log.d("Locations updated", "location: " + topicSnapshot.child("title").getValue());

                }
                mAdapter = new TopicListAdapter(getApplicationContext(), topics, alphaColor, betaColor);
                mRecyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager =
                        new LinearLayoutManager(CategoryActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setHasFixedSize(true);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        setTitle(title);

        ActionBar actionBar;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Category);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(mainColor));

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
