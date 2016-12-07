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
import android.widget.TextView;

import com.example.guest.barbelith.R;
import com.example.guest.barbelith.adapters.RepliesListAdapter;
import com.example.guest.barbelith.models.Post;
import com.example.guest.barbelith.models.Topic;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TopicDetailActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.textView_TopicContent) TextView mTextView_TopicContent;
    @Bind(R.id.imageView_NewPost) ImageView mImageView_NewPost;
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;

    private Topic mTopic;
    private int mMainColor;
    private int mAlphaColor;
    private int mBetaColor;

    ArrayList<Post> mPosts = new ArrayList<Post>();
    private RepliesListAdapter mAdapter;
    private DatabaseReference mReplies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mTopic = Parcels.unwrap(intent.getParcelableExtra("topic"));
        mMainColor = intent.getIntExtra("mainColor", 0);
        mAlphaColor = intent.getIntExtra("alphaColor", 0);
        mBetaColor = intent.getIntExtra("betaColor", 0);

        final ArrayList<String> mPostIds = new ArrayList<String>();
        mReplies = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(mTopic.getCategory()).child(mTopic.getPushId()).child("replies");

        setTitle(mTopic.getTitle());

        mReplies.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                //In here we have a list of post IDs
                for (DataSnapshot repliesSnapshot : dataSnapshot.getChildren()) {

                    DatabaseReference postRef = FirebaseDatabase
                            .getInstance()
                            .getReference("posts");
                    //--------------
                    Query queryRef = postRef.orderByKey().equalTo(repliesSnapshot.getKey());
                    //--------------
                    queryRef.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            Post post = dataSnapshot.getValue(Post.class);
                            mPosts.add(post);
                        }

                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) {}

                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

                        @Override
                        public void onCancelled(DatabaseError databaseError) {}
                    });
                }
                mAdapter = new RepliesListAdapter(getApplicationContext(), mPosts, mAlphaColor, mBetaColor, mMainColor);
                mRecyclerView.setAdapter(mAdapter);
                RecyclerView.LayoutManager layoutManager =
                        new LinearLayoutManager(TopicDetailActivity.this);
                mRecyclerView.setLayoutManager(layoutManager);
                mRecyclerView.setHasFixedSize(true);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        ActionBar actionBar;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Category);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(mMainColor));

        mTextView_TopicContent.setText(mTopic.getContent());
        mTextView_TopicContent.setBackgroundColor(mAlphaColor);

        mImageView_NewPost.setOnClickListener(this);
    }

    public void onClick(View v){
        Intent intent = new Intent(TopicDetailActivity.this, NewPostActivity.class);
        intent.putExtra("mainColor", mMainColor);
        intent.putExtra("alphaColor", mBetaColor);
        intent.putExtra("betaColor", mAlphaColor);
        intent.putExtra("topicPushId", mTopic.getPushId());
        intent.putExtra("category", mTopic.getCategory());
        startActivity(intent);
    }


}
