package com.innovations.beyondr.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.core.Amplify;

import com.amplifyframework.datastore.generated.model.Allergies;
import com.innovations.beyondr.R;


import java.util.ArrayList;

public class AllergiesRecyclerAdapter extends RecyclerView.Adapter<AllergiesRecyclerAdapter.myviewholder> {
    ArrayList<Allergies> allergies;
    Context context;

    public AllergiesRecyclerAdapter(ArrayList<Allergies> allergies, Context context) {
        this.allergies = allergies;
        this.context = context;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.allergiesrecycler, parent, false);
        return new AllergiesRecyclerAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
      holder.allergy.setText(allergies.get(position).getAllergyname());
        holder.description.setText(allergies.get(position).getDescription());
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Allergies allerg = allergies.get(position).copyOfBuilder()
                        .build();
                Amplify.API.mutate(
                        ModelMutation.create(allerg),
                        response -> Log.e("MyAmplifyApp", "Create failed" + response),
                        error -> Log.e("MyAmplifyApp", "Create failed", error)
                );
                allergies.remove(allerg);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return allergies.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
    TextView allergy , description;
        ImageView delete;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            allergy = itemView.findViewById(R.id.allergy);
            delete = itemView.findViewById(R.id.delete);
            description = itemView.findViewById(R.id.description);



        }
    }
}
