package com.innovations.beyondr.Fragment.User;

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
public class HealthRecordFragment extends Fragment {
    Context context;
    View view;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.healthrecordfragmentuser, container, false);
        init();
        return view;
    }

    private void init() {
        initElements2();
        initListeners2();
        initActions2();
    }

    private void initElements2() {


    }

    private void initActions2() {
    }

    private void initListeners2() {
        TextView coach = view.findViewById(R.id.coach);
        TextView doctor = view.findViewById(R.id.doctor);
        getFragmentManager().beginTransaction().replace(R.id.viewPagerhealth,new SummaryFragment()).commit();
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doctor.setTextColor(getResources().getColor(R.color.blue));
                coach.setTextColor(getResources().getColor(R.color.black_half_transparent));

                getFragmentManager().beginTransaction().replace(R.id.viewPagerhealth,new SummaryFragment()).commit();
            }
        });

        coach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coach.setTextColor(getResources().getColor(R.color.blue));
                doctor.setTextColor(getResources().getColor(R.color.black_half_transparent));
                getFragmentManager().beginTransaction().replace(R.id.viewPagerhealth,new Visitsuer()).commit();
            }
        });

    }
}
