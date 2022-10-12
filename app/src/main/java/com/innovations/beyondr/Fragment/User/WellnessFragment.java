package com.innovations.beyondr.Fragment.User;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.innovations.beyondr.R;

public class WellnessFragment extends Fragment {
    Context context;
    View view;
    TextView packages , teams , learnings , activity;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.wellnessfragment, container, false);
        init();
        return view;
    }

    private void init() {
        initElements2();
        initListeners2();
        initActions2();
    }

    private void initElements2() {
        packages = view.findViewById(R.id.packages);
        teams = view.findViewById(R.id.teams);
        learnings = view.findViewById(R.id.learnings);
        activity = view.findViewById(R.id.reviewbtn2);
        getFragmentManager().beginTransaction().replace(R.id.fragment_container2,new PackagesFragmentUser()).commit();


    }

    private void initActions2() {
    }

    private void initListeners2() {
        getFragmentManager().beginTransaction().replace(R.id.fragment_container2,new PackagesFragmentUser()).commit();
        packages.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                packages.setTextColor(getResources().getColor(R.color.blue));
                teams.setTextColor(getResources().getColor(R.color.black_half_transparent));
                learnings.setTextColor(getResources().getColor(R.color.black_half_transparent));
                activity.setTextColor(getResources().getColor(R.color.black_half_transparent));
                getFragmentManager().beginTransaction().replace(R.id.fragment_container2,new PackagesFragmentUser()).commit();
            }
        });
        teams.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                packages.setTextColor(getResources().getColor(R.color.black_half_transparent));
                teams.setTextColor(getResources().getColor(R.color.blue));
                learnings.setTextColor(getResources().getColor(R.color.black_half_transparent));
                activity.setTextColor(getResources().getColor(R.color.black_half_transparent));
                getFragmentManager().beginTransaction().replace(R.id.fragment_container2,new TeamsFragment()).commit();
            }
        });
        learnings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                packages.setTextColor(getResources().getColor(R.color.black_half_transparent));
                teams.setTextColor(getResources().getColor(R.color.black_half_transparent));
                learnings.setTextColor(getResources().getColor(R.color.blue));
                activity.setTextColor(getResources().getColor(R.color.black_half_transparent));
                getFragmentManager().beginTransaction().replace(R.id.fragment_container2,new LearningsFragment()).commit();
            }
        });
        activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                packages.setTextColor(getResources().getColor(R.color.black_half_transparent));
                teams.setTextColor(getResources().getColor(R.color.black_half_transparent));
                learnings.setTextColor(getResources().getColor(R.color.black_half_transparent));
                activity.setTextColor(getResources().getColor(R.color.blue));
                getFragmentManager().beginTransaction().replace(R.id.fragment_container2,new ActivityFragment()).commit();
            }
        });
    }
}
