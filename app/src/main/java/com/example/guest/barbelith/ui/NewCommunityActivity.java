package com.example.guest.barbelith.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.example.guest.barbelith.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewCommunityActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.imageView_CreateCommunity) ImageView mImageView_CreateCommunity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_community);
        ButterKnife.bind(this);

        setTitle("New Community");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Category);
        setSupportActionBar(toolbar);
        toolbar.showOverflowMenu();

        mImageView_CreateCommunity.setOnClickListener(this);
    }

    public void onClick(View v){

    }
}
