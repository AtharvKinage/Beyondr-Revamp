package com.innovations.beyondr.Activity.User;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.amplifyframework.api.ApiOperation;
import com.amplifyframework.api.graphql.GraphQLResponse;
import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.api.graphql.model.ModelSubscription;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.Allergies;
import com.amplifyframework.datastore.generated.model.Report;
import com.innovations.beyondr.Adapter.AllergiesRecyclerAdapter;
import com.innovations.beyondr.Adapter.PersonalHealthRecordRecyclerAdapter;
import com.innovations.beyondr.Common.SharedPref;
import com.innovations.beyondr.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class UserDatabase extends AppCompatActivity {
    EditText name, lastname , birthday, hieght, weight ,emailaddress, phonenumber, emergencycontact,streetaddress , city, zipcode, allergy,surgeries;
    RadioGroup radioGroup;
    String sex, smoke, alchol;
    int sexpos , smokepos, alcholpos;
    private Uri localFileUri, serverFileUri;
    ArrayList<Allergies> allergies = new ArrayList<>();
    AllergiesRecyclerAdapter allergiesRecyclerAdapter;
    ArrayList<Report> arrayList = new ArrayList<>();
    PersonalHealthRecordRecyclerAdapter summaryRecyclerAdapter;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_database);
        name = findViewById(R.id.name);
        lastname = findViewById(R.id.name);
        progressBar = findViewById(R.id.p);
        birthday = findViewById(R.id.birthday);
        hieght = findViewById(R.id.hieght);
        weight = findViewById(R.id.wieght);
        emailaddress = findViewById(R.id.name);
        phonenumber = findViewById(R.id.name);
        emergencycontact= findViewById(R.id.name);
        streetaddress = findViewById(R.id.name);
        city = findViewById(R.id.city);
        zipcode = findViewById(R.id.zipcode);
        Log.e("TAG", "USERID" + Amplify.Auth.getCurrentUser().getUserId());
        if (SharedPref.getBooleanInPreferences("userdata", this)){
            Intent intent =new Intent(UserDatabase.this, UserDatabase.class);
            startActivity(intent);
            finish();
        }
        Amplify.API.query(
                ModelQuery.list(com.amplifyframework.datastore.generated.model.UserDatabase.class, com.amplifyframework.datastore.generated.model.UserDatabase.USER_ID.eq(Amplify.Auth.getCurrentUser().getUserId())),
                response -> { runOnUiThread(() -> {
                    for (com.amplifyframework.datastore.generated.model.UserDatabase todo : response.getData()) {
                        Log.e("MyAmplifyApp", "Query" + response.getData());
                        if (response.getData() !=null){
                            Intent intent =new Intent(UserDatabase.this, MainScreenUser.class);
                            SharedPref.setBooleanInPreferences("userdata", true,this);
                            startActivity(intent);
                            finish();
                        }
                    }});
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
        Spinner doctortype3 = findViewById(R.id.alchol);
        doctortype3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                try {
                    alchol = doctortype3.getSelectedItem().toString();
                    Log.e("TAG","ITEM" + alchol);
                    alcholpos=position;
                    if (position ==1){
                        //   etName.setHint("University");

                    }else{
                        //   etName.setHint("Business Name");
                    }


                } catch (Exception e) {

                }

            }



            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });
        Spinner doctortype = findViewById(R.id.gender);
        doctortype.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                try {
                    sex = doctortype.getSelectedItem().toString();
                    Log.e("TAG","ITEM" + sex);
                    sexpos =position;
                    if (position ==1){
                        //   etName.setHint("University");

                    }else{
                        //   etName.setHint("Business Name");
                    }


                } catch (Exception e) {

                }

            }



            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });
        Spinner doctortype2 = findViewById(R.id.daily);
        doctortype2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView,
                                       View selectedItemView, int position, long id) {
                try {
                    smoke = doctortype2.getSelectedItem().toString();
                    Log.e("TAG","ITEM" + smoke);
                    smokepos =position;
                    if (position ==1){
                        //   etName.setHint("University");

                    }else{
                        //   etName.setHint("Business Name");
                    }


                } catch (Exception e) {

                }

            }



            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }

        });
        CircularImageView imageView = findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pickImage();
            }
        });



    }
    public void submit(View view) throws FileNotFoundException {
        progressBar.setVisibility(View.VISIBLE);
        if (name.getText().toString().trim().isEmpty()){
            progressBar.setVisibility(View.GONE);
            name.setError("Please Enter name");
        }else if (lastname.getText().toString().trim().isEmpty()){
            progressBar.setVisibility(View.GONE);
            lastname.setError("Required");
        }else if (birthday.getText().toString().trim().isEmpty()){
            progressBar.setVisibility(View.GONE);
            birthday.setError("Required");
        }else if (hieght.getText().toString().trim().isEmpty()){
            progressBar.setVisibility(View.GONE);
            hieght.setError("Required");
        }else if (weight.getText().toString().trim().isEmpty()){
            progressBar.setVisibility(View.GONE);
            weight.setError("Required");
        }else if (emailaddress.getText().toString().trim().isEmpty()){
            progressBar.setVisibility(View.GONE);
            emailaddress.setError("Required");
        }else if (phonenumber.getText().toString().trim().isEmpty()){
            progressBar.setVisibility(View.GONE);
            phonenumber.setError("Required");
        }else if (emergencycontact.getText().toString().trim().isEmpty()){
            progressBar.setVisibility(View.GONE);
            emergencycontact.setError("Required");
        }else if (streetaddress.getText().toString().trim().isEmpty()){
            progressBar.setVisibility(View.GONE);
            streetaddress.setError("Required");
        }else if (city.getText().toString().trim().isEmpty()){
            progressBar.setVisibility(View.GONE);
            city.setError("Required");
        }else if (zipcode.getText().toString().trim().isEmpty()){
            progressBar.setVisibility(View.GONE);
            zipcode.setError("Required");
        }else if (sexpos==0){
            Toast.makeText(UserDatabase.this,"Select Your Gender", Toast.LENGTH_SHORT).show();
            progressBar.setVisibility(View.GONE);
        }else if (smokepos==0){
            progressBar.setVisibility(View.GONE);
            Toast.makeText(UserDatabase.this,"Required : Do you Smoke ? ", Toast.LENGTH_SHORT).show();
        }else if (alcholpos==0){
            progressBar.setVisibility(View.GONE);
            Toast.makeText(UserDatabase.this,"Required : Do you Consume Alchol? ", Toast.LENGTH_SHORT).show();
        }else {
            progressBar.setVisibility(View.VISIBLE);
            com.amplifyframework.datastore.generated.model.UserDatabase item = com.amplifyframework.datastore.generated.model.UserDatabase.builder()
                    .userId(Amplify.Auth.getCurrentUser().getUserId())
                    .name(name.getText().toString().trim())
                    .lastname(lastname.getText().toString().trim())
                    .sex(sex)
                    .birthday(birthday.getText().toString().trim())
                    .hieght(hieght.getText().toString().trim())
                    .weight(weight.getText().toString().trim())
                    .emailaddress(emailaddress.getText().toString().trim())
                    .phonenumber(phonenumber.getText().toString().trim())
                    .emergencycontact(emergencycontact.getText().toString().trim())
                    .streetaddress(streetaddress.getText().toString().trim())
                    .city(city.getText().toString().trim())
                    .zipcode(zipcode.getText().toString().trim())
                    .smoke(smoke)
                    .alchol(alchol)
                    .date(new Temporal.DateTime(new Date(), getOffset()))
                    .build();
            Amplify.API.mutate(
                    ModelMutation.create(item),
                    response -> onSuccess(),
                    error -> Log.e("MyAmplifyApp", "Create failed", error)
            );

            if (localFileUri != null) {
                InputStream exampleInputStream = getContentResolver().openInputStream(localFileUri);

                Amplify.Storage.uploadInputStream(
                        Amplify.Auth.getCurrentUser().getUserId() + "profilepic",
                        exampleInputStream,
                        result -> Log.i("MyAmplifyApp", "Successfully uploaded: " + result.getKey()),
                        storageFailure -> Log.e("MyAmplifyApp", "Upload failed", storageFailure)
                );

            }
        }
    }

    private void onSuccess() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        });

        SharedPref.setBooleanInPreferences("userdata", true,this);

        Intent intent =new Intent(UserDatabase.this, MainScreenUser.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    public void pickImage() {

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, 101);
        } else {
            ActivityCompat.requestPermissions(UserDatabase.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 102);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {

                localFileUri = data.getData();
                CircularImageView imageView = findViewById(R.id.image);
                imageView.setImageURI(localFileUri);

            }

        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == 102) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 101);
            } else {
                Toast.makeText(UserDatabase.this, R.string.permission_required, Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void addpersonalhealthrecord(View view) {
        startActivity(new Intent(UserDatabase.this, AddHealthRecordActivity.class));
    }

    public void addallergy(View view) {
        startActivity(new Intent(UserDatabase.this, AddAllergies.class));
    }

    @Override
    protected void onStart() {
        super.onStart();

        Amplify.API.query(
                ModelQuery.list(com.amplifyframework.datastore.generated.model.UserDatabase.class, com.amplifyframework.datastore.generated.model.UserDatabase.USER_ID.eq(Amplify.Auth.getCurrentUser().getUserId())),
                response -> { runOnUiThread(() -> {
                    for (com.amplifyframework.datastore.generated.model.UserDatabase todo : response.getData()) {
                        Log.e("MyAmplifyApp", "Query" + response.getData());
                        if (response.getData() == null){

                        }else {
                            Intent intent =new Intent(UserDatabase.this, MainScreenUser.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }
                    }});
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );

        Amplify.API.query(
                ModelQuery.list(Allergies.class, Allergies.USERID.eq(Amplify.Auth.getCurrentUser().getUserId())),
                response -> { runOnUiThread(() -> {
                    for (Allergies todo : response.getData()) {
                        allergies.add(todo);


                        AllergiesRecyclerAdapter eduRecyclerAdapterDoctor = new AllergiesRecyclerAdapter(allergies , this);
                        RecyclerView recyclerView = findViewById(R.id.allergyrecyc);
                        LinearLayoutManager layoutManager2
                                = new LinearLayoutManager(UserDatabase.this, LinearLayoutManager.HORIZONTAL, false);
                        recyclerView.setLayoutManager(layoutManager2);
                        recyclerView.setAdapter(eduRecyclerAdapterDoctor);
                    }});
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
        ApiOperation subscription = Amplify.API.subscribe(
                ModelSubscription.onCreate(Allergies.class),
                onEstablished -> Log.i("ApiQuickStart", "Subscription established"),
                this::onNewMessageReceived,
                //  onCreated -> Log.i("ApiQuickStart", "Todo create subscription received: " + ((Doctor) onCreated.getData()).getName()),
                onFailure -> Log.e("ApiQuickStart", "Subscription failed", onFailure),
                () -> Log.i("ApiQuickStart", "Subscription completed")
        );
        subscription.cancel();
        Amplify.API.query(
                ModelQuery.list(Report.class, Report.USER_ID.eq(Amplify.Auth.getCurrentUser().getUserId()).and(Report.DOCTOR_ID.eq(Amplify.Auth.getCurrentUser().getUserId()))),
                response -> { runOnUiThread(() -> {
                    for (Report todo : response.getData()) {
                        arrayList.add(todo);
                        PersonalHealthRecordRecyclerAdapter eduRecyclerAdapterDoctor = new PersonalHealthRecordRecyclerAdapter(arrayList , this);
                        RecyclerView recyclerView = findViewById(R.id.healthrecordrecycler);
                        LinearLayoutManager layoutManager2
                                = new LinearLayoutManager(UserDatabase.this, LinearLayoutManager.HORIZONTAL, false);
                        recyclerView.setLayoutManager(layoutManager2);
                        recyclerView.setAdapter(eduRecyclerAdapterDoctor);
                    }});
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
        ApiOperation subscription3 = Amplify.API.subscribe(
                ModelSubscription.onCreate(Report.class),
                onEstablished -> Log.i("ApiQuickStart", "Subscription established"),
                this::onNewMessageReceived22,
                //  onCreated -> Log.i("ApiQuickStart", "Todo create subscription received: " + ((Doctor) onCreated.getData()).getName()),
                onFailure -> Log.e("ApiQuickStart", "Subscription failed", onFailure),
                () -> Log.i("ApiQuickStart", "Subscription completed")
        );
        subscription3.cancel();

    }

    private  void onNewMessageReceived22(GraphQLResponse<Report> tGraphQLResponse) {
        Report message = tGraphQLResponse.getData();
        arrayList.add(message);
        runOnUiThread(() -> summaryRecyclerAdapter.notifyDataSetChanged());
    }

    private  void onNewMessageReceived(GraphQLResponse<Allergies> tGraphQLResponse) {
        Allergies message = tGraphQLResponse.getData();
        allergies.add(message);
        runOnUiThread(() -> allergiesRecyclerAdapter.notifyDataSetChanged());
    }

    @Override
    protected void onStop() {
        super.onStop();
        allergies.clear();
        arrayList.clear();
    }

    @Override
    protected void onResume() {
        super.onResume();
        allergies.clear();
        arrayList.clear();
    }
    private int getOffset() {
        GregorianCalendar calendar = new GregorianCalendar();
        TimeZone timeZone = calendar.getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        return (int) TimeUnit.SECONDS.convert(rawOffset, TimeUnit.MILLISECONDS);
    }
}