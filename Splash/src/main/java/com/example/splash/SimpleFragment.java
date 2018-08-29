package com.example.splash;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class SimpleFragment extends Fragment {

    private View mView;
    private RecyclerView mRecyclerview;
    private ArrayList<Integer> mArrayList = new ArrayList<>();
    private RecyclerViewAdapter mAdapter;
    private ImageView mDefaultIv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_simple, null);
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        intiView();
        initRecyclerView();
        loadData();
    }

    private void loadData() {
        for (int i = 0; i < 20; i++) {
            mArrayList.add(i);
        }
        mAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mRecyclerview.setAdapter(mAdapter = new RecyclerViewAdapter(getActivity(), mArrayList));
//        mDefaultIv.setVisibility(View.VISIBLE);
    }

    private void intiView() {
        mRecyclerview = (RecyclerView) mView.findViewById(R.id.recyclerview);
        mDefaultIv = (ImageView) mView.findViewById(R.id.default_iv);
    }
}
