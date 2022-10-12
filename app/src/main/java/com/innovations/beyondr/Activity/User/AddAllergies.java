package com.innovations.beyondr.Activity.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Allergies;
import com.innovations.beyondr.R;

public class AddAllergies extends AppCompatActivity {
    EditText allergy , description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_allergies);
        allergy = findViewById(R.id.allergy);
        description = findViewById(R.id.description);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
    public void saveclick(View view) {
        if (allergy.getText().toString().trim().isEmpty()){

        }else if (description.getText().toString().trim().isEmpty()){

        }else {
            Allergies allergies = Allergies.builder()
                    .userid(Amplify.Auth.getCurrentUser().getUserId())
                    .allergyname(allergy.getText().toString().trim())
                    .description(description.getText().toString().trim())
                    .build();
            Amplify.API.mutate(
                    ModelMutation.create(allergies),
                    response -> pressback(),
                    error -> Log.e("MyAmplifyApp", "Create failed", error)
            );
        }
    }
    private void pressback() {
        //Toast.makeText(AddHealthRecord.this, "", Toast.LENGTH_LONG).show();
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
            }
        });
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