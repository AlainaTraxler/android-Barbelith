package com.example.guest.barbelith.ui;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.guest.barbelith.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoriesActivity extends BaseActivity implements View.OnClickListener{
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

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.v(">>>>>>>>", "Logged In");
                    Log.d("", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.v(">>>>>>>>", "Not Logged In");
                    Log.d("", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        ActionBar actionBar;

        setTitle("Barbelith");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_Category);
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
//        actionBar.setBackgroundDrawable(new ColorDrawable(mainColor));
        toolbar.showOverflowMenu();

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
        int mainColor;
        int alphaColor;
        int betaColor;

        if(v == mButton_Conversation){
            intent.putExtra("category", "conversation");
            mainColor = getResources().getColor(R.color.colorConversationMain);
            alphaColor = getResources().getColor(R.color.colorConversationAlpha);
            betaColor = getResources().getColor(R.color.colorConversationBeta);
            intent.putExtra("title", "Conversation");
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
        }else if(v == mButton_Policy){
            intent.putExtra("category", "policy");
            mainColor = getResources().getColor(R.color.colorPolicyMain);
            alphaColor = getResources().getColor(R.color.colorPolicyAlpha);
            betaColor = getResources().getColor(R.color.colorPolicyBeta);
            intent.putExtra("title", "Policy");
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
        }else if(v == mButton_Head){
            intent.putExtra("category", "head");
            mainColor = getResources().getColor(R.color.colorHeadMain);
            alphaColor = getResources().getColor(R.color.colorHeadAlpha);
            betaColor = getResources().getColor(R.color.colorHeadBeta);
            intent.putExtra("title", "Head");
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
        }else if(v == mButton_Laboratory){
            intent.putExtra("category", "laboratory");
            mainColor = getResources().getColor(R.color.colorLaboratoryMain);
            alphaColor = getResources().getColor(R.color.colorLaboratoryAlpha);
            betaColor = getResources().getColor(R.color.colorLaboratoryBeta);
            intent.putExtra("title", "Laboratory");
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
        }else if(v == mButton_Switchboard){
            intent.putExtra("category", "switchboard");
            mainColor = getResources().getColor(R.color.colorSwitchboardMain);
            alphaColor = getResources().getColor(R.color.colorSwitchboardAlpha);
            betaColor = getResources().getColor(R.color.colorSwitchboardBeta);
            intent.putExtra("title", "Switchboard");
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
        }else if(v == mButton_Temple){
            intent.putExtra("category", "temple");
            mainColor = getResources().getColor(R.color.colorTempleMain);
            alphaColor = getResources().getColor(R.color.colorTempleAlpha);
            betaColor = getResources().getColor(R.color.colorTempleBeta);
            intent.putExtra("title", "Temple");
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
        }else if(v == mButton_Art){
            intent.putExtra("category", "art");
            mainColor = getResources().getColor(R.color.colorArtMain);
            alphaColor = getResources().getColor(R.color.colorArtAlpha);
            betaColor = getResources().getColor(R.color.colorArtBeta);
            intent.putExtra("title", "Art");
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
        }else if(v == mButton_Books){
            intent.putExtra("category", "books");
            mainColor = getResources().getColor(R.color.colorBooksMain);
            alphaColor = getResources().getColor(R.color.colorBooksAlpha);
            betaColor = getResources().getColor(R.color.colorBooksBeta);
            intent.putExtra("title", "Books");
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
        }else if(v == mButton_Film){
            intent.putExtra("category", "film");
            mainColor = getResources().getColor(R.color.colorComicMain);
            alphaColor = getResources().getColor(R.color.colorComicAlpha);
            betaColor = getResources().getColor(R.color.colorComicBeta);
            intent.putExtra("title", "Comic");
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
        }else if(v == mButton_Comic){
            intent.putExtra("category", "comic");
            mainColor = getResources().getColor(R.color.colorComicMain);
            alphaColor = getResources().getColor(R.color.colorComicAlpha);
            betaColor = getResources().getColor(R.color.colorComicBeta);
            intent.putExtra("title", "Comic Books");
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
        }else if(v == mButton_Games){
            intent.putExtra("category", "games");
            mainColor = getResources().getColor(R.color.colorGamesMain);
            alphaColor = getResources().getColor(R.color.colorGamesAlpha);
            betaColor = getResources().getColor(R.color.colorGamesBeta);
            intent.putExtra("title", "Games");
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
        }else if(v == mButton_Radio){
            intent.putExtra("category", "radio");
            mainColor = getResources().getColor(R.color.colorRadioMain);
            alphaColor = getResources().getColor(R.color.colorRadioAlpha);
            betaColor = getResources().getColor(R.color.colorRadioBeta);
            intent.putExtra("title", "Radio");
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
        }else if(v == mButton_Creation){
            intent.putExtra("category", "creation");
            mainColor = getResources().getColor(R.color.colorCreationMain);
            alphaColor = getResources().getColor(R.color.colorCreationAlpha);
            betaColor = getResources().getColor(R.color.colorCreationBeta);
            intent.putExtra("title", "Creation");
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
        }else if(v == mButton_Gathering){
            intent.putExtra("category", "gathering");
            mainColor = getResources().getColor(R.color.colorGatheringMain);
            alphaColor = getResources().getColor(R.color.colorGatheringAlpha);
            betaColor = getResources().getColor(R.color.colorGatheringBeta);
            intent.putExtra("title", "Gathering");
            intent.putExtra("mainColor", mainColor);
            intent.putExtra("alphaColor", betaColor);
            intent.putExtra("betaColor", alphaColor);
        }
        startActivity(intent);
    }
}
