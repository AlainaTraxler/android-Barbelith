package com.example.guest.barbelith.ui.ui;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.guest.barbelith.R;

import butterknife.ButterKnife;

public class CategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        setTitle(intent.getStringExtra("title"));

        ActionBar actionBar;

        actionBar = getSupportActionBar();
        ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.colorConversationMain));
        actionBar.setBackgroundDrawable(new ColorDrawable(intent.getIntExtra("mainColor", 0)));
    }
}
