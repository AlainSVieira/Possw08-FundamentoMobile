package petdoe.com.br.petdoe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.Arrays;
import java.util.List;

import petdoe.com.br.petdoe.R;
import petdoe.com.br.petdoe.adapter.GoalAdapter;
import petdoe.com.br.petdoe.model.bo.OngBO;
import petdoe.com.br.petdoe.model.pojo.Meta;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mychelle Rocha on 02/04/2018.
 */
public class GoalFragment extends Fragment implements Callback<JsonArray> {
    private GoalAdapter adapter;
    private RecyclerView mRecyclerView;
    private List<Meta> mListMeta;
    private OngBO ongBO;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.goal_fragment, container, false);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(layoutManager);
        ongBO = OngBO.getInstance();
        ongBO.listMeta(this);

        /*adapter = new GoalAdapter(
                getActivity()
        );
        mRecyclerView.setAdapter(adapter);*/


        return rootView;
    }

    @Override
    public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
        Gson gson = new Gson();
        Meta[] list  = gson.fromJson(response.body(), Meta[].class);
        mListMeta = Arrays.asList(list);

        adapter = new GoalAdapter(
                getActivity(), mListMeta);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<JsonArray> call, Throwable t) {

    }


}
