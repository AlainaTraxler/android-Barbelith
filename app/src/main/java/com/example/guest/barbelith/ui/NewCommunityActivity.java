package com.example.guest.barbelith.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.guest.barbelith.R;
import com.example.guest.barbelith.models.Community;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewCommunityActivity extends BaseActivity implements View.OnClickListener {
    @Bind(R.id.imageView_CreateCommunity) ImageView mImageView_CreateCommunity;
    @Bind(R.id.editText_Name) EditText mEditText_Name;
    @Bind(R.id.editText_Description) EditText mEditText_Description;

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
        String name = mEditText_Name.getText().toString();
        String description = mEditText_Description.getText().toString();

        if(name.equals("")){
            Toast.makeText(NewCommunityActivity.this, "Please enter a name", Toast.LENGTH_SHORT).show();
        }else if(description.length() < 75){
            Toast.makeText(NewCommunityActivity.this, "Please enter a description longer than 75 characters", Toast.LENGTH_SHORT).show();
        }else{
            Community community = new Community(name, description, mAuth.getCurrentUser().getUid());

            DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();

            DatabaseReference mypostref = dbRef.child("communities").push();
            community.setPushId(mypostref.getKey());
            mypostref.setValue(community);

            Intent intent = new Intent(mContext, CommunitiesActivity.class);
            startActivity(intent);
        }
    }
}
