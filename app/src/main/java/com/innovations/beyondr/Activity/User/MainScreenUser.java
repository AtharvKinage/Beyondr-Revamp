package com.innovations.beyondr.Activity.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.Image;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.innovations.beyondr.Fragment.User.AddPostFragment;
import com.innovations.beyondr.Fragment.User.BookanAppointment;
import com.innovations.beyondr.Fragment.User.HealthRecordFragment;
import com.innovations.beyondr.Fragment.User.HomeFragmentUser;
import com.innovations.beyondr.Fragment.User.WellnessFragment;
import com.innovations.beyondr.R;


public class MainScreenUser extends AppCompatActivity implements View.OnClickListener {

    CardView homeCard, wellnessCard, appointmentCard, healthCard;
    ImageView homeImage, wellnessImage, appointmentImage, healthImage, logocircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_user);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragmentUser()).commit();

        homeCard = findViewById(R.id.card_home);
        wellnessCard = findViewById(R.id.card_wellness);
        appointmentCard = findViewById(R.id.card_appointment);
        healthCard = findViewById(R.id.health_card);
        homeImage = findViewById(R.id.image_home);
        wellnessImage = findViewById(R.id.image_wellness);
        appointmentImage = findViewById(R.id.image_appointment);
        healthImage = findViewById(R.id.health_image);
        logocircle = findViewById(R.id.logo_center);

        homeCard.setOnClickListener(this);
        wellnessCard.setOnClickListener(this);
        appointmentCard.setOnClickListener(this);
        healthCard.setOnClickListener(this);
        logocircle.setOnClickListener(this);

//        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
//        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new HomeFragmentUser()).commit();

    }

    @Override
    public void onClick(View view) {

        Fragment selectedFragment = null;

        if(view == homeCard){
            selectedFragment = new HomeFragmentUser();
            homeCard.setCardBackgroundColor(Color.WHITE);
            homeImage.setColorFilter(R.color.purple_200, PorterDuff.Mode.SRC_ATOP);

            wellnessCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            wellnessImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

            appointmentCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            appointmentImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

            healthCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            healthImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        }

        if(view == wellnessCard){
            selectedFragment = new WellnessFragment();
            wellnessCard.setCardBackgroundColor(Color.WHITE);
            wellnessImage.setColorFilter(getResources().getColor(R.color.purple_200), PorterDuff.Mode.SRC_ATOP);

            homeCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            homeImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

            appointmentCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            appointmentImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

            healthCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            healthImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        }

        if(view == logocircle){
            selectedFragment = new AddPostFragment();
            wellnessCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            wellnessImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

            homeCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            homeImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

            appointmentCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            appointmentImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

            healthCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            healthImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        }

        if(view == appointmentCard){
            selectedFragment = new BookanAppointment();
            appointmentCard.setCardBackgroundColor(Color.WHITE);
            appointmentImage.setColorFilter(getResources().getColor(R.color.purple_200), PorterDuff.Mode.SRC_ATOP);

            wellnessCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            wellnessImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

            homeCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            homeImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

            healthCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            healthImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        }

        if(view == healthCard){
            selectedFragment = new HealthRecordFragment();
            healthCard.setCardBackgroundColor(Color.WHITE);
            healthImage.setColorFilter(getResources().getColor(R.color.purple_200), PorterDuff.Mode.SRC_ATOP);

            wellnessCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            wellnessImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

            appointmentCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            appointmentImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);

            homeCard.setCardBackgroundColor(getResources().getColor(R.color.purple_200));
            homeImage.setColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
        }

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
    }
//    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Fragment selectedFragment = null;
//            switch (item.getItemId()){
//                case R.id.home:
//                    selectedFragment = new HomeFragmentUser();
//
//                    break;
//                case R.id.wellness:
//                    selectedFragment = new WellnessFragment();
//                    break;
////                case R.id.marketplace:
////                    selectedFragment = new AddPostFragment();
////                    break;
//                case R.id.book:
//                    selectedFragment = new BookanAppointment();
//                    break;
//                case R.id.healthrecord:
//                    selectedFragment = new HealthRecordFragment();
//                    break;
//            }
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();
//            return true;
//        }
//    };
}
