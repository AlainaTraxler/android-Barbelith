package com.example.guest.barbelith.utilities;

import android.content.Context;
import android.content.Intent;

import com.example.guest.barbelith.ui.LoginActivity;
import com.example.guest.barbelith.ui.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by Guest on 12/7/16.
 */
public class Overflow {
    public static void logout(Context mContext) {
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(mContext, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        mContext.startActivity(intent);
    }

    public static void goHome(Context mContext) {
        Intent intent = new Intent(mContext, MainActivity.class);
        mContext.startActivity(intent);
    }
}
