package com.example.guest.barbelith.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class NewTopicActivity extends AppCompatActivity implements View.OnClickListener{
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

        mRelativeLayout_NewTopicActivity.setBackgroundColor(alphaColor);

        mImageView_CreateTopic.setOnClickListener(this);
    }

    public void onClick(View v){
        Topic topic = new Topic(mEditText_Title.getText().toString(), mEditText_Content.getText().toString(), "Nobody Special", category);

        DatabaseReference restaurantRef = FirebaseDatabase
                .getInstance()
                .getReference(category);
        restaurantRef.push().setValue(topic);
        Toast.makeText(NewTopicActivity.this, "Topic Generated", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(NewTopicActivity.this, CategoryActivity.class);
        intent.putExtra("category", category);
        intent.putExtra("title", title);
        intent.putExtra("mainColor", mainColor);
        intent.putExtra("alphaColor", betaColor);
        intent.putExtra("betaColor", alphaColor);
        startActivity(intent);
    }
}
