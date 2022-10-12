package com.innovations.beyondr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;

import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.core.Amplify;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.innovations.beyondr.Activity.Login.TakeaTourActivity;
import com.innovations.beyondr.Activity.User.MainScreenUser;
import com.innovations.beyondr.Activity.User.UserDatabase;
import com.innovations.beyondr.Common.SharedPref;
import com.innovations.beyondr.Common.Util;


public class SplashScreen extends AppCompatActivity {
    private static int SPLASH_SCREEN_TIME_OUT=1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        init();
    }

    private void init() {
        initialCheck();
    }
    private void initialCheck() {

        GoAhead();

    }

    private void GoAhead() {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AuthUser currentUser = Amplify.Auth.getCurrentUser();
                Intent intent;
                if (currentUser != null) {
                    if (SharedPref.getBooleanInPreferences("userdata", SplashScreen.this)){
                        if(Amplify.Auth.getCurrentUser()!=null) {
                            FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
                                @Override
                                public void onSuccess(InstanceIdResult instanceIdResult) {
                                    Util.updateDeviceToken(SplashScreen.this, instanceIdResult.getToken());
                                    Log.e("TAG", "token" + instanceIdResult.getToken());
                                }
                            });
                        }
                        Intent intent2 =new Intent(SplashScreen.this, MainScreenUser.class);
                        startActivity(intent2);
                        finish();
                    }else {
                        Intent i=new Intent(SplashScreen.this,
                                UserDatabase.class);
                        startActivity(i);
                        finish();
                    }
                }else {
                    Intent i=new Intent(SplashScreen.this,
                            TakeaTourActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, SPLASH_SCREEN_TIME_OUT);

    }

}