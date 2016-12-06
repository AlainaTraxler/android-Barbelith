package com.example.guest.barbelith.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.barbelith.R;
import com.example.guest.barbelith.models.Topic;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class TopicDetailActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.textView_TopicContent) TextView mTextView_TopicContent;
    @Bind(R.id.imageView_NewPost) ImageView mImageView_NewPost;

    private Topic mTopic;
    private int mMainColor;
    private int mAlphaColor;
    private int mBetaColor;

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

        setTitle(mTopic.getTitle());

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
        startActivity(intent);
    }


}
