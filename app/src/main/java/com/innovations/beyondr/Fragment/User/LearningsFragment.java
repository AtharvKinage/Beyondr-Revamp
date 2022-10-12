package com.innovations.beyondr.Fragment.User;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.amplifyframework.api.graphql.GraphQLRequest;
import com.amplifyframework.api.graphql.PaginatedResult;
import com.amplifyframework.api.graphql.model.ModelPagination;
import com.amplifyframework.api.graphql.model.ModelQuery;
import com.amplifyframework.core.Amplify;
import com.amplifyframework.datastore.generated.model.Post;
import com.amplifyframework.datastore.generated.model.PostType;
import com.innovations.beyondr.R;

import java.util.ArrayList;

import static com.amazonaws.mobile.auth.core.internal.util.ThreadUtils.runOnUiThread;


public class LearningsFragment extends Fragment {
    private Context context;
    View view;
    ArrayList<Post> doctorArrayList = new ArrayList<>();
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.learningsfragmentwellnessuser,container,false);
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
        queryFirstPage();

    }
    private void initElements() {

    }
    public void queryFirstPage() {
        query(doctorArrayList,view,context, ModelQuery.list(Post.class, ModelPagination.limit(1_000)));
    }

    private static void query(ArrayList doctorArrayList, View view , Context context, GraphQLRequest<PaginatedResult<Post>> request) {
        Amplify.API.query(
                request,
                response -> {
                    if (response.hasData()) {
                        for (Post todo : response.getData()) {
                            if (todo.getPostType() == PostType.LearningsWellnesPost){
                                doctorArrayList.add(todo);
                            }

                            runOnUiThread(() -> {
                                RecyclerView recyclerView =
                                        view.findViewById(R.id.learnings);
//                                RecyclerView.LayoutManager manager = new GridLayoutManager(context, 2);
//                                recyclerView.setLayoutManager(manager);
                                PostRecyclerAdapter doctorRecyclerAdapter = new
                                        PostRecyclerAdapter(doctorArrayList,context,2, 1);
//                                Log.e("MyAmplifyApp", "Create " + doctorArrayList);

                                doctorRecyclerAdapter.notifyDataSetChanged();

                                recyclerView.setAdapter(doctorRecyclerAdapter);
                            });
                        }
                        if (response.getData().hasNextResult()) {
                            query(doctorArrayList,view,context,response.getData().getRequestForNextResult());
                        }
                    }
                },
                failure -> Log.e("MyAmplifyApp", "Query failed.", failure)
        );
    }

}
