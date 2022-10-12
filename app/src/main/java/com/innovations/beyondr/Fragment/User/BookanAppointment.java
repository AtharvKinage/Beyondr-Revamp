package com.innovations.beyondr.Fragment.User;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.innovations.beyondr.AppointmentAdapter;
import com.innovations.beyondr.Coach;
import com.innovations.beyondr.Doctors;
import com.innovations.beyondr.R;
import com.innovations.beyondr.ViewPagerAdapter;
import com.innovations.beyondr.WalletActivity;

public class BookanAppointment extends Fragment {
    Context context;
    View view;
    TabLayout tabLayout;
    ViewPager viewPager;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.bookanappointment, container, false);

        init();
        return view;
    }

    private void init() {

        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        ViewPager viewPager = view.findViewById(R.id.viewpager);

        AppointmentAdapter adapter = new AppointmentAdapter(getChildFragmentManager());

        adapter.AddFragment(new Doctors(), "Doctor");
        adapter.AddFragment(new Coach(), "Coach");

        viewPager.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        tabLayout.setupWithViewPager(viewPager);

        initElements2();
        initListeners2();
        initActions2();
    }

    private void initElements2() {


    }

    private void initActions2() {
    }

    private void initListeners2() {

    }
}
