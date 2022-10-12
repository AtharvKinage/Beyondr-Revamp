package com.innovations.beyondr.Notifications;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.api.ApiOperation;
import com.amplifyframework.api.graphql.GraphQLResponse;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.api.graphql.model.ModelSubscription;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Notifications;
import com.innovations.beyondr.R;

import java.util.ArrayList;

public class NotificationsActivityUser extends AppCompatActivity {
    NotificationsRecyclerAdapterUser doctorRecyclerAdapter;
   ArrayList<Notifications> doctorArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications_user);


        Amplify.API.query(
                ModelQuery.list(Notifications.class, Notifications.USERID.eq(Amplify.Auth.getCurrentUser().getUserId())),
                response -> {
                    Log.e("TAG", "Error" + response);
                    for (Notifications todo : response.getData()) {
                            doctorArrayList.add(todo);
                          //  Log.e("ApiQuickStart", "Subscription failed" + doctorArrayList);

                        runOnUiThread(() -> {

                            RecyclerView recyclerView =
                                    findViewById(R.id.recycler);
                            NotificationsRecyclerAdapterUser doctorRecyclerAdapter = new
                                    NotificationsRecyclerAdapterUser(doctorArrayList,NotificationsActivityUser.this);


                            doctorRecyclerAdapter.notifyDataSetChanged();

                            recyclerView.setAdapter(doctorRecyclerAdapter);
                        });
                   }
 //                   }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );

        ApiOperation subscription = Amplify.API.subscribe(
                ModelSubscription.onCreate(Notifications.class),
                onEstablished -> Log.i("ApiQuickStart", "Subscription established"),
                this::onNewMessageReceived,
                //  onCreated -> Log.i("ApiQuickStart", "Todo create subscription received: " + ((Doctor) onCreated.getData()).getName()),
                onFailure -> Log.e("ApiQuickStart", "Subscription failed", onFailure),
                () -> Log.i("ApiQuickStart", "Subscription completed")
        );
        subscription.cancel();
    }
    private  void onNewMessageReceived(GraphQLResponse<Notifications> tGraphQLResponse) {
        Notifications message = tGraphQLResponse.getData();
        doctorArrayList.add(message);
        runOnUiThread(() -> doctorRecyclerAdapter.notifyDataSetChanged());
    }
    public void back(View view) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}