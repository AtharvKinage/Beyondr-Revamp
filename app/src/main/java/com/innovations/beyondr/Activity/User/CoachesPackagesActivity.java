package com.innovations.beyondr.Activity.User;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Doctor;
import com.amplifyframework.datastore.generated.model.DoctorProfileReview;
import com.amplifyframework.datastore.generated.model.DoctorType;
import com.amplifyframework.datastore.generated.model.Packages;
import com.innovations.beyondr.Adapter.DoctorRecyclerAdapter;
import com.innovations.beyondr.R;

import java.util.ArrayList;


public class CoachesPackagesActivity extends AppCompatActivity {
    ArrayList<Doctor> doctorArrayListPackages = new ArrayList<>();
    RecyclerView recyclerViewcoach, recyclerviewdoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coaches_packages);
        recyclerviewdoctor = findViewById(R.id.doc);
        SearchView searchView = (SearchView) findViewById(R.id.search_recipe);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                processsearch(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                processsearch(s);
                return false;
            }
        });
        querypackagesfordoctors();


    }

    public void back(View view) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
            }
        });
    }

    private void processsearch(String s) {
        Amplify.API.query(
                ModelQuery.list(Doctor.class, Doctor.DOCTORTYPE.eq(DoctorType.COACH).and(Doctor.STATUS.eq(DoctorProfileReview.PUBLISHED)).and(Doctor.NAME.beginsWith(s)).or(Doctor.GENDER.beginsWith(s)).or(Doctor.COUNTRY.beginsWith(s)).or(Doctor.SPECIALIZATION.beginsWith(s))),
                response -> {
                    Log.e("rr", "" + response);
                    Log.e("rr", "" + response.getData());
                    if (String.valueOf(response.getData().getItems()) == "[]") {
                        Log.e("MyAmplifyApp", "doctorresponse" + " null");
                        runOnUiThread(() -> {
                            doctorArrayListPackages.clear();
                            DoctorRecyclerAdapter doctorRecyclerAdapter = new
                                    DoctorRecyclerAdapter(doctorArrayListPackages, this, true);
                            doctorRecyclerAdapter.notifyDataSetChanged();
                            recyclerviewdoctor.setAdapter(doctorRecyclerAdapter);
                        });
                    } else {
                        for (Doctor todo : response.getData()) {
                            Amplify.API.query(
                                    ModelQuery.list(Packages.class, Packages.DOCTORTYPE.eq(DoctorType.COACH).and(Packages.DOCTOR_ID.eq(todo.getUserId()))),

                                    response2 -> {
                                        runOnUiThread(() -> {
                                            if (!doctorArrayListPackages.contains(todo)) {
                                                doctorArrayListPackages.add(todo);
                                            }
                                            DoctorRecyclerAdapter doctorRecyclerAdapter = new
                                                    DoctorRecyclerAdapter(doctorArrayListPackages, this, true);
                                            doctorRecyclerAdapter.notifyDataSetChanged();

                                            recyclerviewdoctor.setAdapter(doctorRecyclerAdapter);
                                        });
                                        for (Packages todo2 : response2.getData()) {

                                            // if (todo.getSpecialization() == doctortype) {
                                            if (response2 != null) {
                                                runOnUiThread(() -> {
                                                    doctorArrayListPackages.clear();
                                                    doctorArrayListPackages.add(todo);
                                                    DoctorRecyclerAdapter doctorRecyclerAdapter = new
                                                            DoctorRecyclerAdapter(doctorArrayListPackages, this, false);


                                                    doctorRecyclerAdapter.notifyDataSetChanged();

                                                    recyclerviewdoctor.setAdapter(doctorRecyclerAdapter);
                                                });

                                            }

                                        }
                                    },
                                    error -> Log.e("MyAmplifyApp", "Query failure", error)
                            );
                            // getdoctorwithname(todo.getUserId());
//                    }
                        }
                    }


                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
    }

    private void getDoctors(String doctorId) {
        Amplify.API.query(
                ModelQuery.list(Doctor.class, Doctor.DOCTORTYPE.eq(DoctorType.COACH).and(Doctor.USER_ID.eq(doctorId))),
                response -> {
                    for (Doctor todo : response.getData()) {
                        if (!doctorArrayListPackages.contains(todo)) {
                            doctorArrayListPackages.add(todo);
                        }


                        // }
                        runOnUiThread(() -> {
                            DoctorRecyclerAdapter doctorRecyclerAdapter = new
                                    DoctorRecyclerAdapter(doctorArrayListPackages, this, false);


                            doctorRecyclerAdapter.notifyDataSetChanged();

                            recyclerviewdoctor.setAdapter(doctorRecyclerAdapter);
                        });
//                    }
                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
    }

    private void querypackagesfordoctors() {
        Amplify.API.query(
                ModelQuery.list(Packages.class, Packages.DOCTORTYPE.eq(DoctorType.COACH)),
                response -> {
                    for (Packages todo : response.getData()) {
                        // if (todo.getSpecialization() == doctortype) {
                        getDoctors(todo.getDoctorId());
                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
    }
}