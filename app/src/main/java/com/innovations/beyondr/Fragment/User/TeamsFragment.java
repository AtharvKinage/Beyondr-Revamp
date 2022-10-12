package com.innovations.beyondr.Fragment.User;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.PackagesBuy;
import com.amplifyframework.datastore.generated.model.PaymentCompletionStatus;
import com.innovations.beyondr.Adapter.TeamPackagesBroughTRecyclerAdapter;
import com.innovations.beyondr.R;

import java.util.ArrayList;

import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;


public class TeamsFragment extends Fragment {
    private Context context;
    View view;
    TeamPackagesBroughTRecyclerAdapter packageRecyclerAdapter;
    ArrayList<PackagesBuy> doctorArrayListPackages = new ArrayList<>();


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.teamfragment,container,false);
        init();
        return view;
    }

    private void init() {
        initElements();
        initListeners();
        initActions();

    }
    private void initActions() {
    }

    private void initListeners() {
    }
    private void initElements() {

        Amplify.API.query(
                ModelQuery.list(PackagesBuy.class, PackagesBuy.USER_ID.eq(Amplify.Auth.getCurrentUser().getUserId()).and(PackagesBuy.PAYMENT_COMPLETION_STATUS.eq(PaymentCompletionStatus.PAYMENTCOMPLETED))),
                response -> {
                    if (String.valueOf(response.getData().getItems()) == "[]") {
                        Log.e("MyAmplifyApp", "doctorresponse" + " null");
                        runOnUiThread(() -> {
                            if (doctorArrayListPackages.size()>0){
                                LinearLayout lottieAnimationView = view.findViewById(R.id.animationView);
                                lottieAnimationView.setVisibility(View.GONE);
                            }else {
                                LinearLayout lottieAnimationView = view.findViewById(R.id.animationView);
                                lottieAnimationView.setVisibility(View.VISIBLE);
                            }
                        });
                    }

                    for (PackagesBuy todo : response.getData()) {
                        doctorArrayListPackages.add(todo);
                        Log.e("MyAmplifyApp", "Query failure" + doctorArrayListPackages);
                        runOnUiThread(() -> {

                            RecyclerView recyclerView =view.findViewById(R.id.recycler);
                            LinearLayoutManager layoutManager2
                                    = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                            recyclerView.setLayoutManager(layoutManager2);

                            packageRecyclerAdapter = new TeamPackagesBroughTRecyclerAdapter(doctorArrayListPackages,context);
                            recyclerView.setAdapter(packageRecyclerAdapter);
                            packageRecyclerAdapter.notifyDataSetChanged();
                        });
//                    }
                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );

    }

}
