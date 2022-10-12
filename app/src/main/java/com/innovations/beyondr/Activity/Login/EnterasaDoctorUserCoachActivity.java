package com.innovations.beyondr.Activity.Login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.innovations.beyondr.R;

public class EnterasaDoctorUserCoachActivity extends AppCompatActivity {
    int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enterasa_doctor_user_coach);
        FrameLayout doctor,coach,user;
        ImageView idoctor,icoach,iuser;


        idoctor=findViewById(R.id.imgdoc);
        icoach=findViewById(R.id.imgcoach);
        iuser=findViewById(R.id.imguser);
        doctor=findViewById(R.id.framedoc);
        coach=findViewById(R.id.framecoach);
        user=findViewById(R.id.frameuser);

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=1;
                if (count==1){
                    doctor.setBackgroundResource(R.drawable.tealback);
                    idoctor.setImageResource(R.drawable.wdoc);
                    coach.setBackgroundResource(R.drawable.squicircle);
                    icoach.setImageResource(R.drawable.coach);
                    user.setBackgroundResource(R.drawable.squicircle);
                    iuser.setImageResource(R.drawable.user);
                }
                else {
                    doctor.setBackgroundResource(R.drawable.squicircle);
                    idoctor.setImageResource(R.drawable.doctoricon);

                }

            }
        });
        coach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=2;
                if (count==2){
                    coach.setBackgroundResource(R.drawable.tealback);
                    icoach.setImageResource(R.drawable.wcoach);
                    doctor.setBackgroundResource(R.drawable.squicircle);
                    idoctor.setImageResource(R.drawable.doctoricon);
                    user.setBackgroundResource(R.drawable.squicircle);
                    iuser.setImageResource(R.drawable.user);
                }
                else {
                    coach.setBackgroundResource(R.drawable.squicircle);
                    icoach.setImageResource(R.drawable.coach);

                }
            }
        });
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count=3;
                if (count==3){
                    user.setBackgroundResource(R.drawable.tealback);
                    iuser.setImageResource(R.drawable.wuser);
                    doctor.setBackgroundResource(R.drawable.squicircle);
                    idoctor.setImageResource(R.drawable.doctoricon);
                    coach.setBackgroundResource(R.drawable.squicircle);
                    icoach.setImageResource(R.drawable.coach);
                }
                else {
                    user.setBackgroundResource(R.drawable.squicircle);
                    iuser.setImageResource(R.drawable.user);

                }
            }
        });


    }
}