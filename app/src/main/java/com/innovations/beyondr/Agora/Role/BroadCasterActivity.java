package com.innovations.beyondr.Agora.Role;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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
import com.innovations.beyondr.Agora.activities.BaseActivity;
import com.innovations.beyondr.Agora.activities.LiveActivity;
import com.innovations.beyondr.R;

import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import io.agora.rtc.Constants;

public class BroadCasterActivity extends BaseActivity {
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
    TextView communityyname, description;
    TextView time;
    private Rect mVisibleRect = new Rect();
    private int mLastVisibleHeight = 0;
    private RelativeLayout mBodyLayout;
    private int mBodyDefaultMarginTop;
    private TextView mTopicEdit, mDisplayNameEdit;
    private TextView mStartBtn;
    private ImageView mLogo;
    private RadioButton broadcasterRadio, audienceRadio;
    String meetingid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broad_caster);
        config().setRole(Constants.CLIENT_ROLE_BROADCASTER);
        description = findViewById(R.id.description);

        Intent intent = getIntent();
      meetingid=  intent.getStringExtra("meetingid");
        Amplify.API.query(
                ModelQuery.list(BroadCast.class,BroadCast.ID.eq(meetingid)),
                response -> {
                    for (BroadCast todo : response.getData()) {
                        runOnUiThread(() -> {

                            description = findViewById(R.id.description);
                           description.setText(todo.getDescription());
                            time = findViewById(R.id.time);
                            communityyname =findViewById(R.id.text);
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
        Intent intent = new Intent(BroadCasterActivity.this, LiveActivity.class);
        String room = meetingid;
        String name = meetingid;
        config().setChannelName(room);
        config().setDisplayName(name);
        startActivity(intent);
    }
    public void gotoLiveActivity(){
        Intent intent = new Intent(BroadCasterActivity.this, LiveActivity.class);
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

    public void back(View view) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
            }
        });
    }

}