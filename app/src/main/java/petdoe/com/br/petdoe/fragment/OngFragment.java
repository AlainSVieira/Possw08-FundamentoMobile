package petdoe.com.br.petdoe.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.JsonArray;

import java.util.Arrays;
import java.util.List;

import petdoe.com.br.petdoe.R;
import petdoe.com.br.petdoe.adapter.OngAdapter;
import petdoe.com.br.petdoe.model.bo.OngBO;
import petdoe.com.br.petdoe.model.pojo.Ong;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mychelle Rocha on 02/04/2018.
 */
public class OngFragment extends Fragment implements Callback<JsonArray> {
    private OngAdapter adapter;
    private RecyclerView mRecyclerView;
    private List<Ong> mListOng;
    private OngBO ongBO;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.ong_fragment, container, false);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(layoutManager);
        final DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        ongBO = OngBO.getInstance();
        ongBO.listOng(this);
        return rootView;
    }

    @Override
    public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
        Gson gson = new Gson();
        Ong[] list  = gson.fromJson(response.body(), Ong[].class);
        mListOng = Arrays.asList(list);

        adapter = new OngAdapter(
                getActivity(), mListOng);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onFailure(Call<JsonArray> call, Throwable t) {

    }
}
