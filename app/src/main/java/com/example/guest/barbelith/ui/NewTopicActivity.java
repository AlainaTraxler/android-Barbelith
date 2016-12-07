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
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.guest.barbelith.R;
import com.example.guest.barbelith.models.Topic;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewTopicActivity extends BaseActivity implements View.OnClickListener{
    @Bind(R.id.editText_Topic) EditText mEditText_Title;
    @Bind(R.id.editText_Content) EditText mEditText_Content;
    @Bind(R.id.imageView_CreateTopic) ImageView mImageView_CreateTopic;
    @Bind(R.id.relativeLayout_NewTopicActivity) RelativeLayout mRelativeLayout_NewTopicActivity;

    int mainColor;
    int betaColor;
    int alphaColor;
    String category;
    String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_topic);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        mainColor = intent.getIntExtra("mainColor", 0);
        alphaColor = intent.getIntExtra("alphaColor", 0);
        betaColor = intent.getIntExtra("betaColor", 0);
        category = intent.getStringExtra("category");
        title = intent.getStringExtra("title");

        setTitle("New Topic");

        ActionBar actionBar;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Category);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(mainColor));


//        mRelativeLayout_NewTopicActivity.setBackgroundColor(betaColor);

        mImageView_CreateTopic.setOnClickListener(this);
    }

    public void onClick(View v){
        String topicTitle = mEditText_Title.getText().toString();
        String topicContent = mEditText_Content.getText().toString();
        if(topicTitle.equals("") || topicTitle.length() > 75){
            Toast.makeText(NewTopicActivity.this, "Please enter a title of 75 characters or less.", Toast.LENGTH_SHORT).show();
        }else if(topicContent.equals("") || topicContent.length() < 75){
            Toast.makeText(NewTopicActivity.this, "Please enter content of 75 characters or more.", Toast.LENGTH_SHORT).show();
        }else{
            Topic topic = new Topic(topicTitle, topicContent, mAuth.getCurrentUser().getUid(), category);

            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();

//            DatabaseReference topicRef = FirebaseDatabase
//                    .getInstance()
//                    .getReference(category);
            DatabaseReference mypostref = dbRef.child(category).push();
            topic.setPushId(mypostref.getKey());
            mypostref.setValue(topic);

            dbRef.child("users/topics").child(mypostref.getKey());

            Toast.makeText(NewTopicActivity.this, "Topic Generated", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(NewTopicActivity.this, CategoryActivity.class);
            intent.putExtra("category", category);
            intent.putExtra("title", title);
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", alphaColor);
            intent.putExtra("betaColor", betaColor);
            startActivity(intent);
        }

    }
}
