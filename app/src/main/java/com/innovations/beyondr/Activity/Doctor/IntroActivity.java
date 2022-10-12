package com.innovations.beyondr.Activity.Doctor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.innovations.beyondr.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {
    private ViewPager screenPager;
    IntroViewPagerAdapter introViewPagerAdapter;
    TextView btnSkip;
    TextView btnGetStarted;
    LinearLayout linearLayoutSkip, linearLayoutGetStarted,slider;
    private int dotscount;
    private ImageView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Membuat layar fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        if (restorePreData()){
//            Intent mainActivity = new Intent(getApplicationContext(), DoctorDatabase1.class);
//            startActivity(mainActivity);
//            finish();
//        }

        setContentView(R.layout.activity_intro);

        // Views
        btnGetStarted = findViewById(R.id.btn_get_started);

        linearLayoutGetStarted = findViewById(R.id.linear_layout_get_started);

        slider=findViewById(R.id.slider);

        // Fill data description

        final List<ScreenItem> mList = new ArrayList<>();
        mList.add(new ScreenItem("Best Medical service", "Your first step is to register yourself and send your profile for verification. Our Team will contact you via email and do your onboarding !", R.drawable.sli));
        mList.add(new ScreenItem("Add Your Schedule ", "Adding your schedule automatically generates your slots, which makes your profile open for booking appointments.  ", R.drawable.sli));
        mList.add(new ScreenItem("Build & Share with Community", "Post Learnings across the Platform , increase your interactivity and make your presence more wider", R.drawable.sli));

        // Setup ViewPager
        screenPager = findViewById(R.id.screen_viewpager);
        introViewPagerAdapter = new IntroViewPagerAdapter(this, mList);
        screenPager.setAdapter(introViewPagerAdapter);
        dotscount= introViewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++) {

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.sliderunselected));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(8, 0, 8, 0);

            slider.addView(dots[i], params);
        }
        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.sliderselected));

        screenPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.sliderunselected));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.sliderselected));



            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });



        // Setup tab indicator



        // Button Skip



        //Button Get Started
        btnGetStarted.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //Intent mainActivity = new Intent(getApplicationContext(), DoctorDatabase1.class);
                //startActivity(mainActivity);

                //savePrefsData();
                //finish();
            }
        });

    }



    private boolean restorePreData(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = preferences.getBoolean("isIntroOpened", false);

        return isIntroActivityOpenedBefore;
    }

    private void savePrefsData(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);

        SharedPreferences.Editor editor = preferences.edit();

        editor.putBoolean("isIntroOpened", true);
        editor.apply();
    }

    private void loadLastScreen(){
        linearLayoutSkip.setVisibility(View.INVISIBLE);
        linearLayoutGetStarted.setVisibility(View.VISIBLE);
    }
}