package com.innovations.beyondr.Activity.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthUser;
import com.amplifyframework.auth.result.AuthSignInResult;
import com.amplifyframework.core.Amplify;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.innovations.beyondr.Activity.User.MainScreenUser;
import com.innovations.beyondr.Activity.User.UserDatabase;
import com.innovations.beyondr.Common.SharedPref;
import com.innovations.beyondr.Common.Util;
import com.innovations.beyondr.R;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail, etPassword;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = findViewById(R.id.editTextTextEmailAddress);
        progressBar = findViewById(R.id.p);
        etPassword = findViewById(R.id.editTextTextPassword);
    }
    @Override
    protected void onStart() {
        super.onStart();
        if(Amplify.Auth.getCurrentUser()!=null)
        {
            FirebaseInstanceId.getInstance().getInstanceId().addOnSuccessListener(new OnSuccessListener<InstanceIdResult>() {
                @Override
                public void onSuccess(InstanceIdResult instanceIdResult) {
                    Util.updateDeviceToken(LoginActivity.this, instanceIdResult.getToken() );
                    Log.e("TAG", "token" + instanceIdResult.getToken());
                }
            });

            AuthUser currentUser = Amplify.Auth.getCurrentUser();
            Intent intent;
            if (currentUser == null) {

            } else {
                Amplify.API.query(
                        ModelQuery.list(com.amplifyframework.datastore.generated.model.UserDatabase.class, com.amplifyframework.datastore.generated.model.UserDatabase.USER_ID.eq(Amplify.Auth.getCurrentUser().getUserId())),
                        response -> { runOnUiThread(() -> {
                            for (com.amplifyframework.datastore.generated.model.UserDatabase todo : response.getData()) {
                                Log.e("MyAmplifyApp", "Query" + response.getData());
                                if (response.getData() !=null){
                                    Intent intent10 =new Intent(LoginActivity.this, MainScreenUser.class);
                                    intent10.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    SharedPref.setBooleanInPreferences("userdata", true,this);
                                    startActivity(intent10);
                                    finish();
                                }else {
                                    Intent  intent12 = new Intent(getApplicationContext(), UserDatabase.class);
                                    intent12.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                    startActivity(intent12);
                                    finish();
                                }
                            }});
                        },
                        error -> Log.e("MyAmplifyApp", "Query failure", error)
                );
            }


        }
    }
    public void back(View view) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
            }
        });
    }
    public void neeedhelp(View view) {
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
    }

    public void signup(View view) {
        startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
    }

    public void signinclick(View view) {
        progressBar.setVisibility(View.VISIBLE);
        if ( etEmail.getText().toString().trim().isEmpty()){
            progressBar.setVisibility(View.GONE);
            etEmail.setError("Enter Email");
        }else if (etPassword.getText().toString().trim().isEmpty()){
            progressBar.setVisibility(View.GONE);
            etPassword.setError("Enter Password");
        }else {

            Amplify.Auth.signIn(
                    etEmail.getText().toString().trim(),
                    etPassword.getText().toString().trim(),
                    this::onLoginSuccess,
                    this::onLoginError

            );
        }


    }

    private void onLoginError(AuthException e) {
        this.runOnUiThread(() -> {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG)
                    .show();
        });
    }

    private void onLoginSuccess(AuthSignInResult authSignInResult) {
        Amplify.API.query(
                ModelQuery.list(com.amplifyframework.datastore.generated.model.UserDatabase.class, com.amplifyframework.datastore.generated.model.UserDatabase.USER_ID.eq(Amplify.Auth.getCurrentUser().getUserId())),
                response -> { runOnUiThread(() -> {
                    if (String.valueOf(response.getData().getItems())  == "[]" ){
                        Log.e("MyAmplifyApp", "doctorresponse" + " null");
                        runOnUiThread(() -> {
                            Intent  intent12 = new Intent(getApplicationContext(), UserDatabase.class);
                            intent12.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent12);
                            progressBar.setVisibility(View.GONE);
                            finish();
                        });
                    }
                    for (com.amplifyframework.datastore.generated.model.UserDatabase todo : response.getData()) {
                        Log.e("MyAmplifyApp", "Query" + response.getData());
                        if (response.getData() !=null){
                            Intent intent10 =new Intent(LoginActivity.this, MainScreenUser.class);
                            intent10.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            SharedPref.setBooleanInPreferences("userdata", true,this);
                            startActivity(intent10);
                            progressBar.setVisibility(View.GONE);
                            finish();
                        }else {
                            Intent  intent12 = new Intent(getApplicationContext(), UserDatabase.class);
                            intent12.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent12);
                            progressBar.setVisibility(View.GONE);
                            finish();
                        }
                    }});
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );

    }

}