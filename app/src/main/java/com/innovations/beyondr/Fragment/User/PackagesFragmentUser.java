package com.innovations.beyondr.Fragment.User;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Doctor;
import com.amplifyframework.datastore.generated.model.DoctorType;
import com.amplifyframework.datastore.generated.model.Packages;
import com.google.android.material.tabs.TabLayout;
import com.innovations.beyondr.Activity.User.CoachesPackagesActivity;
import com.innovations.beyondr.Activity.User.DoctorsPackagesActivity;
import com.innovations.beyondr.Adapter.DoctorRecyclerAdapter;
import com.innovations.beyondr.R;

import java.util.ArrayList;

import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;

public class PackagesFragmentUser extends Fragment {
    Context context;
    View view;
    ArrayList<Doctor> doctorArrayListPackages = new ArrayList<>();
    ArrayList<Doctor> coachArrayListPackages = new ArrayList<>();
    RecyclerView recyclerViewcoach , recyclerviewdoctor;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.packagesfragment, container, false);
        init();
        return view;
    }

    private void init() {
        initElements2();
        initListeners2();
        initActions2();
    }

    private void initElements2() {

        TextView textView = view.findViewById(R.id.more);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DoctorsPackagesActivity.class);
                context.startActivity(intent);
            }
        });
        TextView textViewcoach = view.findViewById(R.id.morecoach);
        textViewcoach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CoachesPackagesActivity.class);
                context.startActivity(intent);
            }
        });
        recyclerViewcoach = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewcoach.setLayoutManager(layoutManager);

        recyclerviewdoctor = view.findViewById(R.id.doc);
        LinearLayoutManager layoutManager2
                = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        recyclerviewdoctor.setLayoutManager(layoutManager2);


    }

    private void initActions2() {
    }

    private void initListeners2() {

    }
    @Override
    public void onStart() {
        super.onStart();
        querypackagesforcoach();
        querypackagesfordoctors();
    }

    private void querypackagesforcoach() {
        Amplify.API.query(
                ModelQuery.list(Packages.class, Packages.DOCTORTYPE.eq(DoctorType.COACH)),
                response -> {
                    for (Packages todo : response.getData()) {
                        // if (todo.getSpecialization() == doctortype) {

                        getCoach(todo.getDoctorId());
                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
    }



    private void querypackagesfordoctors() {
        Amplify.API.query(
                ModelQuery.list(Packages.class, Packages.DOCTORTYPE.eq(DoctorType.DOCTOR)),
                response -> {
                    for (Packages todo : response.getData()) {
                        // if (todo.getSpecialization() == doctortype) {
                        getDoctors(todo.getDoctorId());
                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
    }

    private void getCoach(String doctorId) {
        Amplify.API.query(
                ModelQuery.list(Doctor.class, Doctor.DOCTORTYPE.eq(DoctorType.COACH).and(Doctor.USER_ID.eq(doctorId))),
                response -> {
                    for (Doctor todo : response.getData()) {
                        if (!coachArrayListPackages.contains(todo)){
                            coachArrayListPackages.add(todo);
                        }
                        runOnUiThread(() -> {

                            DoctorRecyclerAdapter doctorRecyclerAdapter = new
                                    DoctorRecyclerAdapter(coachArrayListPackages,context,false);
                            doctorRecyclerAdapter.notifyDataSetChanged();

                            recyclerViewcoach.setAdapter(doctorRecyclerAdapter);
                        });
//                    }
                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
    }
    private void getDoctors(String doctorId) {
        Amplify.API.query(
                ModelQuery.list(Doctor.class, Doctor.DOCTORTYPE.eq(DoctorType.DOCTOR).and(Doctor.USER_ID.eq(doctorId))),
                response -> {
                    for (Doctor todo : response.getData()) {
                        if (!doctorArrayListPackages.contains(todo)){
                            doctorArrayListPackages.add(todo);
                        }
                        runOnUiThread(() -> {
                            DoctorRecyclerAdapter doctorRecyclerAdapter = new
                                    DoctorRecyclerAdapter(doctorArrayListPackages,context,true);


                            doctorRecyclerAdapter.notifyDataSetChanged();

                            recyclerviewdoctor.setAdapter(doctorRecyclerAdapter);
                        });
//                    }
                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
    }

}
