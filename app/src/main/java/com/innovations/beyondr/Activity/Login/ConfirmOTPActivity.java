package com.innovations.beyondr.Activity.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.result.AuthSignInResult;
import com.amplifyframework.auth.result.AuthSignUpResult;
import com.amplifyframework.core.Amplify;
import com.innovations.beyondr.Activity.User.UserDatabase;
import com.innovations.beyondr.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ConfirmOTPActivity extends AppCompatActivity {
    EditText otpBox1, otpBox2, otpBox3, otpBox4, otpBox5, otpBox6;
    String otp;
    Intent intent;
    String tokenid;
    EditText otpedittext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_o_t_p);
        otpedittext = findViewById(R.id.etpassword);

    }
    public void back(View view) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
            }
        });
    }
    private String getEmail() {
        intent = getIntent();
        String email =   intent.getStringExtra("Email");
        return email;



    }
    private String getName(){
        intent = getIntent();
        String name = intent.getStringExtra("Name");
        return name;
    }

    public void verifyotp(View view) {

        otp = otpedittext.getText().toString().trim();
        if (otpedittext.getText().toString().trim().isEmpty()){
            otpedittext.setError("Plaese Enter OTP");
        }else {
            Amplify.Auth.confirmSignUp(
                    getEmail(),
                    otp,
                    this::onSuccess,
                    this::onError
            );
        }


    }

    private void onError(AuthException e) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.e("TAG", "Exception" + e);

                Toast.makeText(ConfirmOTPActivity.this," "+ e, Toast.LENGTH_LONG).show();
            }
        });

    }
    private void onSuccess(AuthSignUpResult authSignUpResult) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Log.e("TAG", "Exception" + "onsuccess");
                reLogin();
            }
        });
        ;



//        Intent intent = new Intent(this, UserDatabase.class);
//        startActivity(intent);
//        finish();
    }
    private void reLogin() {
        Log.e("TAG", "Exception" + "inrelogin");
        String username = getEmail();
        String password = getPassword();
        Amplify.Auth.signIn(
                username,
                password,
                this::onLoginSuccess,
                this::onError
        );
    }

    private void onLoginSuccess(AuthSignInResult authSignInResult) {
        Log.e("TAG", "Exception" + "in login success");
        //YYYY-MM-DDThh:mm:ss.sssZ.
        Date currentTime = Calendar.getInstance().getTime();
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(ConfirmOTPActivity.this,"Your Account has been successfully created", Toast.LENGTH_LONG).show();
            }
        });

        Intent intent =new Intent(ConfirmOTPActivity.this, UserDatabase.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);

    }

    private String getPassword() {
        intent = getIntent();
        String password =   intent.getStringExtra("Password");
        return password;
    }

}