package com.innovations.beyondr.Fragment.User;

import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.amplifyframework.api.ApiOperation;
import com.amplifyframework.api.graphql.GraphQLRequest;
import com.amplifyframework.api.graphql.GraphQLResponse;
import com.amplifyframework.api.graphql.PaginatedResult;
import com.amplifyframework.api.graphql.model.ModelPagination;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.api.graphql.model.ModelSubscription;
import com.amplifyframework.auth.options.AuthSignOutOptions;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.BroadCast;
import com.amplifyframework.datastore.generated.model.BroadCastStatus;
import com.amplifyframework.datastore.generated.model.Doctor;
import com.amplifyframework.datastore.generated.model.DoctorProfileReview;
import com.amplifyframework.datastore.generated.model.DoctorType;
import com.amplifyframework.datastore.generated.model.Post;
import com.amplifyframework.datastore.generated.model.PostType;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.innovations.beyondr.Activity.Doctor.DoctorDatabase3;
import com.innovations.beyondr.Activity.Doctor.DoctorProfileSubmittedActivity;
import com.innovations.beyondr.Activity.Doctor.IntroActivity;
import com.innovations.beyondr.Activity.Doctor.MainScreenDoc;
import com.innovations.beyondr.Activity.Login.LoginActivity;
import com.innovations.beyondr.Activity.User.CalendarActivityUser;
import com.innovations.beyondr.Activity.User.ContactUsActivity;
import com.innovations.beyondr.Activity.User.InvitesActivity;
import com.innovations.beyondr.Activity.User.NotificationsActivityUser;
import com.innovations.beyondr.Activity.User.UserProfileActivity;
import com.innovations.beyondr.Adapter.BroadCastRecyclerAdapter;
import com.innovations.beyondr.Adapter.BroadCastRunningLIVERecyclerAdapter;
import com.innovations.beyondr.Adapter.NavigationAdapter;
import com.innovations.beyondr.Common.SharedPref;
import com.innovations.beyondr.Model.MainNavModel;
import com.innovations.beyondr.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class HomeFragmentUser extends Fragment {
    PostRecyclerAdapter postRecyclerAdapter;
    ArrayList<Post> postarraylist = new ArrayList<>();
    ArrayList<BroadCast> broadCasts = new ArrayList<>();
    ArrayList<BroadCast> broadCastsupcoming = new ArrayList<>();
    Context context;
    View view;
    TabLayout tabLayout;
    ViewPager viewPager;
    private Toolbar mainToolbar;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle barDrawerToggle;
    private ListView navListView;
    private List<MainNavModel> navModelList = new ArrayList<>();
    private NavigationView navigationView;
    private View headerView;
    private ImageView navHeadUserImage;
    private TextView navHeadUserName;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.app_bar_mainuser2, container, false);
        init();
        return view;
    }

    private void init() {
        initElements2();
        initListeners2();
        initActions2();
    }
    public void setuprecyclerviewforbroadcastsessionsupcomingLive() {
        Amplify.API.query(
                ModelQuery.list(BroadCast.class, BroadCast.BROAD_CAST_STATUS.eq(BroadCastStatus.NOTLIVE)),
                response -> {
                    if (String.valueOf(response.getData().getItems()) == "[]") {
                        Log.e("MyAmplifyApp", "doctorresponse" + " null");
                        runOnUiThread(() -> {

                        });
                    }

                    for (BroadCast todo : response.getData()) {
                        runOnUiThread(() -> {
                            Date today = Calendar.getInstance().getTime();//getting date
                            SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy ");//format
                            SimpleDateFormat defaultDateFormat = new SimpleDateFormat("EEE MMM dd yyyy ", Locale.getDefault());
                            String date = formatter.format(today);
                            String date2 = formatter.format(todo.getDate().toDate());
                            Log.e("MyAmplifyApp", "Query" + date);
                            try {
                                Date myDate = defaultDateFormat.parse(date);
                                Date myDate2 = defaultDateFormat.parse(date2);
                                // ||myDate.compareTo(myDate2) < 0
                                //only today broadcast
                                if (myDate.compareTo(myDate2) == 0) {
                                    broadCastsupcoming.add(todo);
                                    Log.e("MyAmplifyApp", "Query" + todo);
                                } else {

                                }
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }


                            runOnUiThread(() -> {
                                RecyclerView recyclerView =
                                        view.findViewById(R.id.broadcastupcoming);
//                                RecyclerView.LayoutManager manager = new GridLayoutManager(context, 2);
//                                recyclerView.setLayoutManager(manager);
                                LinearLayoutManager layoutManager2
                                        = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
                                recyclerView.setLayoutManager(layoutManager2);
                                BroadCastRecyclerAdapter doctorRecyclerAdapter = new
                                        BroadCastRecyclerAdapter(broadCastsupcoming, context);
//                                Log.e("MyAmplifyApp", "Create " + doctorArrayList);

                                doctorRecyclerAdapter.notifyDataSetChanged();
                                recyclerView.setAdapter(doctorRecyclerAdapter);
                            });

                        });

                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
    }

    public void setuprecyclerviewforbroadcastsessionsrunningLive(){
        Amplify.API.query(
                ModelQuery.list(BroadCast.class, BroadCast.BROAD_CAST_STATUS.eq(BroadCastStatus.LIVE)),
                response -> {
                    if (String.valueOf(response.getData().getItems())  == "[]" ){
                        Log.e("MyAmplifyApp", "doctorresponse" + " null");
                        runOnUiThread(() -> {
                        });
                    }
                    for (BroadCast todo : response.getData()) {
                        runOnUiThread(() -> {
                            Date today = Calendar.getInstance().getTime();//getting date
                            SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy " );//format
                            SimpleDateFormat defaultDateFormat = new SimpleDateFormat("EEE MMM dd yyyy ", Locale.getDefault());
                            String date = formatter.format(today);
                            String date2 = formatter.format(todo.getDate().toDate());
                            Log.e("MyAmplifyApp", "Query" +date);
                            try {
                                Date myDate = defaultDateFormat.parse(date);
                                Date myDate2 = defaultDateFormat.parse(date2);
                                // ||myDate.compareTo(myDate2) < 0
                                //only today broadcast
                                if (myDate.compareTo(myDate2) == 0 ) {
                                    broadCasts.add(todo);
                                    Log.e("MyAmplifyApp", "Query" +todo);
                                }else {
                                }
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }


                            runOnUiThread(() -> {
                                RecyclerView recyclerView =
                                        view.findViewById(R.id.broadcastrunningLIVE);
                                LinearLayoutManager layoutManager2
                                        = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
                                recyclerView.setLayoutManager(layoutManager2);

                                BroadCastRunningLIVERecyclerAdapter doctorRecyclerAdapter = new
                                        BroadCastRunningLIVERecyclerAdapter(broadCasts, context);
                                doctorRecyclerAdapter.notifyDataSetChanged();
                                recyclerView.setAdapter(doctorRecyclerAdapter);
                            });

                        });

                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
    }
    private void initElements2() {
        TextView textView = view.findViewById(R.id.donthaveanaccount);
        if (Amplify.Auth.getCurrentUser() == null){
            textView.setVisibility(View.VISIBLE);
        }else {
            textView.setVisibility(View.GONE);
        }
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(context, LoginActivity.class));
            }
        });

        navigationView = view.findViewById(R.id.navigationView);
        headerView = navigationView.getHeaderView(0);
        String[] navItemName = {"Home", "Profile", "Notification", "Calendar", "Enter as a Doctor", "Invitation", "Contact Us", "Enter as a Coach", "Logout"};
        int[] drawableIds = {R.drawable.homenew, R.drawable.usericonnew, R.drawable.notificationiconnew, R.drawable.appointmenticonnew, R.drawable.doctoriconnew, R.drawable.invitationiconnew
                , R.drawable.contactusiconnew, R.drawable.coachiconnew, R.drawable.logouticonnew};
        for (int i = 0; i < navItemName.length; i++) {
            navModelList.add(new MainNavModel(getResources().getDrawable(drawableIds[i]), navItemName[i]));
        }
        ImageView imageView = view.findViewById(R.id.navigation_header_container);

        drawerLayout = view.findViewById(R.id.drawerLayout);
        barDrawerToggle = new ActionBarDrawerToggle(((AppCompatActivity) getActivity()), drawerLayout, mainToolbar, R.string.open_drawer, R.string.close_drawer);
        navListView = view.findViewById(R.id.nav_list);
        navListView.setAdapter(new NavigationAdapter(this, navModelList));

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START);

                }else {
                    drawerLayout.openDrawer(GravityCompat.START);


                }

            }
        });

    }

    private void initActions2() {
    }

    private void initListeners2() {
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        postarraylist.clear();
        broadCastsupcoming.clear();
        broadCasts.clear();
//        communitiesbookmarked.clear();
//        communities.clear();
//        queryFirstPageforcommunities();
//        ApiOperation subscription = Amplify.API.subscribe(
//                ModelSubscription.onCreate(Communities.class),
//                onEstablished -> Log.i("ApiQuickStart", "Subscription established"),
//                this::onNewMessageReceivedforCommunities,
//                //  onCreated -> Log.i("ApiQuickStart", "Todo create subscription received: " + ((Doctor) onCreated.getData()).getName()),
//                onFailure -> Log.e("ApiQuickStart", "Subscription failed", onFailure),
//                () -> Log.i("ApiQuickStart", "Subscription completed")
//        );
//        subscription.cancel();
        queryFirstPage();
        ApiOperation subscription2 = Amplify.API.subscribe(
                ModelSubscription.onCreate(Post.class),
                onEstablished -> Log.i("ApiQuickStart", "Subscription established"),
                this::onNewMessageReceived,
                //  onCreated -> Log.i("ApiQuickStart", "Todo create subscription received: " + ((Doctor) onCreated.getData()).getName()),
                onFailure -> Log.e("ApiQuickStart", "Subscription failed", onFailure),
                () -> Log.i("ApiQuickStart", "Subscription completed")
        );
        subscription2.cancel();
        setuprecyclerviewforbroadcastsessionsupcomingLive();
        setuprecyclerviewforbroadcastsessionsrunningLive();
    }

    private <T> void onNewMessageReceived(GraphQLResponse<Post> tGraphQLResponse) {
        Post message = tGraphQLResponse.getData();
        postarraylist.add(message);
        runOnUiThread(() -> postRecyclerAdapter.notifyDataSetChanged());
    }

    //For Post
    public void queryFirstPage() {
        query(postarraylist, view, context, ModelQuery.list(Post.class, ModelPagination.limit(1_000)));
    }

    private static void query(ArrayList doctorArrayList, View view, Context context, GraphQLRequest<PaginatedResult<Post>> request) {
        Amplify.API.query(
                request,
                response -> {
                    if (response.hasData()) {
                        for (Post todo : response.getData()) {
                            if (todo.getPostType() == PostType.NormalPost) {
                                doctorArrayList.add(todo);
                            }

                            runOnUiThread(() -> {
                                RecyclerView recyclerView =
                                        view.findViewById(R.id.recycler);
//                                RecyclerView.LayoutManager manager = new GridLayoutManager(context, 2);
//                                recyclerView.setLayoutManager(manager);
                                PostRecyclerAdapter doctorRecyclerAdapter = new
                                        PostRecyclerAdapter(doctorArrayList, context, 2, 1);
//                                Log.e("MyAmplifyApp", "Create " + doctorArrayList);

                                doctorRecyclerAdapter.notifyDataSetChanged();

                                recyclerView.setAdapter(doctorRecyclerAdapter);
                            });
                        }
                        if (response.getData().hasNextResult()) {
                            query(doctorArrayList, view, context, response.getData().getRequestForNextResult());
                        }
                    }
                },
                failure -> Log.e("MyAmplifyApp", "Query failed.", failure)
        );
    }

//Navigation Adapter

    public void gotonotifications() {
        startActivity(new Intent(context, NotificationsActivityUser.class));
    }

    public void contactus() {
        startActivity(new Intent(context, ContactUsActivity.class));
    }

    public void enterasacoach() {
        SharedPref.setVariableInPreferences("docorcoach", "2");
        SharedPref.setBooleanInPreferences("doctor", false, context);
        Amplify.API.query(
                ModelQuery.list(Doctor.class, Doctor.USER_ID.eq(Amplify.Auth.getCurrentUser().getUserId()).and(Doctor.DOCTORTYPE.eq(DoctorType.COACH))),
                response -> {
                    runOnUiThread(() -> {
                        Log.e("MyAmplifyApp", "doctorresponse" + response.getData().getItems());
                        if (String.valueOf(response.getData().getItems()) == "[]") {
                            Log.e("MyAmplifyApp", "doctorresponse" + " null");
                            Intent intent = new Intent(context, IntroActivity.class);
                            context.startActivity(intent);
                        }
                        for (Doctor todo : response.getData()) {
                            Log.e("MyAmplifyApp", "Query" + response.getData());

                            if (response.getData() != null) {
                                Log.e("MyAmplifyApp", "not null doctor" + response.getData());
                                if (todo.getStatus() == DoctorProfileReview.PUBLISHED) {
                                    SharedPref.setVariableInPreferences("docorcoach", "2");
                                    SharedPref.setBooleanInPreferences("doctor", false, context);
                                    Intent intent = new Intent(context, MainScreenDoc.class);
                                    context.startActivity(intent);
                                } else if (todo.getStatus() == DoctorProfileReview.SUBMITTED) {
                                    Intent intent = new Intent(context, DoctorProfileSubmittedActivity.class);
                                    context.startActivity(intent);
                                } else if (todo.getStatus() == DoctorProfileReview.UNDERREVIEW) {
                                    Intent intent = new Intent(context, DoctorDatabase3.class);
                                    context.startActivity(intent);
                                }
                            } else {
                                Log.e("MyAmplifyApp", "doctorresponse" + " null 2");
                                Intent intent = new Intent(context, IntroActivity.class);
                                SharedPref.setVariableInPreferences("docorcoach", "2");
                                context.startActivity(intent);
                            }
                        }
                    });
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );

    }


    public void signout() {
        SharedPref.setBooleanInPreferences("userdata", false, context);
        Amplify.Auth.signOut(
                AuthSignOutOptions.builder().globalSignOut(true).build(),
                () -> context.startActivity(new Intent(context, LoginActivity.class)),
                error -> Log.e("AuthQuickstart", error.toString())
        );
    }


    public void gotoinvites() {
        startActivity(new Intent(context, InvitesActivity.class));
    }


    public boolean closeDrawer() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        }
        return false;
    }


    public void userprofileintent() {
        startActivity(new Intent(context, UserProfileActivity.class));
    }

    public void calendaractivityintent() {
        context.startActivity(new Intent(context, CalendarActivityUser.class));
    }

    public void enterasadoctorintent() {
        SharedPref.setVariableInPreferences("docorcoach", "1");
        SharedPref.setBooleanInPreferences("doctor", true, context);
        Amplify.API.query(
                ModelQuery.list(Doctor.class, Doctor.USER_ID.eq(Amplify.Auth.getCurrentUser().getUserId()).and(Doctor.DOCTORTYPE.eq(DoctorType.DOCTOR))),
                response -> {
                    runOnUiThread(() -> {
                        Log.e("MyAmplifyApp", "doctorresponse" + response.getData().getItems());
                        if (String.valueOf(response.getData().getItems()) == "[]") {
                            Log.e("MyAmplifyApp", "doctorresponse" + " null");
                            Intent intent = new Intent(context, IntroActivity.class);
                            context.startActivity(intent);
                        }
                        for (Doctor todo : response.getData()) {
                            Log.e("MyAmplifyApp", "Query" + response.getData());

                            if (response.getData() != null) {
                                Log.e("MyAmplifyApp", "not null doctor" + response.getData());
                                if (todo.getStatus() == DoctorProfileReview.PUBLISHED) {
                                    Intent intent = new Intent(context, MainScreenDoc.class);
                                    SharedPref.setBooleanInPreferences("doctor", true, context);
                                    context.startActivity(intent);
                                } else if (todo.getStatus() == DoctorProfileReview.SUBMITTED) {
                                    Intent intent = new Intent(context, DoctorProfileSubmittedActivity.class);
                                    context.startActivity(intent);
                                } else if (todo.getStatus() == DoctorProfileReview.UNDERREVIEW) {
                                    Intent intent = new Intent(context, DoctorDatabase3.class);
                                    context.startActivity(intent);
                                }
                            } else {
                                Log.e("MyAmplifyApp", "doctorresponse" + " null 2");
                                Intent intent = new Intent(context, IntroActivity.class);
                                SharedPref.setVariableInPreferences("docorcoach", "1");
                                context.startActivity(intent);
                            }
                        }
                    });
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );


    }
}
