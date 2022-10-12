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

import com.google.android.material.card.MaterialCardView;
import com.innovations.Model;
import com.innovations.beyondr.Fragment.User.DoctorsFragmentBookAppointment;
import com.innovations.beyondr.R;
import com.stripe.android.model.Card;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

public class TimeAdapter extends RecyclerView.Adapter<TimeAdapter.myviewholder> {
    ArrayList<Time> arrayList = new ArrayList<>();
    Context context;

    public TimeAdapter(ArrayList<Time> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.time, parent,false);
        return new TimeAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        holder.time.setText(arrayList.get(position).getTime());

        if(arrayList.get(position).getBool()){
            holder.card.setCardBackgroundColor(Color.parseColor("#EFF3FA"));
        }
        else{
            holder.card.setCardBackgroundColor(Color.WHITE);
        }
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                doctorsFragmentBookAppointment.clcikoncaldendar(holder, position, arrayList);

                for(int i=0; i<arrayList.size(); i++){
                    if(arrayList.get(i).getBool()){
                        arrayList.get(i).setBool(false);
                    }
                }

                arrayList.get(position).setBool(true);
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView time;
        MaterialCardView card;

        public myviewholder(@NonNull View itemView) {
            super(itemView);

            card = itemView.findViewById(R.id.card);
            time = itemView.findViewById(R.id.time);
        }
    }
}