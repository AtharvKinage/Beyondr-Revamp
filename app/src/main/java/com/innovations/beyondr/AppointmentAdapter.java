package com.innovations.beyondr;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.innovations.beyondr.Fragment.User.BookanAppointment;

import java.util.ArrayList;
import java.util.List;

public class AppointmentAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    public AppointmentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position)
    {
        return fragmentList.get(position);
    }



    public void AddFragment(Fragment fragment, String Title){
        fragmentList.add(fragment);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
