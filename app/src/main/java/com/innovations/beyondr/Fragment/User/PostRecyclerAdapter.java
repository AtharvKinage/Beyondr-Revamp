package com.innovations.beyondr.Fragment.User;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.api.ApiOperation;
import com.amplifyframework.api.graphql.GraphQLRequest;
import com.amplifyframework.api.graphql.GraphQLResponse;
import com.amplifyframework.api.graphql.PaginatedResult;
import com.amplifyframework.api.graphql.model.ModelMutation;
import com.amplifyframework.api.graphql.model.ModelPagination;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.api.graphql.model.ModelSubscription;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.datastore.generated.model.Doctor;
import com.amplifyframework.datastore.generated.model.Likes;
import com.amplifyframework.datastore.generated.model.Post;
import com.amplifyframework.datastore.generated.model.PostType;
import com.amplifyframework.datastore.generated.model.UserDatabase;
import com.amplifyframework.datastore.generated.model.VideoType;
import com.amplifyframework.storage.result.StorageGetUrlResult;
import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.innovations.beyondr.Activity.User.CommentsActivity;
import com.innovations.beyondr.Activity.User.LikesActivity;
import com.innovations.beyondr.Common.Util;
import com.innovations.beyondr.R;
import com.like.LikeButton;
import com.like.OnLikeListener;

import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.myViewHolder> {
    ArrayList<Post> arrayList;
    URL url;
    String numberoflikes;
    Likes likes;
    int number;
    Context context;
    ArrayList<Likes> likesArrayList = new ArrayList<>();
    int UserType;

    public PostRecyclerAdapter(ArrayList<Post> arrayList, Context context, int number, int UserType) {
        this.arrayList = arrayList;
        this.context = context;
        this.number = number;
        this.UserType = UserType;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.postrecycler, parent, false);
        return new PostRecyclerAdapter.myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        if (number == 1){
            holder.profileimage.setVisibility(View.GONE);
        }
        if (number == 2){
            if (arrayList.get(position).getPostType() == PostType.NormalPost){
                Amplify.Storage.getUrl(
                        arrayList.get(position).getUserId() + "profilepic" ,
                        // this::onNewMessageReceived,
                        //sucess-> putimage(holder, ),
                        result -> putimage2(holder,result.getUrl() ),
                        error -> Log.e("MyAmplifyApp", "URL generation failure", error)
                );

            }else if (arrayList.get(position).getPostType() == PostType.LearningsWellnesPost){
                Amplify.Storage.getUrl(
                        arrayList.get(position).getUserId() + "doctorpic" ,
                        // this::onNewMessageReceived,
                        //sucess-> putimage(holder, ),
                        result -> putimage2(holder,result.getUrl() ),
                        error -> Log.e("MyAmplifyApp", "URL generation failure", error)
                );
            }

            holder.profileimage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                }
            });
        }
        holder.title.setText(arrayList.get(position).getTitle());
        if (arrayList.get(position).getImage() == true){

            if (arrayList.get(position).getImagetype() == VideoType.IMAGE){
                holder.postimage.setVisibility(View.VISIBLE);
                holder.videoView.setVisibility(View.GONE);
                Amplify.Storage.getUrl(
                        arrayList.get(position).getId(),
                        // this::onNewMessageReceived,
                        //sucess-> putimage(holder, ),

                        result -> putimage(holder,result.getUrl() ),
                        error -> Log.e("MyAmplifyApp", "URL generation failure", error)
                );
            }else if (arrayList.get(position).getImagetype() == VideoType.VIDEO){
                holder.postimage.setVisibility(View.GONE);
                holder.videoView.setVisibility(View.VISIBLE);
                Amplify.Storage.getUrl(
                        arrayList.get(position).getId(),
                        // this::onNewMessageReceived,
                        //sucess-> putimage(holder, ),
                        result -> putvideo(holder,result.getUrl() ),
                        error -> Log.e("MyAmplifyApp", "URL generation failure", error)
                );
            }


        }

        if (arrayList.get(position).getPostType() == PostType.NormalPost){
            Amplify.API.query(
                    ModelQuery.list(UserDatabase.class, UserDatabase.USER_ID.eq(arrayList.get(position).getUserId())),
                    response -> {
                        for (UserDatabase todo : response.getData()) {
                            runOnUiThread(() -> {
                                //  holder.name.setText("Post By -" + todo.getName());
                                holder.Fullname.setText(todo.getName() );
                                holder.location.setText(todo.getCity());

                            });
                        }
                    },
                    error -> Log.e("MyAmplifyApp", "Query failure", error)
            );

        }else if (arrayList.get(position).getPostType() == PostType.LearningsWellnesPost){
            Amplify.API.query(
                    ModelQuery.list(Doctor.class, Doctor.USER_ID.eq(arrayList.get(position).getUserId())),
                    response -> {
                        for (Doctor todo : response.getData()) {
                            runOnUiThread(() -> {
                                holder.name.setText("Post By -" + todo.getName());
                                holder.Fullname.setText(todo.getName() );
                                holder.location.setText(todo.getSpecialization());
                            });
                        }
                    },
                    error -> Log.e("MyAmplifyApp", "Query failure", error)
            );
        }
        Amplify.API.query(
                ModelQuery.list(Likes.class, Likes.USER_ID.eq(Amplify.Auth.getCurrentUser().getUserId()).and(Likes.POST_ID.eq(arrayList.get(position).getId()))),
                response -> {
                    for (Likes todo : response.getData()) {
                        runOnUiThread(() -> {
                            if (todo != null){
                                holder.likeButton.setLiked(true);
                            }else {
                                holder.likeButton.setLiked(false);
                            }
                        });

                    }
                },
                error -> Log.e("MyAmplifyApp", "Query failure", error)
        );
        // holder.numoflikes.setText(arrayList.get(position).getNumberoflikes() + " Likes");
        //  holder.numoflikes.setText(String.valueOf(queryFirstPage()));
        holder.numoflikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(context, LikesActivity.class);
                intent.putExtra("postid",arrayList.get(position).getId());
                context.startActivity(intent);
            }
        });
        holder.description.setText(arrayList.get(position).getDescription());
        holder.comments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =  new Intent(context, CommentsActivity.class);
                intent.putExtra("postid",arrayList.get(position).getId());
                intent.putExtra("num", UserType);
                context.startActivity(intent);
            }
        });
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
//                Locale.getDefault());
        //holder.date.setText(dateFormat.format(arrayList.get(position).getDate().toDate()));

        Temporal.DateTime date = arrayList.get(position).getDate();
        Date date1 = date.toDate();
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd yyyy " );//formating according to my need
        String date2 = formatter.format(date1);
        long fromOffset = arrayList.get(position).getDate().getOffsetTotalSeconds();
        long toOffset = getOffset();
        long convertedTime = arrayList.get(position).getDate().toDate().getTime() - (fromOffset - toOffset);
        Date convertedDate = new Date(convertedTime);
        int hours = convertedDate.getHours();
        int minutes = convertedDate.getMinutes();
        String time = (hours < 10 ? "0" + Integer.toString(hours) : Integer.toString(hours))
                + ":" + (minutes < 10 ? "0" + Integer.toString(minutes) : Integer.toString(minutes));


        holder.date.setText( DateFormat.getDateInstance().format(convertedDate) + " " + time);
        holder.likeButton.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {
                holder.likeButton.setLiked(true);
                Likes likes = Likes.builder()
                        .postId(arrayList.get(position).getId())
                        .date(new Temporal.DateTime(new Date(), getOffset()))
                        .userId(Amplify.Auth.getCurrentUser().getUserId())
                        .build();
                likesArrayList.add(likes);
                notifyDataSetChanged();
                numberoflikes = arrayList.get(position).getNumberoflikes();
                Integer numberoflikesfinal = Integer.parseInt(numberoflikes) + 1;
                Post post = arrayList.get(position).copyOfBuilder()
                        .numberoflikes(String.valueOf(numberoflikesfinal))
                        .build();
                // holder.numoflikes.setText(String.valueOf(numberoflikesfinal ));

                Amplify.API.mutate(
                        ModelMutation.create(likes),
                        sucess->

                                Util.sendNotification(context, "Greetings", "Someone liked on your post", arrayList.get(position).getUserId())

                        ,
                        error ->  Log.e("TAG", "D" +error)
                );
                Amplify.API.mutate(
                        ModelMutation.update(post),
                        sucess->  Log.e("TAG", "D" ) ,
                        error ->  Log.e("TAG", "D" +error));

            }

            @Override
            public void unLiked(LikeButton likeButton) {
                holder.likeButton.setLiked(false);
                Amplify.API.query(
                        ModelQuery.list(Likes.class, Likes.USER_ID.eq(Amplify.Auth.getCurrentUser().getUserId()).and(Likes.POST_ID.eq(arrayList.get(position).getId()))),
                        response -> {
                            for (Likes todo : response.getData()) {
                                runOnUiThread(() -> {
                                    likesArrayList.remove(todo);
                                    notifyDataSetChanged();
                                    Amplify.API.mutate(
                                            ModelMutation.delete(todo),
                                            sucess-> Log.e("TAG", "D" ),
                                            error ->  Log.e("TAG", "D" +error)
                                    );

                                });
                            }
                        },
                        error -> Log.e("MyAmplifyApp", "Query failure", error)
                );
                numberoflikes = arrayList.get(position).getNumberoflikes();
                Integer numberoflikesfinal = Integer.parseInt(numberoflikes) - 1;
                Post post = arrayList.get(position).copyOfBuilder()
                        .numberoflikes(String.valueOf(numberoflikesfinal))
                        .build();


                Amplify.API.mutate(
                        ModelMutation.update(post),
                        sucess->  Log.e("TAG", "D" ) ,
                        error ->  Log.e("TAG", "D" +error));

            }
        });
    }
    private void putvideo(myViewHolder holder, URL url) {
        holder.videoView.setVisibility(View.VISIBLE);
        if (url != null){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.e("TAG", "D" + url );
                    holder.videoView.setVideoPath(String.valueOf(url));
                }
            });
        }
    }

    private void putimage2(myViewHolder holder, URL url) {

        if (url != null){
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    Log.e("TAG", "D" + url );
                    Glide.with(holder.profileimage.getContext())
                            .load(url)
                            .placeholder(R.drawable.profile)
                            .into(holder.profileimage);
                }
            });
        }
    }

    private void putimage(myViewHolder holder, URL url) {
        holder.postimage.setVisibility(View.VISIBLE);
        if (url != null){
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Log.e("TAG", "D" + url );
                    holder.postimage.setVisibility(View.VISIBLE);
                    Glide.with(holder.postimage.getContext())
                            .load(url)
                            .into(holder.postimage);
                }
            });
        }
    }

    private void onNewMessageReceived(StorageGetUrlResult storageGetUrlResult) {

        url =storageGetUrlResult.getUrl();



    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        TextView title, description, numoflikes, name ;
        LikeButton likeButton;
        ShapeableImageView postimage;
        ShapeableImageView profileimage;
        LinearLayout comments;
        TextView date;
        VideoView videoView;
        TextView Fullname, location;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoview);
            Fullname = itemView.findViewById(R.id.fullname);
            location = itemView.findViewById(R.id.location);
            profileimage = itemView.findViewById(R.id.profile_image);
            title = itemView.findViewById(R.id.post);
            name= itemView.findViewById(R.id.name);
            numoflikes= itemView.findViewById(R.id.numoflikes);
            comments= itemView.findViewById(R.id.comments);
            postimage= itemView.findViewById(R.id.postimage);
            description = itemView.findViewById(R.id.description);
            likeButton = itemView.findViewById(R.id.star_button);
            date = itemView.findViewById(R.id.date);
        }
    }
    public int queryFirstPage() {
        dosubscription();
        return   query(likesArrayList,context,ModelQuery.list(Likes.class, ModelPagination.limit(1000000000)));


    }

    private static int query(ArrayList doctorArrayList , Context context, GraphQLRequest<PaginatedResult<Likes>> request) {
        Amplify.API.query(
                request,
                response -> {
                    if (response.hasData()) {
                        for (Likes todo : response.getData()) {
                            doctorArrayList.add(todo);
//                        Log.e("Amplify", "Id " + item);
                            runOnUiThread(() -> {


                            });
//                    }

                        }
                        if (response.getData().hasNextResult()) {
                            query(doctorArrayList,context,response.getData().getRequestForNextResult());
                        }
                    }
                },
                failure -> Log.e("MyAmplifyApp", "Query failed.", failure)
        );
        return  doctorArrayList.size();

    }

    private void dosubscription() {

        ApiOperation subscription = Amplify.API.subscribe(
                ModelSubscription.onCreate(Likes.class),
                onEstablished -> Log.i("ApiQuickStart", "Subscription established"),
                this ::onNewMessageReceived,
                //  onCreated -> Log.i("ApiQuickStart", "Todo create subscription received: " + ((Doctor) onCreated.getData()).getName()),
                onFailure -> Log.e("ApiQuickStart", "Subscription failed", onFailure),
                () -> Log.i("ApiQuickStart", "Subscription completed")
        );
        subscription.cancel();
    }
    private  void onNewMessageReceived(GraphQLResponse<Likes> tGraphQLResponse) {
        Likes message = tGraphQLResponse.getData();
        likesArrayList.add(message);
        runOnUiThread(() -> notifyDataSetChanged());
    }
    private int getOffset() {
        GregorianCalendar calendar = new GregorianCalendar();
        TimeZone timeZone = calendar.getTimeZone();
        int rawOffset = timeZone.getRawOffset();
        return (int) TimeUnit.SECONDS.convert(rawOffset, TimeUnit.MILLISECONDS);
    }
}