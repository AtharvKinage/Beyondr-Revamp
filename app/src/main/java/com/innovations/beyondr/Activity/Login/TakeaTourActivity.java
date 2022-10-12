package com.innovations.beyondr.Activity.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.innovations.beyondr.Activity.User.MainScreenUser;
import com.innovations.beyondr.R;

public class TakeaTourActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takea_tour);
    }
    public void takeatour(View view) {
        Intent i=new Intent(TakeaTourActivity.this,
                MainScreenUser.class);
        startActivity(i);

    }

    public void login(View view) {
        Intent i=new Intent(TakeaTourActivity.this,
                LoginActivity.class);
        startActivity(i);
    }
}