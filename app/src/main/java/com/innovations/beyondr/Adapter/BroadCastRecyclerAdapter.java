package com.innovations.beyondr.Adapter;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.BroadCast;
import com.amplifyframework.datastore.generated.model.BroadCastStatus;
import com.amplifyframework.datastore.generated.model.Doctor;
import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.innovations.beyondr.Agora.Role.AudienceActivity;
import com.innovations.beyondr.Common.SharedPref;
import com.innovations.beyondr.R;

import java.net.URL;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;

public class BroadCastRecyclerAdapter extends RecyclerView.Adapter<BroadCastRecyclerAdapter.myviewholder> {
    ArrayList<BroadCast> arrayList;
    Context context;

    public BroadCastRecyclerAdapter(ArrayList<BroadCast> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }
    private int getOffset() {
        GregorianCalendar calendar = new GregorianCalendar();
        TimeZone timeZone = calendar.getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        return (int) TimeUnit.SECONDS.convert(rawOffset, TimeUnit.MILLISECONDS);
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.broadcastupcoming, parent,false);
        return new BroadCastRecyclerAdapter.myviewholder(view);
    }
    private void putimage2(BroadCastRecyclerAdapter.myviewholder holder, URL url) {
        if (url != null) {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    Log.e("TAG", "D" + url);
                    Glide.with(holder.profilepic.getContext())
                            .load(url)
                            .placeholder(R.drawable.mask)
                            .into(holder.profilepic);
                }
            });
        }
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.description.setText(arrayList.get(position).getDescription());
        Amplify.Storage.getUrl(
                arrayList.get(position).getDoctorId() + "doctorpic" ,
                // this::onNewMessageReceived,
                //sucess-> putimage(holder, ),
                result -> putimage2(holder,result.getUrl() ),
                error -> Log.e("MyAmplifyApp", "URL generation failure", error)
        );
        Amplify.API.query(
                ModelQuery.list(Doctor.class, Doctor.USER_ID.eq(arrayList.get(position).getDoctorId())),
                response -> {
                    for (Doctor todo : response.getData()) {
                        runOnUiThread(() -> {
                            holder.name.setText(todo.getName());
                            holder.specialization.setText(todo.getSpecialization());

                        });

                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
        holder.communityyname.setText(arrayList.get(position).getName() );
        long fromOffset = arrayList.get(position).getDate().getOffsetTotalSeconds();
        long toOffset = getOffset();
        long convertedTime = arrayList.get(position).getDate().toDate().getTime() - (fromOffset - toOffset);
        Date convertedDate = new Date(convertedTime);
        int hours = convertedDate.getHours();
        int minutes = convertedDate.getMinutes();
        String time = (hours < 10 ? "0" + Integer.toString(hours) : Integer.toString(hours))
                + ":" + (minutes < 10 ? "0" + Integer.toString(minutes) : Integer.toString(minutes));
        holder.time.setText(
                DateFormat.getDateInstance().format(convertedDate) + ","  + time
        );
        holder.materialCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, AudienceActivity.class);
                String room =  arrayList.get(position).getId();
                if (arrayList.get(position).getBroadCastStatus() == BroadCastStatus.NOTLIVE){
                    intent.putExtra("live", 1);
                }

                String name =  arrayList.get(position).getId();
                intent.putExtra("name", arrayList.get(position).getId());
                intent.putExtra("meetingid", arrayList.get(position).getId());
                intent.putExtra("topic",room);
                SharedPref.setVariableInPreferences("meetingid", arrayList.get(position).getId());
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ShapeableImageView imageView, profilepic;
        TextView name , specialization , location, about , education, insurace, clinicaddress;
        TextView communityyname;
        TextView time;
        ImageView communityimage;
        LinearLayout materialCardView;
        TextView description;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            description = itemView.findViewById(R.id.text2);
            name = itemView.findViewById(R.id.name);
            specialization = itemView.findViewById(R.id.aaa);
            profilepic = itemView.findViewById(R.id.communityimage);
            communityyname =itemView.findViewById(R.id.text);
            materialCardView = itemView.findViewById(R.id.materialcardview);
        }
    }

}
