package com.innovations.beyondr;

import android.content.Context;
import android.graphics.Color;
import android.text.format.DateFormat;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.innovations.Model;
import com.innovations.beyondr.Fragment.User.DoctorsFragmentBookAppointment;
import com.innovations.beyondr.R;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class CalendatDatesRecyclerAdapter extends RecyclerView.Adapter<CalendatDatesRecyclerAdapter.myviewholder> {
    ArrayList<Model> arrayList;
    Doctors doctors;
    Context context;
    ArrayList<Integer> integers = new ArrayList<>();

    public CalendatDatesRecyclerAdapter(ArrayList<Model> arrayList, Context context) {
        this.arrayList = arrayList;
        this.doctors = doctors;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.calendardaterecycleritem, parent,false);
        return new CalendatDatesRecyclerAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        java.text.DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);

        if(arrayList.get(position).getaBoolean()){
            holder.frameLayout.setBackgroundColor(context.getResources().getColor(R.color.purple_200));
        }
        else{
            holder.frameLayout.setBackgroundColor(Color.WHITE);
        }

        if(arrayList.get(position).getDate().equals(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()))){
            holder.day.setText("Today");
        }
        else {
            holder.day.setText(String.valueOf(DateFormat.format("EE", arrayList.get(position).getDate())));
        }
        holder.date.setText(String.valueOf(DateFormat.format("dd", arrayList.get(position).getDate())));
        holder.frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                doctorsFragmentBookAppointment.clcikoncaldendar(holder, position, arrayList);

                for(int i=0; i<arrayList.size(); i++){
                    if(arrayList.get(i).getaBoolean()){
                        arrayList.get(i).setaBoolean(false);
                    }
                }

                arrayList.get(position).setaBoolean(true);
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        LinearLayout frameLayout;
        TextView date, day;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
            date = itemView.findViewById(R.id.date);
            frameLayout = itemView.findViewById(R.id.framelayout);
        }
    }
}