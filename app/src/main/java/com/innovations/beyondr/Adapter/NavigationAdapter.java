package com.innovations.beyondr.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.innovations.beyondr.Fragment.User.HomeFragmentUser;
import com.innovations.beyondr.Model.MainNavModel;
import com.innovations.beyondr.R;

import java.util.List;
public class NavigationAdapter extends BaseAdapter {
    private HomeFragmentUser context;
    private List<MainNavModel> navModelList;
    private String TAG = "Main Nav Adapter";

    public NavigationAdapter(HomeFragmentUser context, List<MainNavModel> navModelList) {
        this.context = context;
        this.navModelList = navModelList;
    }

    @Override
    public int getCount() {
        return navModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return navModelList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        View rowView = LayoutInflater.from(context.getActivity().getApplicationContext())
                .inflate(R.layout.cardview_main_nav2, viewGroup, false);
        // context.getApplicationContext()).inflate(R.layout.cardview_main_nav, viewGroup, false);
        MainNavModel navModel = navModelList.get(i);
        ImageView icon = rowView.findViewById(R.id.nav_icon);
        TextView itemName = rowView.findViewById(R.id.nav_item_name);
        icon.setImageDrawable(navModelList.get(i).getImage_drawable());
        itemName.setText(navModelList.get(i).getItem_name());



        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.closeDrawer();
                if (i ==1){
                    context.userprofileintent();
                    //  contextq.startActivity(new Intent(contextq, UserProfileActivity.class));
                }
                else if (i ==2){
                    context.gotonotifications();
                    //  contextq.startActivity(new Intent(contextq, UserProfileActivity.class));
                }
                else if(i==3){
                    context.calendaractivityintent();
                    //  contextq.startActivity(new Intent(contextq, CalendarActivityUser.class));
                }
                else if(i==4){
                    context.enterasadoctorintent();
                    // context.userprofileintent();
                    //  contextq.startActivity(new Intent(contextq, DoctorDatabase1.class));

                } else if(i==5) {
                    context.gotoinvites();
                    //  contextq.startActivity(new Intent(contextq, DoctorDatabase1.class));

//                }else if(i==8){
//                    context.admin();
//                    //  contextq.startActivity(new Intent(contextq, DoctorDatabase1.class));
//                }

                } else if(i==7){
                    context.enterasacoach();
                    //  contextq.startActivity(new Intent(contextq, DoctorDatabase1.class));

                } else if(i==8){
                    context.signout();
                    //  contextq.startActivity(new Intent(contextq, DoctorDatabase1.class));
                }
//                else if(i==5){
//                    context.gotostripeactivity();
                //  contextq.startActivity(new Intent(contextq, DoctorDatabase1.class));
                //    }
                else if(i==6){
                    context.contactus();
                    //  contextq.startActivity(new Intent(contextq, DoctorDatabase1.class));
                }



            }
        });
        return rowView;
    }

}