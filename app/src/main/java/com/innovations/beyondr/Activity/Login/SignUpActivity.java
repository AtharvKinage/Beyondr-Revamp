package com.innovations.beyondr.Activity.Login;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.auth.AuthException;
import com.amplifyframework.auth.AuthUserAttribute;
import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.auth.result.AuthSignUpResult;
import com.amplifyframework.core.Amplify;
import com.innovations.beyondr.R;

import java.util.ArrayList;


public class SignUpActivity extends AppCompatActivity {
    EditText Email, Password, RetypePassword, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Amplify.Auth.fetchAuthSession(
                result -> Log.i("AmplifyQuickstart", result.toString()),
                error -> Log.e("AmplifyQuickstart", error.toString())
        );
        Email = findViewById(R.id.editTextTextEmailAddress);
        //Email.setText("preyankk288@gmail.com");
        Password = findViewById(R.id.etpassword);
        // Password.setText("Prey@nk22");
        RetypePassword = findViewById(R.id.etConfirmpassword);
        //  RetypePassword.setText("Prey@nk22");
        name = findViewById(R.id.editTextTextPassword);
        // name.setText("Preyank");
    }

    public void back(View view) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
            }
        });
    }
    public void signupproceed(View view) {
        CheckBox checkBox = findViewById(R.id.checkbox);

        if (name.getText().toString().equals("")) {
            name.setError("Enter Name");
            return;
        }
        else if (Email.getText().toString().equals("")) {
            Email.setError("Enter Email");
            return;
        }
        else if (Password.getText().toString().trim().equals("") ) {

            Password.setError("Please Enter Password");
            return;
        }
        else  if (RetypePassword.getText().toString().trim().equals("") ) {

            RetypePassword.setError("Please Enter Password");
            return;
        }else if (!Password.getText().toString().trim().equals(RetypePassword.getText().toString().trim())) {

            Toast.makeText(SignUpActivity.this, "Password doesen't match", Toast.LENGTH_LONG)
                    .show();

        }else  if (!checkBox.isChecked()){
            Toast.makeText(SignUpActivity.this, "Please accept Terms and Conditions", Toast.LENGTH_LONG)
                    .show();
        }else  {

            ArrayList<AuthUserAttribute> attributes = new ArrayList<>();
            attributes.add(new AuthUserAttribute(AuthUserAttributeKey.email(),Email.getText().toString() ));
            //  attributes.add(new AuthUserAttribute(AuthUserAttributeKey.name(), name.getText().toString().trim()));
            Amplify.Auth.signUp(
                    Email.getText().toString(),
                    Password.getText().toString(),
                    AuthSignUpOptions.builder().userAttributes(attributes).build(),
                    //   AuthSignUpOptions.builder().userAttribute(AuthUserAttributeKey.email(), "my@email.com").build(),
                    this::onJoinSuccess,
                    this::onJoinError
            );
        }


    }
    private void onJoinError(AuthException e) {

        this.runOnUiThread(() -> {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG)
                    .show();
        });
    }
    private void onJoinSuccess(AuthSignUpResult authSignUpResult) {
        Intent intent = new Intent(this, ConfirmOTPActivity.class);
        intent.putExtra("Email",Email.getText().toString().trim());
        intent.putExtra("Password",Password.getText().toString().trim());
        intent.putExtra("Name", name.getText().toString().trim());
        startActivity(intent);
        finish();
    }

    public void login(View view) {
        startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
    }
}