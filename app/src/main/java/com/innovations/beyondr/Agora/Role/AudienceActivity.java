package com.innovations.beyondr.Agora.Role;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.BroadCast;
import com.amplifyframework.datastore.generated.model.Doctor;
import com.amplifyframework.datastore.generated.model.DoctorType;
import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.innovations.beyondr.Agora.activities.BaseActivity;
import com.innovations.beyondr.Agora.activities.LiveActivity;
import com.innovations.beyondr.R;

import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import io.agora.rtc.Constants;

public class AudienceActivity extends BaseActivity {
    ImageView imageView, profilepic;
    TextView name , specialization , location, about , education, insurace, clinicaddress;
    MaterialCardView card,card2;
    LinearLayout message, bookmyappointment;
    ImageView messageImage;
    private static final int MIN_INPUT_METHOD_HEIGHT = 200;
    private static final int ANIM_DURATION = 200;

    // Permission request code of any integer value
    private static final int PERMISSION_REQ_CODE = 1 << 4;

    public static final String KEY_CLIENT_ROLE = "key_client_role";
    private String[] PERMISSIONS = {
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.CAMERA,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };
    String doctorid;
    private Rect mVisibleRect = new Rect();
    private int mLastVisibleHeight = 0;
    private RelativeLayout mBodyLayout;
    private int mBodyDefaultMarginTop;
    private TextView mTopicEdit, mDisplayNameEdit;
    private TextView mStartBtn;
    private ImageView mLogo;
    private RadioButton broadcasterRadio, audienceRadio;
    String meetingid;
    TextView communityyname, description;
    TextView time;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audience);
        config().setRole(Constants.CLIENT_ROLE_AUDIENCE);
        Intent intent = getIntent();
        meetingid=  intent.getStringExtra("meetingid");
        int viewplan = intent.getIntExtra("live", 0);
        if (viewplan == 1){
            TextView button = findViewById(R.id.viewPlan);
            button.setVisibility(View.GONE);
        }
        about = findViewById(R.id.about);
        education = findViewById(R.id.education);
        clinicaddress = findViewById(R.id.aa);
//        messageImage = findViewById(R.id.messageimage);
//        insurace =findViewById(R.id.insurance);
        card2 = findViewById(R.id.aboutandeducation);
        profilepic =findViewById(R.id.profile_image);
        imageView= findViewById(R.id.imageprofileslidedown);
        name = findViewById(R.id.name);
        specialization = findViewById(R.id.education);
        card = findViewById(R.id.card);
        location =findViewById(R.id.location);
        bookmyappointment =findViewById(R.id.bookmyappointment);
        Amplify.API.query(
                ModelQuery.list(BroadCast.class,BroadCast.ID.eq(meetingid)),
                response -> {
                    for (BroadCast todo : response.getData()) {
                        runOnUiThread(() -> {
                          doctorid = todo.getDoctorId();
                          adddetailsfordoctor();
                            communityyname =findViewById(R.id.text);
                            description = findViewById(R.id.description);
                            description.setText(todo.getDescription());
                            time = findViewById(R.id.time);
                           communityyname.setText(todo.getName() );
                            long fromOffset =todo.getDate().getOffsetTotalSeconds();
                            long toOffset = getOffset();
                            long convertedTime = todo.getDate().toDate().getTime() - (fromOffset - toOffset);
                            Date convertedDate = new Date(convertedTime);
                            int hours = convertedDate.getHours();
                            int minutes = convertedDate.getMinutes();
                            String time2 = (hours < 10 ? "0" + Integer.toString(hours) : Integer.toString(hours))
                                    + ":" + (minutes < 10 ? "0" + Integer.toString(minutes) : Integer.toString(minutes));

                            time.setText(
                                    DateFormat.getDateInstance().format(convertedDate) + ","  + time2
                            );

                        });

                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );

    }
    private int getOffset() {
        GregorianCalendar calendar = new GregorianCalendar();
        TimeZone timeZone = calendar.getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        return (int) TimeUnit.SECONDS.convert(rawOffset, TimeUnit.MILLISECONDS);
    }
    private void putimage2( URL url) {
        if (url != null){
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    Log.e("TAG", "D" + url );
                    Glide.with(profilepic.getContext())
                            .load(url)
                            .placeholder(R.drawable.profile)
                            .into(profilepic);
                }
            });
        }
    }

    private void adddetailsfordoctor() {

        Amplify.API.query(
                ModelQuery.list(Doctor.class, Doctor.USER_ID.eq(doctorid)),
                response -> {
                    for (Doctor todo : response.getData()) {
                        runOnUiThread(() -> {
                            Amplify.Storage.getUrl(
                                    todo.getUserId() + "doctorpic" ,
                                    // this::onNewMessageReceived,
                                    //sucess-> putimage(holder, ),
                                    result -> putimage2(result.getUrl() ),
                                    error -> Log.e("MyAmplifyApp", "URL generation failure", error)
                            );

                            name.setText(todo.getName());
                            specialization.setText(todo.getSpecialization());
                            location.setText(todo.getCountry() + "," + todo.getState());
                            insurace = findViewById(R.id.experience);
                            if (todo.getInsurance().trim() == "1"){
                                insurace.setText("Not Accepted");
                            }
                            if (todo.getInsurance().trim() != "1"){
                               insurace.setText("Accepted");

                            }
                            clinicaddress.setText(todo.getLocaladdress() +" " +todo.getCountry() + " " +todo.getZipcode());
//                            card.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    Intent intent = new Intent(AudienceActivity.this, DoctorProfilebyBookAnAppointment.class);
//                                    if (todo.getDoctortype() == DoctorType.COACH){
//                                        intent.putExtra("docorcoach", 2);
//                                    }
//                                    if (todo.getDoctortype() == DoctorType.DOCTOR){
//                                        intent.putExtra("docorcoach", 1);
//                                    }
//                                    intent.putExtra("id", todo.getId());
//                                    intent.putExtra("userid", todo.getUserId());
//                                    intent.putExtra("name",todo.getName());
//                                    intent.putExtra("specialization",todo.getSpecialization());
//                                    intent.putExtra("about",todo.getAbout());
//                                    intent.putExtra("country",todo.getCountry());
//                                    // intent.putExtra("",arrayList.get(position).getCountry());
//                                    intent.putExtra("gender",todo.getGender());
//                                    intent.putExtra("languagesspoken",todo.getLanguagesspoken());
//                                    intent.putExtra("npi",todo.getNpi());
//                                    intent.putExtra("yoe",todo.getYearsofexxperience());
//
//                                    startActivity(intent);
//                                }
//                            });
//                         bookmyappointment.setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    Intent intent1 = new Intent(AudienceActivity.this, AppointmentBookActivity.class);
//                                    intent1.putExtra("id",todo.getId());
//                                    intent1.putExtra("userid",todo.getUserId());
//                                    if (todo.getDoctortype()== DoctorType.COACH){
//                                        intent1.putExtra("doctor", false);
//                                    }else {
//                                        intent1.putExtra("doctor", true);
//                                    }
//                                    startActivity(intent1);
//                                }
//                            });


                        });



                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );

}
    public void back(View view) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
            }
        });
    }

    public void onStartBroadcastClicked(View view) {
        checkPermission();
    }

    private void checkPermission() {
        boolean granted = true;
        for (String per : PERMISSIONS) {
            if (!permissionGranted(per)) {
                granted = false;
                break;
            }
        }

        if (granted) {

            resetLayoutAndForward();
        } else {
            requestPermissions();
        }
    }

    private boolean permissionGranted(String permission) {
        return ContextCompat.checkSelfPermission(
                this, permission) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermissions() {
        ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSION_REQ_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[], @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQ_CODE) {
            boolean granted = true;
            for (int result : grantResults) {
                granted = (result == PackageManager.PERMISSION_GRANTED);
                if (!granted) break;
            }

            if (granted) {
                resetLayoutAndForward();
            } else {
                toastNeedPermissions();
            }
        }
    }

    private void resetLayoutAndForward() {
        closeImeDialogIfNeeded();
        // gotoRoleActivity();
        gotoLiveActivity();
    }

    private void closeImeDialogIfNeeded() {
//        InputMethodManager manager = (InputMethodManager)
//                getSystemService(INPUT_METHOD_SERVICE);
//        manager.hideSoftInputFromWindow(mTopicEdit.getWindowToken(),
//                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void gotoRoleActivity() {
        Intent intent = new Intent(AudienceActivity.this, LiveActivity.class);
        String room = meetingid;
        String name = meetingid;
        config().setChannelName(room);
        config().setDisplayName(name);
        startActivity(intent);
    }
    public void gotoLiveActivity(){


        Intent intent = new Intent(AudienceActivity.this, LiveActivity.class);
        intent.putExtra(KEY_CLIENT_ROLE, config().getRole());
        intent.setClass(getApplicationContext(), LiveActivity.class);
        Intent intent1 = getIntent();
        String meetingid = intent1.getStringExtra("meetingid");

        String room = meetingid;
        String name = meetingid;
        intent.putExtra("IntLiveCount", 1);
        intent.putExtra("name",name);
        intent.putExtra("meetingid", meetingid);

        intent.putExtra("topic",room);
        config().setChannelName(room);
        config().setDisplayName(name);
        startActivity(intent);
    }


    private void toastNeedPermissions() {
        Toast.makeText(this, R.string.need_necessary_permissions, Toast.LENGTH_LONG).show();
    }
}