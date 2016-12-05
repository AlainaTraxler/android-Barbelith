package com.example.guest.barbelith.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.guest.barbelith.R;
import com.example.guest.barbelith.models.Topic;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewTopicActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.editText_Topic) EditText mEditText_Title;
    @Bind(R.id.editText_Content) EditText mEditText_Content;
    @Bind(R.id.imageView_CreateTopic) ImageView mImageView_CreateTopic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_topic);
        ButterKnife.bind(this);

        mImageView_CreateTopic.setOnClickListener(this);
    }

    public void onClick(View v){
        Topic topic = new Topic(mEditText_Title.getText().toString(), mEditText_Content.getText().toString(), "Nobody Special");
        Intent intent = new Intent(NewTopicActivity.this, CategoryActivity.class);
        startActivity(intent);
    }
}
