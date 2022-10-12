package com.innovations.beyondr.Adapter;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.DoctorType;
import com.amplifyframework.datastore.generated.model.PackagesBuy;
import com.innovations.beyondr.Activity.User.PackageTeamActivity;
import com.innovations.beyondr.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class TeamPackagesBroughTRecyclerAdapter extends RecyclerView.Adapter<TeamPackagesBroughTRecyclerAdapter.myviewholder> {
    ArrayList<PackagesBuy> packages;
    Context context;

    public TeamPackagesBroughTRecyclerAdapter(ArrayList<PackagesBuy> packages, Context context) {
        this.packages = packages;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.packagebroughtrecycleruser, parent, false);
        return new TeamPackagesBroughTRecyclerAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

        holder.numofappointments.setText("Number of Appointments included : " +packages.get(position).getNumofappointments());
        holder.packagesprice.setText("₹" + packages.get(position).getConsultationfees());
        holder.validity.setText("Validity (in months ) : " + packages.get(position).getValidity() + " Months");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd yyyy ",
                Locale.getDefault());

        holder.date.setText("Package Purchase Date : " + dateFormat.format(packages.get(position).getDate().toDate()));
        holder.numofappointused.setText("Number of Appointments taken from Package:  "  +packages.get(position).getNumberofappointmentsused());
        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PackageTeamActivity.class);
                intent.putExtra("id", packages.get(position).getDoctorId());
                if (packages.get(position).getDoctortype() == DoctorType.COACH){
                    intent.putExtra("num", 2);
                }
                if (packages.get(position).getDoctortype() == DoctorType.DOCTOR){
                    intent.putExtra("num", 1);
                }
                context.startActivity(intent);
            }
        });
        Temporal.DateTime date= packages.get(position).getDate();
        Date date1 = date.toDate();
        Date date10= new GregorianCalendar(date1.getYear(), date1.getMonth() + Integer.parseInt(packages.get(position).getValidity()), date1.getDay()).getTime();
        Log.e("TAG", "Date12" + date10);
        Log.e("TAG", "Date122" + addOneMonth(date1, Integer.parseInt(packages.get(position).getValidity())));
        Date  collectpaymentdate = addOneMonth(date1, Integer.parseInt(packages.get(position).getValidity()));
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy ");//format
        SimpleDateFormat defaultDateFormat = new SimpleDateFormat("EEE MMM dd yyyy ", Locale.getDefault());
        Date today = Calendar.getInstance().getTime();
        String date110 = formatter.format(today);
        String date2 = formatter.format(collectpaymentdate);


        Log.e("MyAmplifyApp", "Query" + date110);
        try {
            Date myDate = defaultDateFormat.parse(date110);
            Date myDate2 = defaultDateFormat.parse(date2);
            holder.packageexpiredate.setText("Package Expiration Date : " + formatter.format(myDate2));




            if (myDate.compareTo(myDate2) == 0 || myDate.compareTo(myDate2) < 0) {
                holder.status.setText("ACTIVE");
            } else {
                holder.status.setText("EXPIRED");
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public static Date addOneMonth(Date date, int amount)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, amount);
        return cal.getTime();
    }

    @Override
    public int getItemCount() {
        return packages.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        TextView numofappointments , validity,packagesprice, numofappointused, date, packageexpiredate, status;
        ImageView delete;
        CardView edit;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            numofappointused = itemView.findViewById(R.id.numofappointused);
            numofappointments = itemView.findViewById(R.id.opCat);
            packageexpiredate = itemView.findViewById(R.id.expiredate);
            status = itemView.findViewById(R.id.status);
            date = itemView.findViewById(R.id.date);
            validity = itemView.findViewById(R.id.opValidity);
            packagesprice = itemView.findViewById(R.id.opPrice);
            edit = itemView.findViewById(R.id.edit);
        }
    }
}