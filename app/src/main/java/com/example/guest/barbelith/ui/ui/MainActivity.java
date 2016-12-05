package com.example.guest.barbelith.ui.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.guest.barbelith.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.imageView_Grenade) ImageView mImageView_Grenade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mImageView_Grenade.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        if(v == mImageView_Grenade){
            Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
            startActivity(intent);
        }
    }
}
