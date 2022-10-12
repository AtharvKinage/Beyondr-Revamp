package com.innovations.beyondr.Activity.Doctor;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.innovations.beyondr.Fragment.Doctor.HomeFragmentDoc;
import com.innovations.beyondr.Fragment.Doctor.PatientsFragment;
import com.innovations.beyondr.Fragment.Doctor.RevenueFragment;
import com.innovations.beyondr.Fragment.Doctor.ScheduleFragment;
import com.innovations.beyondr.R;


public class MainScreenDoc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_doc);
        contextOfApplication = getApplicationContext();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragmentDoc()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            switch (item.getItemId()){
                case R.id.home:
                    selectedFragment = new HomeFragmentDoc();
                    break;
                case R.id.wellness:
                    selectedFragment = new ScheduleFragment();
                    break;
                case R.id.book:
                    selectedFragment = new PatientsFragment();
                    break;
                case R.id.healthrecord:
                    selectedFragment = new RevenueFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
            return true;
        }
    };
    public static Context contextOfApplication;
    public static Context getContextOfApplication()
    {
        return contextOfApplication;
    }
}
