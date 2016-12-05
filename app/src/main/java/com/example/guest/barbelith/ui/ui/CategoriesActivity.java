package com.example.guest.barbelith.ui.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.guest.barbelith.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoriesActivity extends AppCompatActivity implements View.OnClickListener{
    @Bind(R.id.button_Conversation) Button mButton_Conversation;
    @Bind(R.id.button_Policy) Button mButton_Policy;
    @Bind(R.id.button_Head) Button mButton_Head;
    @Bind(R.id.button_Laboratory) Button mButton_Laboratory;
    @Bind(R.id.button_Switchboard) Button mButton_Switchboard;
    @Bind(R.id.button_Temple) Button mButton_Temple;
    @Bind(R.id.button_Art) Button mButton_Art;
    @Bind(R.id.button_Books) Button mButton_Books;
    @Bind(R.id.button_Comic) Button mButton_Comic;
    @Bind(R.id.button_Film) Button mButton_Film;
    @Bind(R.id.button_Games) Button mButton_Games;
    @Bind(R.id.button_Radio) Button mButton_Radio;
    @Bind(R.id.button_Creation) Button mButton_Creation;
    @Bind(R.id.button_Gathering) Button mButton_Gathering;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);

        mButton_Conversation.setOnClickListener(this);
        mButton_Policy.setOnClickListener(this);
        mButton_Head.setOnClickListener(this);
        mButton_Laboratory.setOnClickListener(this);
        mButton_Switchboard.setOnClickListener(this);
        mButton_Temple.setOnClickListener(this);
        mButton_Art.setOnClickListener(this);
        mButton_Books.setOnClickListener(this);
        mButton_Comic.setOnClickListener(this);
        mButton_Film.setOnClickListener(this);
        mButton_Games.setOnClickListener(this);
        mButton_Radio.setOnClickListener(this);
        mButton_Creation.setOnClickListener(this);
        mButton_Gathering.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        String category;
        Intent intent = new Intent(CategoriesActivity.this, CategoryActivity.class);

        if(v == mButton_Conversation){
            intent.putExtra("category", "");
        }else if(v == mButton_Policy){
            intent.putExtra("category", "policy");
        }else if(v == mButton_Head){
            intent.putExtra("category", "head");
        }else if(v == mButton_Laboratory){
            intent.putExtra("category", "laboratory");
        }else if(v == mButton_Switchboard){
            intent.putExtra("category", "switchboard");
        }else if(v == mButton_Temple){
            intent.putExtra("category", "temple");
        }else if(v == mButton_Art){
            intent.putExtra("category", "art");
        }else if(v == mButton_Books){
            intent.putExtra("category", "books");
        }else if(v == mButton_Film){
            intent.putExtra("category", "film");
        }else if(v == mButton_Comic){
            intent.putExtra("category", "comic");
        }else if(v == mButton_Games){
            intent.putExtra("category", "games");
        }else if(v == mButton_Radio){
            intent.putExtra("category", "radio");
        }else if(v == mButton_Creation){
            intent.putExtra("category", "creation");
        }else if(v == mButton_Gathering){
            intent.putExtra("category", "gathering");
        }
    }
}
