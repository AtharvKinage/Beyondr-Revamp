package com.innovations.beyondr.Notifications;

import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.Doctor;
import com.amplifyframework.datastore.generated.model.Notifications;
import com.amplifyframework.datastore.generated.model.Request;
import com.innovations.beyondr.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class NotificationsRecyclerAdapterUser
        extends RecyclerView.Adapter<NotificationsRecyclerAdapterUser.myviewholder>
    {
        ArrayList<Notifications> arrayList;
        Context context;

    public NotificationsRecyclerAdapterUser(ArrayList < Notifications > arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

        @NonNull
        @Override
        public myviewholder onCreateViewHolder (@NonNull ViewGroup parent,int viewType){
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.notificationrecycler, parent, false);

        return new myviewholder(view);
    }

        @Override
        public void onBindViewHolder (@NonNull myviewholder holder,int position){
            Amplify.API.query(
                    ModelQuery.list(Doctor.class, Doctor.USER_ID.eq(arrayList.get(position).getDoctorid())),
                    response -> {
                        for (Doctor todo : response.getData()) {
                            runOnUiThread(() -> {
                             String   doctorname = todo.getName();
                                if (arrayList.get(position).getRequest() == Request.CONFIRMED) {
                                    holder.description.setText("Your Appointment has been Confirmed by " + doctorname);
                                    holder.heading.setText("Appointment Confirmed");
                                } else if (arrayList.get(position).getRequest() == Request.REQUESTED) {
                                    holder.description.setText("Your Appointment Request has been initiated with "+ doctorname);
                                    holder.heading.setText("Appointment Requested");
                                }else if (arrayList.get(position).getRequest() == Request.REJECTED) {
                                    holder.heading.setText("Appointment Rejected");
                                    holder.description.setText("Your Appointment has been Rejected by "+ doctorname);
                                }else if (arrayList.get(position).getRequest() == Request.CANCELLED) {
                                    holder.heading.setText("Appointment Cancelled");
                                    holder.description.setText("Appointment is cancelled with "+ doctorname);

                                }


                            });

                        }
                    },
                    error -> Log.e("MyAmplifyApp", "Query failure", error)
            );
            Temporal.DateTime date = arrayList.get(position).getDate();
            Date date1 = date.toDate();
            SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy " );//formating according to my need
            String date2 = formatter.format(date1);
            holder.time.setText(date2);


    }

        @Override
        public int getItemCount () {
        return arrayList.size();
    }

        public class myviewholder extends RecyclerView.ViewHolder {
            TextView title, description, time, heading;
            ImageView profileimage;

            public myviewholder(@NonNull View itemView) {
                super(itemView);
                //time = itemView.findViewById(R.id.timetext);
                heading = itemView.findViewById(R.id.post);
                profileimage = itemView.findViewById(R.id.profile_image);
                title = itemView.findViewById(R.id.post);
                description = itemView.findViewById(R.id.description);
            }
        }

}
