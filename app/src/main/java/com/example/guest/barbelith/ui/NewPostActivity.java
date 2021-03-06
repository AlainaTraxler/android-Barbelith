package com.example.guest.barbelith.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.guest.barbelith.R;
import com.example.guest.barbelith.models.Post;
import com.example.guest.barbelith.models.Topic;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewPostActivity extends BaseActivity implements View.OnClickListener{
    @Bind(R.id.imageView_CreatePost) ImageView mImageView_CreatePost;
    @Bind(R.id.editText_Content) EditText mEditText_Content;

    int mainColor;
    int betaColor;
    int alphaColor;
    String category;
    String title;
    String topicPushId;
    Topic mTopic;

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
        topicPushId = intent.getStringExtra("topicPushId");
        mTopic = Parcels.unwrap(intent.getParcelableExtra("topic"));

        setTitle("New Reply");

        ActionBar actionBar;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Post);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(mainColor));

        mImageView_CreatePost.setOnClickListener(this);
    }

    public void onClick(View v){
        String content = mEditText_Content.getText().toString();

        if(content.length() < 75){
            Toast.makeText(NewPostActivity.this, "Please enter content of 75 characters or more.", Toast.LENGTH_SHORT).show();
        }else{
            Post post = new Post(content, mAuth.getCurrentUser().getUid());
            post.setTopicId(topicPushId);

            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();

            DatabaseReference mypostref = dbRef.child("posts").push();
            post.setPushId(mypostref.getKey());
            mypostref.setValue(post);

            dbRef.child(category).child(topicPushId).child("replies").child(post.getPushId()).setValue(true);

            dbRef.child("users").child(mAuth.getCurrentUser().getUid()).child("posts").child(mypostref.getKey()).setValue(true);

            Toast.makeText(NewPostActivity.this, "Post Generated", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(NewPostActivity.this, TopicDetailActivity.class);
            intent.putExtra("category", category);
            intent.putExtra("title", title);
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", alphaColor);
            intent.putExtra("betaColor", betaColor);
            intent.putExtra("topic", Parcels.wrap(mTopic));
            startActivity(intent);
        }
    }
}
