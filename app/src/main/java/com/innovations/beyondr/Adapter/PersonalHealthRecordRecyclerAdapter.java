package com.innovations.beyondr.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.datastore.generated.model.Report;
import com.innovations.beyondr.R;


import java.util.ArrayList;

public class PersonalHealthRecordRecyclerAdapter extends RecyclerView.Adapter<PersonalHealthRecordRecyclerAdapter.myviewholder> {
    ArrayList<Report> arrayList;
    Context context;

    public PersonalHealthRecordRecyclerAdapter(ArrayList<Report> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }
    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.personalhealthrecorduser, parent, false);
        return new PersonalHealthRecordRecyclerAdapter.myviewholder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.information.setVisibility(View.VISIBLE);
        holder.summaryname.setText(arrayList.get(position).getSummnaryname());
        holder.labsdosage.setText(arrayList.get(position).getLabsdosage());
        holder.labsname.setText(arrayList.get(position).getLabsname());
        holder.rxdosage.setText(arrayList.get(position).getRxdosage());
        holder.rxname.setText(arrayList.get(position).getRxname());
        holder.dateandtime.setText(arrayList.get(position).getDate().toDate().toString());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView name , dateandtime, specialization ,viewreport, brief,rx , labs , immunity;
        TextView summaryname , summarydosage, rxname , rxdosage , labsname , labsdosage , immunityname , immunitydosage;

        LinearLayout information;
        // ImageView imageView;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            summarydosage =itemView.findViewById(R.id.summarydosage);
            summaryname =itemView.findViewById(R.id.summaryname);
            rxname = itemView.findViewById(R.id.rxname);
            rxdosage  = itemView.findViewById(R.id.rxdosage);
            labsname  = itemView.findViewById(R.id.labsname);
            labsdosage  = itemView.findViewById(R.id.labsdosage);
            dateandtime = itemView.findViewById(R.id.appointmentdate);
            information= itemView.findViewById(R.id.healthrecordinfor);
            //    imageView  = itemView.findViewById(R.id.imageunlocl);
            // rx = itemView.findViewById(R.id.rx);
            viewreport = itemView.findViewById(R.id.viewfullprofile);
        }
    }
}
