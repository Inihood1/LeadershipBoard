package com.inihood.leardershipboard.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.inihood.leardershipboard.R;
import com.inihood.leardershipboard.adapter.LearningAdapter;
import com.inihood.leardershipboard.api.PlaceHolderApi;
import com.inihood.leardershipboard.model.UsersLearners;
import com.inihood.leardershipboard.util.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LearningLeadersFragment extends Fragment {

    public LearningLeadersFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private LearningAdapter learningAdapter;
    private View view;
    List<UsersLearners> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_learning, container, false);

        list = new ArrayList<>();
        getList();

        return view;
    }

    private void getList() {
        PlaceHolderApi learners = RetrofitClient.getRetrofitInstance().create(PlaceHolderApi.class);
        Call<List<UsersLearners>> call = learners.getTopLearners();
        call.enqueue(new Callback<List<UsersLearners>>() {
            @Override
            public void onResponse(Call<List<UsersLearners>> call, Response<List<UsersLearners>> response) {
                list = response.body();
                initView(list);
            }
            @Override
            public void onFailure(Call<List<UsersLearners>> call, Throwable throwable) {
                Toast.makeText(getActivity(), "Unable to load users", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void initView(List<UsersLearners> learnersList) {
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        learningAdapter = new LearningAdapter(getActivity(), learnersList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(learningAdapter);
        learningAdapter.notifyDataSetChanged();
    }

}

