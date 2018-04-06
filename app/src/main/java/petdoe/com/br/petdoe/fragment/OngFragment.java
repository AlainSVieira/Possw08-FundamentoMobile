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

import petdoe.com.br.petdoe.R;
import petdoe.com.br.petdoe.adapter.OngAdapter;

/**
 * Created by Mychelle Rocha on 02/04/2018.
 */
public class OngFragment extends Fragment {
    private OngAdapter adapter;
    private RecyclerView mRecyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.ong_fragment, container, false);


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler);
        mRecyclerView.setLayoutManager(layoutManager);

        final DisplayMetrics displaymetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;



        adapter = new OngAdapter(
                getActivity());
        mRecyclerView.setAdapter(adapter);


        return rootView;
    }
}
