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

import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Doctor;
import com.amplifyframework.datastore.generated.model.DoctorType;
import com.bumptech.glide.Glide;
import com.google.android.material.card.MaterialCardView;
import com.innovations.beyondr.Activity.User.AppointmentBookActivity;
import com.innovations.beyondr.Activity.User.DoctorProfilebyBookAnAppointment;
import com.innovations.beyondr.R;

import java.net.URL;
import java.util.ArrayList;

import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;

public class DoctorRecyclerAdapter extends RecyclerView.Adapter<DoctorRecyclerAdapter.myViewHolder> {
    ArrayList<Doctor> arrayList;
    Context context;
    Boolean doctor;



    public DoctorRecyclerAdapter(ArrayList<Doctor> arrayList, Context context,Boolean doctor) {
        this.arrayList = arrayList;
        this.context = context;
        this.doctor = doctor;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.doctorprofilerecycler, parent, false);
        return new DoctorRecyclerAdapter.myViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        Amplify.Storage.getUrl(
                arrayList.get(position).getUserId() + "doctorpic" ,
                // this::onNewMessageReceived,
                //sucess-> putimage(holder, ),
                result -> putimage2(holder,result.getUrl() ),
                error -> Log.e("MyAmplifyApp", "URL generation failure", error)
        );
        holder.name.setText(arrayList.get(position).getName());
        holder.specialization.setText(arrayList.get(position).getSpecialization());
        holder.location.setText(arrayList.get(position).getCountry() + "," + arrayList.get(position).getState());
        if (arrayList.get(position).getInsurance().trim() == "1"){
            holder.insurace.setText("Not Accepted");
        }
        if (arrayList.get(position).getInsurance().trim() != "1"){
            holder.insurace.setText("Accepted");

        }
        holder.clinicaddress.setText(arrayList.get(position).getLocaladdress() +" " +arrayList.get(position).getCountry() + " " +arrayList.get(position).getZipcode());
//
//        holder.imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                holder.card2.setVisibility(View.VISIBLE);
//                holder.about.setText(arrayList.get(position).getAbout());
//
//            }
//        });
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DoctorProfilebyBookAnAppointment.class);
                if (arrayList.get(position).getDoctortype() == DoctorType.COACH){
                    intent.putExtra("docorcoach", 2);
                }
                if (arrayList.get(position).getDoctortype() == DoctorType.DOCTOR){
                    intent.putExtra("docorcoach", 1);
                }
                intent.putExtra("id", arrayList.get(position).getId());
                intent.putExtra("userid", arrayList.get(position).getUserId());
                intent.putExtra("name",arrayList.get(position).getName());
                intent.putExtra("specialization",arrayList.get(position).getSpecialization());
                intent.putExtra("about",arrayList.get(position).getAbout());
                intent.putExtra("country",arrayList.get(position).getCountry());
                // intent.putExtra("",arrayList.get(position).getCountry());
                intent.putExtra("gender",arrayList.get(position).getGender());
                intent.putExtra("languagesspoken",arrayList.get(position).getLanguagesspoken());
                intent.putExtra("npi",arrayList.get(position).getNpi());
                intent.putExtra("yoe",arrayList.get(position).getYearsofexxperience());

                context.startActivity(intent);
            }
        });
        holder.bookmyappointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(context, AppointmentBookActivity.class);
                intent1.putExtra("id",arrayList.get(position).getId());
                intent1.putExtra("userid",arrayList.get(position).getUserId());
                if (doctor == false) {
                    intent1.putExtra("doctor", false);
                }else {
                    intent1.putExtra("doctor", true);
                }
                context.startActivity(intent1);
            }
        });


    }

    private void putimage2(myViewHolder holder, URL url) {
        if (url != null){
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    Log.e("TAG", "D" + url );
                    Glide.with(holder.profilepic.getContext())
                            .load(url)
                            .placeholder(R.drawable.profile)
                            .into(holder.profilepic);
                }
            });
        }
    }

    private void getImage(URL url, DoctorRecyclerAdapter.myViewHolder holder) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //   Log.e("MyAmplifyApp", "URL generation failure" + url);
//                Glide.with(context)
//                        .load(url)
//                        .placeholder(R.drawable.profile)
//                        .error(R.drawable.profile)
//                        .into(holder.profilepic);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView, profilepic;
        TextView name , specialization , location, about , education, insurace, clinicaddress;
        MaterialCardView card,card2;
        LinearLayout message, bookmyappointment;
        ImageView messageImage;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            about = itemView.findViewById(R.id.about);
            education = itemView.findViewById(R.id.education);
            clinicaddress = itemView.findViewById(R.id.aa);
            messageImage = itemView.findViewById(R.id.messageimage);
            insurace = itemView.findViewById(R.id.aboutandeducation);

            profilepic =itemView.findViewById(R.id.profile_image);
            imageView= itemView.findViewById(R.id.imageprofileslidedown);
            name = itemView.findViewById(R.id.name);
            specialization = itemView.findViewById(R.id.aaa);
            card = itemView.findViewById(R.id.card);
            location =itemView.findViewById(R.id.location);
            bookmyappointment = itemView.findViewById(R.id.bookmyappointment);


        }
    }
}
